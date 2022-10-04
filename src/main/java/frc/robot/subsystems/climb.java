// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;



import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class climb extends SubsystemBase {
  /** Creates a new climb. */
  public Spark C_motor = new Spark(6);
  Compressor compy = new Compressor(null);
  public DoubleSolenoid DSolenoid = new DoubleSolenoid(null, Constants.solenoidChannel2forward, Constants.solenoidChannel2reverse);


  public climb() {}

  public void getAir(){

    compy.enableDigital();
  }
 
  public void climberUp(){
    
    DSolenoid.set(Value.kForward);
  }

  public void climberDown(){
    
    DSolenoid.set(Value.kReverse);
  }

  public void climbing(){
    C_motor.set(1);
  }

  public void Stop_climbing(){
    C_motor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
