package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
    //DO NOT PUT CONTROLLER STUFF IN HERE
    private CANSparkMax wheelMotor;  
    private CANSparkMax wristMotor;  

    public IntakeSubsystem() {
        wheelMotor = new CANSparkMax(Constants.INTAKE_WHEEL_MOTOR, MotorType.kBrushless);
        wristMotor = new CANSparkMax(Constants.INTAKE_WRIST_MOTOR, MotorType.kBrushless);

    }

    // Game Piece Intake and Outtake
    public void operateIntake(double speed){
        wheelMotor.set(speed); 
    }

    // Move Wrist Around
    public void operateWrist(double speed) {
        wristMotor.set(speed);
    }
    
    // Get position of Wrist Motor ---- This Function Is Supposed To Check The Distance The Wrist Motor Has Spun
    public void getWristPos(double orientation) {
        wristMotor.getEncoder().getPosition();
    }


}
