package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.AutoBalancer;
import frc.robot.Constants;

import com.ctre.phoenix.sensors.PigeonIMU;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase{


    private CANSparkMax r_motor_1;
    private CANSparkMax r_motor_2;
    private CANSparkMax l_motor_1;
    private CANSparkMax l_motor_2;

    private RelativeEncoder l_encoder;
    private RelativeEncoder r_encoder;

    private MotorControllerGroup r_drive;
    private MotorControllerGroup l_drive;

    private DifferentialDrive m_drive;

    public DifferentialDrive M_diffDrive(){
        return m_drive;
    }

    private AutoBalancer balancer;
    private PigeonIMU pigeon;

    //DO NOT PUT CONTROLLER STUFF IN HERE

    public DriveSubsystem() {

        // Defining Motors and DifferentialDrive
        r_motor_1 = new CANSparkMax(Constants.DRIVE_RIGHT_MOTOR_1, MotorType.kBrushless);
        r_motor_2 = new CANSparkMax(Constants.DRIVE_RIGHT_MOTOR_2, MotorType.kBrushless);
        l_motor_1 = new CANSparkMax(Constants.DRIVE_LEFT_MOTOR_1, MotorType.kBrushless);
        l_motor_2 = new CANSparkMax(Constants.DRIVE_LEFT_MOTOR_2, MotorType.kBrushless);

        r_drive = new MotorControllerGroup(r_motor_1, r_motor_2);
        l_drive = new MotorControllerGroup(l_motor_1, l_motor_2);

        m_drive = new DifferentialDrive(r_drive, l_drive);

        // Defining Gyroscope
        pigeon = new PigeonIMU(Constants.PIGEON);

        // Defining Encoders
        l_encoder = l_motor_1.getEncoder();
        r_encoder = r_motor_1.getEncoder();

        r_motor_1.setIdleMode(IdleMode.kBrake);
        l_motor_2.setIdleMode(IdleMode.kBrake);
        r_motor_1.setIdleMode(IdleMode.kBrake);
        l_motor_2.setIdleMode(IdleMode.kBrake);

        // Defining Balancer
        balancer = new AutoBalancer(m_drive, pigeon.getPitch());

        l_drive.setInverted(true);


    } 

    // Your goto command for driving arcade... sponsored by KILLBOX
    public void arcade(double speed, double rotation){
        m_drive.arcadeDrive(speed, rotation);
    }
    public void tank(double left, double right){
        m_drive.tankDrive(left, right);
    }

    public double getLeftDistance(){
        return l_encoder.getPosition();
    }
    public double getRightDistance(){
        return r_encoder.getPosition();
    }

    public double getAverageDistance(){
        return (r_encoder.getPosition() + l_encoder.getPosition()) / 2;
    }

    public void ResetPositions(){
        r_encoder.setPosition(0);
        l_encoder.setPosition(0);
    }
    
    public void balance(){
        balancer.balancerPeriodic();
    }

    public void GetPitch(){
        pigeon.getPitch();
    }

    public PigeonIMU getGyro(){
        return pigeon;
    }
    public void resetYaw(){
        pigeon.setYaw(0);
    }
}
