package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class DefaultArmCommand extends CommandBase{
    private ArmSubsystem s_arm;
    //TELEOP CONTROLS GO HERE
    public DefaultArmCommand(ArmSubsystem arm){
        s_arm = arm;
    }
}
