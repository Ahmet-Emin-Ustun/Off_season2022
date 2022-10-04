// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InTake extends SubsystemBase {

  public Compressor compyTake = new Compressor(null) ;
  public DoubleSolenoid dSolenoid = new DoubleSolenoid(null, Constants.solenoidChannel1forward, Constants.solenoidChannel1reverse);
  public Spark bringer = new Spark(7);
  public Talon intakemotor = new Talon(5);
  public boolean compState = false;
  public boolean Intakestate = false;

  /** Creates a new InTake. */
  public InTake() {
    compyTake.disable();
    dSolenoid.set(Value.kReverse);
  }

  public void Air(){
    compyTake.enableDigital();
  }
  
  public void openIntake(){
   dSolenoid.set(Value.kForward);
   Intakestate = true;
     
  }

  public void closeIntake(){
    dSolenoid.set(Value.kReverse);
    Intakestate = false;
      
  }

  public void runIntakeMotor(double speed){
   intakemotor.set(speed);
  }

  public void intakeoffline(){
    dSolenoid.set(Value.kOff);
  }

  public void sendBalltoshooter(double speed){
     bringer.set(speed);
  }
  public void compyTakeOffline(){
    compyTake.disable();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
