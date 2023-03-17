package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase {
    //DO NOT PUT CONTROLLER STUFF IN HERE
    private final WPI_TalonSRX intakeMotor;    
    private final DoubleSolenoid pistons;
    private final DigitalInput limitSwitch;

    public IntakeSubsystem() {
        intakeMotor = new WPI_TalonSRX(Constants.INTAKE_MOTOR);
        pistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 0);
        limitSwitch = new DigitalInput(0);

    }

    public boolean hasCube() {
        return limitSwitch.get();
    }

    public void openClaw() {
        pistons.set(Value.kForward);
    }

    public void closeClaw() {
        pistons.set(Value.kReverse);
    }

    public void OperateIntake(double speed){
        intakeMotor.set(speed);

    }
}
