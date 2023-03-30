package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase{
    private ElevatorSubsystem s_elevator;
    //TELEOP CONTROLS GO HERE    
    public DefaultElevatorCommand(ElevatorSubsystem elevator){
        s_elevator = elevator;
    }

    /* Commands/OI based off the arm code we went over two weeks ago. 
       From my understanding, "s_elevator" commands call corresponding OI methods after passing specific values,
       then to ElevatorSubsystem to make elevator go brrrr.

       Review if needed.
    */
    
    @Override
    public void execute(){
        s_elevator.elevatorUp(OI.manualElevatorUp());
        s_elevator.elevatorDown(OI.manualElevatorDown());
        s_elevator.elevatorAutoRetract(OI.manualElevatorRetract());
    }

}
