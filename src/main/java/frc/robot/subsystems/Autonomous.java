package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Autonomous extends Subsystem{

    @Override
    protected void initDefaultCommand() {
    }

    public void start(){
        int f = 0;
        if(f == 0 && Robot.m_ChassisSubsystem.getEncoderL() < 2 && Robot.m_ChassisSubsystem.getEncoderR() < 2){
            Robot.m_ChassisSubsystem.moveForward(2, 0.1);
            if(!(Robot.m_ChassisSubsystem.getEncoderL() < 2 && Robot.m_ChassisSubsystem.getEncoderR() < 2)){
                f = 1;
            }
        }else if(f == 1 && Robot.m_ChassisSubsystem.getEncoderL() > 0 && Robot.m_ChassisSubsystem.getEncoderR() > 0){
            Robot.m_ChassisSubsystem.moveBackward(2, 0.1);
        }
    }
    
}
