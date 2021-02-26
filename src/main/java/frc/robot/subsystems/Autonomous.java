package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Autonomous extends Subsystem{

    @Override
    protected void initDefaultCommand() {
    }

    public void start(){
        Robot.m_ChassisSubsystem.resetLE();
        Robot.m_ChassisSubsystem.resetRE();
        Robot.m_ChassisSubsystem.moveForward(3, 0.1);
    }
    
}
