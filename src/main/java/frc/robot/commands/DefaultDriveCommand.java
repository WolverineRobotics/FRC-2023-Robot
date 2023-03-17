package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase{
    private DriveSubsystem s_drive;
    //TELEOP CONTROLS GO HERE
    public DefaultDriveCommand(DriveSubsystem drive){
        s_drive = drive;
    }

    @Override
    public void execute(){
        s_drive.driveArcadeMode(OI.drivespeed(), OI.driverotation());


    }
}
