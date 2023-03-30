package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;

import frc.robot.commands.elevator.defaultElevatorCommand;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    
    private final Encoder elevatorEncoder;
    private final CANSparkMax l_motor, r_motor; 
    private final MotorControllerGroup m_motor;
    private final DigitalInput upperElevatorLimit, lowerElevatorLimit; 

    private int elevatorPosition = 0;

    public ElevatorSubsystem(){
        
        // Motors
        l_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_A);
        r_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_B);
        m_motor = new MotorControllerGroup(l_motor, r_motor);

        // Limit Switches
        lowerElevatorLimit = new DigitalInput(0);
        upperElevatorLimit = new DigitalInput(1);

        // Encoder
        elevatorEncoder = new Encoder(Constants.LIFT_ENCODER_A, Constants.LIFT_ENCODER_B, false, EncodingType.k2X);

        public void initDefaultCommand() {
            setDefaultCommand(new DefaultElevatorCommand());
        }

        // *************** //
        // Motor Functions //  
        // *************** //

        public void elevatorUp(double speed){ 
            m_motor.set(speed);
        }
        public void elevatorDown(double speed){
            m_motor.set(speed);
        }
        public void elevatorAutoRetract(double speed){
            m_motor.set(-1);
        }

        // ***************** //
        // Positioning Check //  
        // ***************** //

        public boolean getUpperLimitSwitch(){
            return upperElevatorLimit.get();
        }  

        public boolean getLowerLimitSwitch(){
            return lowerElevatorLimit.get(); 
        }  
        
        public void PositionCheck(){
            if (lowerElevatorLimit.get()) {
                elevatorPosition = 0; // Bottom of Elevator
            }
            else if (upperElevatorLimit.get()){
                elevatorPosition = 2; // Top of Elevator
            }
            else {
                elevatorPosition = 1; // "Approximately" Return the Middle :troll:
            }
        }

        // ************************** //
        // Elevator Encoder Functions //  
        // ************************** //

        public int getEncoderPosition(){
            return elevatorEncoder.get();
        } 

        public double getEncoderDistance(){
            return elevatorEncoder.getDistance();
        }
    }
}
