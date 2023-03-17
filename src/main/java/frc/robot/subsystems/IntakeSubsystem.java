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
    private final DoubleSolenoid cube_piston, cone_piston;
    public IntakeSubsystem() {
        intakeMotor = new WPI_TalonSRX(Constants.INTAKE_MOTOR);

        cube_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 0);
        cone_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 0);

        limitSwitch = new DigitalInput(0);

    }

    public boolean hasCube() {
        return limitSwitch.get();
    }

    public void openClaw(int index) {
        if(index == 0){
            cube_piston.set(Value.kReverse);
        }
        else if (index == 1){
            cone_piston.set(Value.kReverse);
        }

    }

    public void closeClaw(int index) {
        if(index == 0){
            cube_piston.set(Value.kForward);
        }
        else if (index == 1){
            cone_piston.set(Value.kForward);
        }

    }

    //public void OperateIntake(double speed){
    //    intakeMotor.set(speed);
    //}
}
