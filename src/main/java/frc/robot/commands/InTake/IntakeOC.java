// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.InTake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class IntakeOC extends CommandBase {
  /** Creates a new IntakeOC. */
  public IntakeOC() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    if(RobotContainer.m_Intake.compState = true){
      RobotContainer.m_Intake.Air();
    }
    else{
     RobotContainer.m_Intake.compyTakeOffline();
    }



    if(RobotContainer.m_Intake.Intakestate = false){
      RobotContainer.m_Intake.openIntake();
    }
    else{
      RobotContainer.m_Intake.closeIntake();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Intake.intakeoffline();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
