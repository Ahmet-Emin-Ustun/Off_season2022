// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.InTake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class RunIntakeMOtor extends CommandBase {
  private final double speed;
  /** Creates a new RunIntakeMOtor. */
  public RunIntakeMOtor(double speed) {
    this.speed = speed;
    addRequirements(RobotContainer.m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_Intake.runIntakeMotor(speed);
    RobotContainer.m_Intake.sendBalltoshooter(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Intake.runIntakeMotor(0);
    RobotContainer.m_Intake.sendBalltoshooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
