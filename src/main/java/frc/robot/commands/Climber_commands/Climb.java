// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Climber_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.climb;

public class Climb extends SequentialCommandGroup{
  /** Add your docs here. */
  public Climb(climb m_climb) {
    addCommands(new Climb_up(),
     new climb_Down(),
     new climbing());
    
  }

  
}
