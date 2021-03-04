package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class HopperInatkeSub extends Subsystem{
    private VictorSPX hopper_m1;
    private VictorSPX hopper_m2;
    private VictorSPX inateke;
    @Override
    protected void initDefaultCommand() {
    }
    public HopperInatkeSub(){
        hopper_m1 = RobotMap.hopper_motor1;
        hopper_m2 = RobotMap.hopper_motor2;
        inateke = RobotMap.intake_motor;
    }
    public void take(double speedI, double speedH1, double speedH2){
        hopper_m1.set(ControlMode.PercentOutput, speedH1);
        hopper_m2.set(ControlMode.PercentOutput, speedH2);
        inateke.set(ControlMode.PercentOutput, speedI);
    }
    public void moveToS(double speedH1, double speedH2){
        hopper_m1.set(ControlMode.PercentOutput, speedH1);
        hopper_m2.set(ControlMode.PercentOutput, speedH2);
    }
    
}
