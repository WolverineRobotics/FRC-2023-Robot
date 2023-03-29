package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.commands.elevator.defaultElevatorCommand;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    
    private final Encoder elevatorEncoder;
    private final CANSparkMax l_motor, r_motor; 
    private final MotorControllerGroup m_motor;
    private final DigitalInput upperElevatorLimit, lowerElevatorLimit; 

    private int elevatorPosition = 0

    public ElevatorSystem(){
        
        // Motors
        l_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_A);
        r_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_B);
        m_motor = new MotorControllerGroup(l_motor, r_motor);

        // Limit Switches
        lowerelevatorlimit = new DigitalInput(0);
        upperelevatorlimit = new DigitalInput(1);

        // Architecture says there's an encoder so I'll just leave this here
        elevatorEncoder = new Encoder(Constants.LIFT_ENCODER_A, Constants.LIFT_ENCODER_B, false, EncodingType.k2X);

        // Default Commands -- Temporarily Empty
        public void initDefaultCommand() {
            setDefaultCommand(new DefaultElevatorCommand());
        }

        // *************** //
        // Motor Functions //  
        // *************** //

        public void setSpeed(double speed){
            m_motor.set(speed)
        }

        ///************Part of OI/DefaultElevatorCommand************/// 
        /*
        public void elevatorUp(double speed){ 
            m_motor.set(speed)
        }
        public void elevatorDown(double speed){
            m_motor.set(speed)
        }
        public void autoElevatorRetract(double speed){
            m_motor.set(-1)
        }
        */
        ///********************************************************///

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
                elevatorPosition = 1; // "Approximately" the Middle
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
