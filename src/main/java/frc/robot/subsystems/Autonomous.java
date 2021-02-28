package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Autonomous extends Subsystem{

    @Override
    protected void initDefaultCommand() {
    }

    public void start(){
        Robot.m_ChassisSubsystem.moveForward(5, 0.1);
    }
    
}
