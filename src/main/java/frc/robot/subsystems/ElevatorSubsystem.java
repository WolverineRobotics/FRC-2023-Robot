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
    private final DigitalInput upperelevatorlimit, lowerelevatorlimit; 

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
        elevatorEncoder = new Encoder(Constants.ELEVATOR_ENCODER_A, false, EncodingType.k2X);

        // Motor Speed
        public void setSpeed(double speed){
            m_motor.set(speed);
        }

        // Checks for Elevator Positioning from Limit Switches
        public boolean getUpperLimitSwitch(){
            return upperelevatorlimit.get();
        }  

        public boolean getLowerLimitSwitch(){
            return lowerelevatorlimit.get(); 
        }  
        
        public void PositionCheck(){
            if (lowerelevatorlimit.get()) {
                elevatorPosition = 0; // Bottom of Elevator
            }
            else if (upperelevatorlimit.get()){
                elevatorPosition = 2; // Top of Elevator
            }
            else {
                elevatorPosition = 1; // "Approximately" the Middle
            }
        }

        // Elevator Encoder Stuff -- I can remove this if not needed
        public int getEncoderPosition(){
            return elevatorEncoder.get();
        } 

        public double getEncoderDistance(){
            return elevatorEncoder.getDistance();
        }
    }
}
