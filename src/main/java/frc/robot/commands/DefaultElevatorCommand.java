package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase{
    private ElevatorSubsystem s_elevator;
    //TELEOP CONTROLS GO HERE    
    public DefaultElevatorCommand(ElevatorSubsystem elevator){
        s_elevator = elevator;
    }
}
