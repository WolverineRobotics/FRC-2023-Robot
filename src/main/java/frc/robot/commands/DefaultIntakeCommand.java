package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends CommandBase{
    private IntakeSubsystem s_intake;
    //TELEOP CONTROLS GO HERE    
    public DefaultIntakeCommand(IntakeSubsystem intake){
        s_intake = intake;
    }
}
