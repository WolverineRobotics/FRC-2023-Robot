// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.DefaultElevatorCommand;
import frc.robot.commands.DefaultIntakeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
  private DriveSubsystem s_drive;
  private ElevatorSubsystem s_elevator;
  private IntakeSubsystem s_intake;
  private AutoBalancer balancer;

  public RobotContainer() {
    configureBindings();
    s_drive = new DriveSubsystem();
    s_elevator = new ElevatorSubsystem();
    s_intake = new IntakeSubsystem();

    s_drive.setDefaultCommand(new DefaultDriveCommand(s_drive));
    s_elevator.setDefaultCommand(new DefaultElevatorCommand(s_elevator));
    s_intake.setDefaultCommand(new DefaultIntakeCommand(s_intake));
  }

  public DriveSubsystem getDrive(){
    return s_drive;
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
