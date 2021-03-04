package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class RobotMap {

  private static final int motor_L1 = 2;
  private static final int motor_L2 = 6;
  private static final int motor_R1 = 8;
  private static final int motor_R2 = 4;
  private static final int shooter_L = 7;
  private static final int shooter_R = 3;
  private static final int hopper_M1 = 5;
  private static final int hopper_M2 = 4;
  private static final int intake_M1 = 7;

  public static CANSparkMax canSparkMax_motor_L1;
  public static CANSparkMax canSparkMax_motor_L2;
  public static CANSparkMax canSparkMax_motor_R1;
  public static CANSparkMax canSparkMax_motor_R2;
  public static VictorSPX intake_motor;
  public static VictorSPX hopper_motor1;
  public static VictorSPX hopper_motor2;

  public static void init(){
    canSparkMax_motor_L1 = new CANSparkMax(motor_L1, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_L2 = new CANSparkMax(motor_L2, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_R1 = new CANSparkMax(motor_R1, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_R2 = new CANSparkMax(motor_R2, CANSparkMaxLowLevel.MotorType.kBrushless); 
    intake_motor = new VictorSPX(intake_M1);
    hopper_motor1 = new VictorSPX(hopper_M1);
    hopper_motor2 = new VictorSPX(hopper_M2);
  }
}
