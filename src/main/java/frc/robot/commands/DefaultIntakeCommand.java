/*
 * PLEASE CHECK OVER I DONT KNOW WHAT IM DOING
 */



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
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
        // NO LIMIT SWITCHES + MOTORS ARE SET TO TALONX + MOTOR IDS ARE NOT SET

        // Wheel Movement
        s_intake.operateIntake(OI.getIntakeSpeed() * 0.5);

        // Wrist Movement 
        s_intake.operateWrist(OI.getWristSpeed() * 0.3);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
