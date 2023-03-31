package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.OI;

public class DefaultElevatorCommand extends CommandBase{
    private ElevatorSubsystem s_elevator;
    //TELEOP CONTROLS GO HERE    
    public DefaultElevatorCommand(ElevatorSubsystem elevator){
        s_elevator = elevator;
        addRequirements(s_elevator);
    }
    

    @Override
    public void execute(){
        // Manual Elevator Movement

        s_elevator.elevatorUp(OI.manualelevatorUp());
        s_elevator.elevatorDown(OI.manualelevatorDown());

        // Elevtor Retraction -- Commented Out Because There Are No Limit Switches

        //if (OI.autoelevatorRetraction()) {
        //    s_elevator.elevatorRetraction(-1);
        //}

    } 
}