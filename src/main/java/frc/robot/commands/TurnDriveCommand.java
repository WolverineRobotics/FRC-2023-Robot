package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnDriveCommand extends CommandBase{
    private DriveSubsystem s_drive;
    private double yaw, speed;

    private boolean finish;
    //TELEOP CONTROLS GO HERE

    public TurnDriveCommand(DriveSubsystem drive, double yaw, double speed){

        this.s_drive = drive;
        this.speed = speed;
        this.yaw = yaw;
        this.finish = false;

        addRequirements(s_drive);
    }
                                             
    @Override
    public void initialize() {
        s_drive.ResetPositions();
        s_drive.resetYaw();
    }

    @Override
    public void execute() {
        if(s_drive.getGyro().getYaw() > yaw)
        {
            s_drive.tank(-speed, speed);
        }
        else
        {
            s_drive.arcade(0, 0);
            finish = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finish;
    }
}
