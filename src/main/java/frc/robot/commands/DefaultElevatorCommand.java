package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase{
    private ElevatorSubsystem s_elevator;
    //TELEOP CONTROLS GO HERE    
    public DefaultElevatorCommand(ElevatorSubsystem elevator){
        s_elevator = elevator;
    }

    @Override
    public void execute(){
        s_elevator.elevatorUp(frc.robot.OI.manualelevatorUp());
        s_elevator.elevatorDown(frc.robot.OI.manualelevatorUp());
        s_elevator.elevatorRetraction(frc.robot.OI.manualelevatorUp());
    } 
}
