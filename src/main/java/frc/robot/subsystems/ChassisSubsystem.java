package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ChassisSubsystem extends Subsystem{
    private CANSparkMax chassisMotorL1;
    private CANSparkMax chassisMotorL2;
    private CANSparkMax chassisMotorR1;
    private CANSparkMax chassisMotorR2;
    private CANEncoder encoderR;
    private CANEncoder encoderL;

    @Override
    protected void initDefaultCommand() {
    }

    public ChassisSubsystem(){
        chassisMotorL1 = RobotMap.canSparkMax_motor_L1;
        chassisMotorL2 = RobotMap.canSparkMax_motor_L2;
        chassisMotorR1 = RobotMap.canSparkMax_motor_R1;
        chassisMotorR2 = RobotMap.canSparkMax_motor_R2;
        chassisMotorL1.setOpenLoopRampRate(0.1);
        chassisMotorL2.setOpenLoopRampRate(0.1);
        chassisMotorR1.setOpenLoopRampRate(0.1);
        chassisMotorR2.setOpenLoopRampRate(0.1);
        encoderL = RobotMap.canSparkMax_motor_L1.getEncoder();
        encoderR = RobotMap.canSparkMax_motor_R1.getEncoder();
        chassisMotorR1.setInverted(true);
        chassisMotorR2.setInverted(true);
        encoderL.setPosition(0.0);
        encoderR.setPosition(0.0);
    }

    public void move(double x, double y){
        double speedL = (y + (x * 0.8));
        double speedR = (y - (x * 0.8));
        chassisMotorL1.set(speedL);
        chassisMotorL2.set(speedL);
        chassisMotorR1.set(speedR);
        chassisMotorR2.set(speedR);
    }

    public void moveBack(double x, double y){
        double speedL = (y - (x * 0.8));
        double speedR = (y + (x * 0.8));
        chassisMotorL1.set(speedL * -1);
        chassisMotorL2.set(speedL * -1);
        chassisMotorR1.set(speedR * -1);
        chassisMotorR2.set(speedR * -1);
    }
    
    public void moveL(double value){
        chassisMotorL1.set(value * -1);
        chassisMotorL2.set(value * -1);
        chassisMotorR1.set(value);
        chassisMotorR2.set(value);
    }

    public void moveR(double value){
        chassisMotorL1.set(value);
        chassisMotorL2.set(value);
        chassisMotorR1.set(value * -1);
        chassisMotorR2.set(value * -1);
    }

    public void moveForward(double rotation, double speed){
        if(encoderL.getPosition() < getRawC(rotation) && encoderR.getPosition() < getRawC(rotation)){
            chassisMotorL1.set(speed);
            chassisMotorL2.set(speed);
            chassisMotorR1.set(speed);
            chassisMotorR2.set(speed);
            System.out.println(encoderR.getPosition());
        
        }else {
            chassisMotorL1.set(0.0);
            chassisMotorL2.set(0.0);
            chassisMotorR1.set(0.0);
            chassisMotorR2.set(0.0);
        }
        SmartDashboard.putNumber("Encoder position", encoderL.getPosition());
    }

    public void moveBackward(double rotation, double speed){
        if(encoderL.getPosition() > rotation || encoderR.getPosition() > rotation){
            chassisMotorL1.set(speed * -1);
            chassisMotorL2.set(speed * -1);
            chassisMotorR1.set(speed * -1);
            chassisMotorR2.set(speed * -1);
        }else {
            chassisMotorL1.set(0.0);
            chassisMotorL2.set(0.0);
            chassisMotorR1.set(0.0);
            chassisMotorR2.set(0.0);
        }
    }

    public void turnL(double rotation, double speed){
        if(speed <= 0 ){
            throw new IllegalArgumentException("Speed can't be negative or 0 in rotation");
        }else if(encoderR.getPosition() < rotation) {
            chassisMotorL1.set(0.0);
            chassisMotorL2.set(0.0);
            chassisMotorR1.set(speed);
            chassisMotorR2.set(speed);
        }else {
            chassisMotorL1.set(0.0);
            chassisMotorL2.set(0.0);
            chassisMotorR1.set(0.0);
            chassisMotorR2.set(0.0);
        }
    }
    public void turnR(double rotation, double speed){
        if(speed <= 0){
            throw new IllegalArgumentException("Speed can't be negative or 0 in rotation");
        }
        if(encoderL.getPosition() < rotation) {
            chassisMotorL1.set(speed);
            chassisMotorL2.set(speed);
            chassisMotorR1.set(0.0);
            chassisMotorR2.set(0.0);
        }else {
            chassisMotorL1.set(0.0);
            chassisMotorL2.set(0.0);
            chassisMotorR1.set(0.0);
            chassisMotorR2.set(0.0);
        }
    }

    public void resetRE(){
        encoderR.setPosition(0.0);
    }

    public void resetLE(){
        encoderL.setPosition(0.0);
    }
    public double getEncoderL(){
        return encoderL.getPosition();
    }
    public double getEncoderR(){
        return encoderR.getPosition(); 
    }
    private double getRawC(double rotation){
        return rotation * 6.25;
    }
    public void stop(){
        chassisMotorL1.set(0.0);
        chassisMotorL2.set(0.0);
        chassisMotorR1.set(0.0);
        chassisMotorR2.set(0.0);
    }
}
