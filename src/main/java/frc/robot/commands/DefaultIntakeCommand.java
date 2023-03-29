/*
 * PLEASE CHECK OVER I DONT KNOW WHAT IM DOING
 */



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

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
        // Wheel Movement
        if (frc.robot.OI.takeObject()) {
            s_intake.operateIntake(-1);
        }
        if (frc.robot.OI.releaseObject()) {
            s_intake.operateIntake(1);
        }

        // Wrist Movement
        if (frc.robot.OI.moveWristForward()) {
            s_intake.operateWrist(1);
        }
        if (frc.robot.OI.moveWristBackward()) {
            s_intake.operateWrist(-1);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
