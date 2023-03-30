package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import frc.robot.commands.elevator.defaultElevatorCommand; // WHAT DO YOU MEAN THIS HAS AN ERROR?? 
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{
    
    private final CANSparkMax l_motor, r_motor;
    private final MotorControllerGroup m_motor;
    private final DigitalInput upperlimitSwitch, lowerlimitSwitch;
    private final Encoder elevatorEncoder;

    public int elevatorPosition = 0;

    public ElevatorSubsystem(){

        l_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_A, MotorType.kBrushless);
        r_motor = new CANSparkMax(Constants.ELEVATOR_MOTOR_B, MotorType.kBrushless);
        m_motor = new MotorControllerGroup(l_motor, r_motor);

        lowerlimitSwitch = new DigitalInput(0);
        upperlimitSwitch = new DigitalInput(1);

        elevatorEncoder = new Encoder(Constants.LIFT_ENCODER_A, Constants.LIFT_ENCODER_B, false, Encoder.EncodingType.k2X);
    }

    // *************** //
    // Motor Functions //  
    // *************** //

    /* TIL to not insert the public void methods within the Subsystem method.. Otherwise everything becomes a red-lined mess.
       Revise if needed.
    */ 
  

    public void elevatorUp(double manualelevatorUp) {
        m_motor.set(manualelevatorUp); // This sets the speeds.
    } 

    public void elevatorDown(double manualelevatorDown) {
        m_motor.set(manualelevatorDown);
    }

    public void elevatorRetraction(double manualelevatorRetraction) {
        m_motor.set(-manualelevatorRetraction);
    }

     // ***************** //
    // Positioning Check //  
    // ***************** //

    public boolean upperlimitSwitch(){
        return upperlimitSwitch.get();
    }

    public boolean lowerlimitSwitch(){
        return upperlimitSwitch.get();
    }

    public void PositionCheck(){
        if (upperlimitSwitch.get()){
            elevatorPosition = 2; // Very Top
        } 
        else if (lowerlimitSwitch.get()){
            elevatorPosition = 0; // Very Bottom
        }
        else {
            elevatorPosition = 1; // "Middle" :troll:
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
