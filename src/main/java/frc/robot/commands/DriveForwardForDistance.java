package frc.robot.commands;

import javax.print.attribute.standard.Finishings;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardForDistance extends CommandBase{
    private DriveSubsystem s_drive;
    private double distance, speed;

    private boolean finish;
    //TELEOP CONTROLS GO HERE

    public DriveForwardForDistance(DriveSubsystem drive, double distance, double speed){

        this.s_drive = drive;
        this.speed = speed;
        this.distance = distance;
        this.finish = false;

        addRequirements(s_drive);
    }

    @Override
    public void initialize() {
        s_drive.ResetPositions();
    }

    @Override
    public void execute() {
        if(s_drive.getAverageDistance() < distance){
            s_drive.arcade(speed, 0);
        }
        else{
            s_drive.arcade(0, 0);
            finish = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finish;
    }
}
