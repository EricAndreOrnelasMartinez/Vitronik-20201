package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class RobotMap {

  private static final int motor_L1 = 2;
  private static final int motor_L2 = 6;
  private static final int motor_R1 = 8;
  private static final int motor_R2 = 4;

  public static CANSparkMax canSparkMax_motor_L1;
  public static CANSparkMax canSparkMax_motor_L2;
  public static CANSparkMax canSparkMax_motor_R1;
  public static CANSparkMax canSparkMax_motor_R2;

  public static void init(){
    canSparkMax_motor_L1 = new CANSparkMax(motor_L1, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_L2 = new CANSparkMax(motor_L2, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_R1 = new CANSparkMax(motor_R1, CANSparkMaxLowLevel.MotorType.kBrushless); 
    canSparkMax_motor_R2 = new CANSparkMax(motor_R2, CANSparkMaxLowLevel.MotorType.kBrushless); 
  }
}
