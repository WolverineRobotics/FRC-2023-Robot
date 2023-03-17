/*
 * PLEASE CHECK OVER I DONT KNOW WHAT IM DOING
 */



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.OI;

public class DefaultIntakeCommand extends CommandBase{
    private IntakeSubsystem s_intake;

    //TELEOP CONTROLS GO HERE    
    public DefaultIntakeCommand(IntakeSubsystem intake){
        s_intake = intake;
        addRequirements(s_intake);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        // Opening and Closing Claw -- Cone and Release Cone
        if (OI.takeCone()) {
            s_intake.openClaw();
        }

        if (OI.releaseCone()) {
            s_intake.closeClaw();
        }

        // Grab and Release Cube
        if (OI.takeCube() && !s_intake.hasCube()) {
            s_intake.OperateIntake(-1);
        } 

        if (OI.releaseCube() && s_intake.hasCube()) {
            s_intake.OperateIntake(1);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
