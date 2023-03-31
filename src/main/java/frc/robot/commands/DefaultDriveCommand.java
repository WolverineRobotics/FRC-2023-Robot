package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase{
    private DriveSubsystem s_drive;
    private double speed = 0.5, rotate_speed = 0.5;
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
        //if(OI.balance()){
        //    s_drive.balance();
        //}
        //else
        //{
        s_drive.arcade(OI.getDriverSpeed() * speed, OI.getDriverRotation() * rotate_speed);
        //}
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}


