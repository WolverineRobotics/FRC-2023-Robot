package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase{
    private CANSparkMax leftSparkMax1;
    private CANSparkMax leftSparkMax2;
    private CANSparkMax rigSparkMax1;
    private CANSparkMax rigSparkMax2;
    private Encoder leftEncoder;
    private Encoder riEncoder;

    private MotorControllerGroup l_group, r_group;
    private DifferentialDrive d_drive;
    //DO NOT PUT CONTROLLER STUFF IN HERE
    public DriveSubsystem(){
        leftSparkMax1 = new CANSparkMax(Constants.DRIVE_LEFT_MOTOR_1, MotorType.kBrushless);
        leftSparkMax2 = new CANSparkMax(Constants.DRIVE_LEFT_MOTOR_2, MotorType.kBrushless);
        
        rigSparkMax1 = new CANSparkMax(Constants.DRIVE_RIGHT_MOTOR_1, MotorType.kBrushless);
        rigSparkMax2 = new CANSparkMax(Constants.DRIVE_RIGHT_MOTOR_2, MotorType.kBrushless);

        leftEncoder = new Encoder(Constants.DRIVE_LEFT_ENCODER_A, Constants.DRIVE_LEFT_ENCODER_B);
        riEncoder = new Encoder(Constants.DRIVE_RIGHT_ENCODER_A, Constants.DRIVE_RIGHT_ENCODER_B);

        l_group = new MotorControllerGroup(leftSparkMax1, leftSparkMax2);
        r_group = new MotorControllerGroup(rigSparkMax1, rigSparkMax2);

        d_drive = new DifferentialDrive(l_group, r_group);

        
    }
    public void driveArcadeMode(double speed, double rotation){
        d_drive.arcadeDrive(speed, rotation);
    }
    
    //sets the speed of the motor (forwards/backwards)
    public void setspeed(double speed){
        d_drive.tankDrive(speed, speed);
    }
    //sets the motors for right side
    public void setrightspeed(double speed){
        r_group.set(speed);
    }

    //sets the motors for left side
    public void setleftspeed(double speed){
        l_group.set(speed);
    }

    //stops the motor
    public void stopmotor(double speed){
        d_drive.tankDrive(0, 0);
    }

    //IT'S NOT PLATINUM ADVENTURE >:( 
    //also decodes encoders
    public Double encoders(String decode){
        if(decode == "left"){
            return leftEncoder.getRate();
        } else if(decode == "right"){
            return riEncoder.getRate();
        }
        else{
            return null;
        }
    }

    

    
    
}
