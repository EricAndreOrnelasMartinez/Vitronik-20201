package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class ShooterSub extends Subsystem{
    private CANSparkMax shooter;
    @Override
    protected void initDefaultCommand() {
    }
    public ShooterSub(){
        shooter = RobotMap.shooter;
    }
    public void shoot(double speed){
        shooter.set(speed);
    }
    
}
