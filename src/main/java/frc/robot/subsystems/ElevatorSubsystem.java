package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_CANSparkMax;
import frc.robot.commands.elevator.defaultElevatorCommand;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    
    private final Encoder elevatorEncoder;
    private final CANSparkMax l_motor, r_motor; 
    private final MotorControllerGroup m_motor;
    private final DigitalInput upperelevatorlimit, lowerelevatorlimit; 

    private int elevatorPosition = 0

    public ElevatorSystem(){

        l_motor = new CANSparkMax();
        r_motor = new CANSparkMax();
        m_motor = new MotorControllerGroup(l_motor, r_motor);

        upperelevatorlimit = new DigitalInput(0);
        lowerelevatorlimit = new DigitalInput(1);

        // Motor Functions
        public void setSpeed(double speed){
            m_motor.set(speed);
        }

        public int getEncoderPosition() {
            return elevatorEncoder.get();
        }   

        public void PositionCheck(){
            if (lowerelevatorlimit.get()) {
                elevatorPosition = 0;
            }
            else if (upperelevatorlimit.get()){
                elevatorPosition = 2; 
            }
        }
    }
}
