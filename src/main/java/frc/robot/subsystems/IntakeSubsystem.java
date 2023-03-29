package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase {
    //DO NOT PUT CONTROLLER STUFF IN HERE
    private final WPI_TalonSRX wheelMotor;  
    private final WPI_TalonSRX wristMotor;  

    public IntakeSubsystem() {
        wheelMotor = new WPI_TalonSRX(Constants.INTAKE_WHEEL_MOTOR);
        wristMotor = new WPI_TalonSRX(Constants.INTAKE_WRIST_MOTOR);

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
        wristMotor.get();
    }
}
