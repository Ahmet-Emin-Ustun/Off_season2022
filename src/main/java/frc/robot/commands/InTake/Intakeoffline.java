// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.InTake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InTake;

public class Intakeoffline extends CommandBase {
  /** Creates a new Intakeoffline. */

   private final InTake Intake;
  public Intakeoffline(InTake Intake) {
     this.Intake= Intake;

     addRequirements(Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Intake.closeIntake();
    Intake.intakeoffline();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
