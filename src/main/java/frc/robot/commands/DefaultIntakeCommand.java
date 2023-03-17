/*
 * PLEASE CHECK OVER I DONT KNOW WHAT IM DOING
 */



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class DefaultIntakeCommand extends CommandBase{
    private IntakeSubsystem s_intake;
    private XboxController hehe; 

    //TELEOP CONTROLS GO HERE    
    public DefaultIntakeCommand(IntakeSubsystem intake){
        s_intake = intake;
        addRequirements(s_intake);

        hehe = new XboxController(Constants.OPERATOR_CONTROLLER);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Opening and Closing Claw -- Cone and Release Cone
        if (hehe.getLeftBumperPressed()) {
            s_intake.openClaw();
        }

        if (hehe.getRightBumperPressed()) {
            s_intake.closeClaw();
        }

        // Grab and Release Cube
        if (hehe.getLeftTriggerAxis() > 0 && !s_intake.hasCube()) {
            s_intake.OperateIntake(Constants.INTAKE_CLAW_REVERSE);
        } 

        if (hehe.getRightTriggerAxis() > 0 && s_intake.hasCube()) {
            s_intake.OperateIntake(Constants.INTAKE_CLAW_FORWARD);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
