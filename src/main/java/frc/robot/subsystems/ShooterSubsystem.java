/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShooterSubsystem extends SubsystemBase {
  private Talon leftShooterMotor;
  private Talon rightShooterMotor;
  private Talon kickerMotor;
  private double m_Speed ;
  private Encoder m_Encoder;
  private SpeedControllerGroup ShooterMotors;
  private boolean shootBall;

  /**
   * Creates a new ExampleSubsystem.
   */

  public ShooterSubsystem() {
    leftShooterMotor = new Talon(1);
    rightShooterMotor = new Talon(2);
    rightShooterMotor.setInverted(true);
    ShooterMotors = new SpeedControllerGroup(leftShooterMotor, rightShooterMotor);
    kickerMotor = new Talon(3)

    m_Encoder = new Encoder(0, 1)

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ShooterMotors.setSpeed(1);
    if (shootBall){
      kickerMotor.setSpeed(1);
    if (m_Encoder.getVelocity()< 1000){
      System.out.println("ball shot");
      kickerMotor.setSpeed(0);
    }
    }
    
     
    
  }
  public void setSpeed(double speed ){
  m_Speed = speed;
  ShooterMotors.setSpeed(speed);
  }
  public double getSpeed(){
    
    return m_Speed
  }
  public double getEncoderVelocity(){
    return encoder.getVelocity();
  }
  public void shootBall(){
   shootBall = true  

  }
}
