// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveForwardForDistance;
import frc.robot.subsystems.DriveSubsystem;


// Distance per inch on motors
// Angles on intake
// Find inverted motordrive

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;


  private RobotContainer m_robotContainer;

  private Command drive_forward_0 = new DriveForwardForDistance(m_robotContainer.getDrive(), 8, 0.5);


  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();
    CommandScheduler.getInstance().run();

    SmartDashboard.updateValues();
  }

  @Override
  public void robotPeriodic() {
    // CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Yaw", m_robotContainer.getDrive().getGyro().getYaw());
    SmartDashboard.putNumber("Pitch", m_robotContainer.getDrive().getGyro().getPitch());
    SmartDashboard.putNumber("Roll", m_robotContainer.getDrive().getGyro().getRoll());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.schedule();
    //}

    CommandScheduler.getInstance().schedule(new DriveForwardForDistance(m_robotContainer.getDrive(), 8, 0.5));

    //drive_forward_0.schedule();

    
  }

  @Override
  public void autonomousPeriodic() {
    // for now, its a time based system lol (kinda)
    
    //CommandScheduler.getInstance().run();

    //int current_timer = 0;
//
    //if(current_timer < 500){
    //  m_robotContainer.getDrive().arcade(1, 0);
    //}
  //
    //if (current_timer < 1500){
    //  m_robotContainer.getDrive().arcade(-0.7, 0);
    //}
    //else{
    //  m_robotContainer.getDrive().arcade(0, 0);
    //}
  //
      //current_timer += 20;

  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopExit() {
    //CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
