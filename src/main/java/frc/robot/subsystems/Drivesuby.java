// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.drive_command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivesuby extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public PWMVictorSPX leftFrontmotor = new PWMVictorSPX(0);
  public PWMVictorSPX leftRearmotor =  new PWMVictorSPX(1);
  public PWMVictorSPX rightFrontmotor = new PWMVictorSPX(2);
  public PWMVictorSPX rightRearmotor =  new PWMVictorSPX(3);
 
  
   public MotorControllerGroup leftmotors = new MotorControllerGroup(leftFrontmotor, leftRearmotor);
   public MotorControllerGroup rightmotors = new MotorControllerGroup(rightFrontmotor, rightRearmotor);

   DifferentialDrive Drive = new DifferentialDrive(leftmotors,rightmotors);


  public Drivesuby() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driving(double move, double turn){

    if(Math.abs(move) < 0.10){

       move = 0;
    }

    if(Math.abs(turn) < 0.10){

      turn = 0;
   }
    Drive.arcadeDrive(move, turn);

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void initDefaultCommand(){

    setDefaultCommand(new drive_command());
  }
}
