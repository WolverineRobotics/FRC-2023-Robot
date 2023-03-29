package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase{
    private DriveSubsystem s_drive;
    //TELEOP CONTROLS GO HERE
    public DefaultDriveCommand(DriveSubsystem drive){
        s_drive = drive;
        addRequirements(s_drive);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}


