// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.drive_command;
import frc.robot.commands.Climber_commands.Climb;
import frc.robot.commands.InTake.IntakeOC;
import frc.robot.commands.InTake.Intakeoffline;
import frc.robot.commands.InTake.RunIntakeMOtor;
import frc.robot.commands.shooter.XAngle;
import frc.robot.commands.shooter.Yangle;
import frc.robot.commands.shooter.shooterFire;
import frc.robot.subsystems.Drivesuby;
import frc.robot.subsystems.InTake;
import frc.robot.subsystems.climb;
import frc.robot.subsystems.shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  public static Drivesuby m_DriveSubsytem = new Drivesuby();
  public static OI oi;
  public static climb m_climb = new climb();
  public static InTake m_Intake = new InTake();
  public static shooter m_shooter = new shooter();


  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    m_DriveSubsytem.setDefaultCommand(new drive_command()); 
    m_Intake.setDefaultCommand(new Intakeoffline(m_Intake));
    m_shooter.setDefaultCommand(new ParallelCommandGroup(new XAngle(), new Yangle()));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(OI.stick, 1).whenPressed(new shooterFire(), true);
    new JoystickButton(OI.stick, 2).whenPressed(new IntakeOC(), true);
    new JoystickButton(OI.stick, 3).whenPressed(new RunIntakeMOtor(1), true);
    new JoystickButton(OI.stick, 4).whenPressed(new Climb(m_climb), false);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
