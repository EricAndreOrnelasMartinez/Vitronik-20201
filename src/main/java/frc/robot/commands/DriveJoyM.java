package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveJoyM extends Command{

    public DriveJoyM(){
        requires(Robot.m_ChassisSubsystem);
    }
    @Override
    protected void initialize() {
    }
    @Override
    protected void execute() {
        this.move();
    }
    @Override
    protected boolean isFinished() {
      return false;
    }
    
    @Override
    protected void end() {}
    @Override
    protected void interrupted() {}

    private void move(){
        double x = Robot.m_oi.control1.getRawAxis(0);
        double y = Robot.m_oi.control1.getRawAxis(1);
        double l = Robot.m_oi.control1.getRawAxis(2);
        double t = Robot.m_oi.control1.getRawAxis(3);
        double d = Robot.m_oi.control1.getRawAxis(4);
        double r = Robot.m_oi.control1.getRawAxis(5);
        if(!(x >= -0.1 && x <= 0.1 && y >= -0.1 && y <= 0.1)){
            Robot.m_ChassisSubsystem.move(x, y);
        }else if(!(d >= -0.1 && d <= 0.1 && r >= -0.1 && r <= 0.1)){
            Robot.m_ChassisSubsystem.moveBack(d, r);
        }else if(!(l <= 0.1)){
            Robot.m_ChassisSubsystem.moveL(l);
        }else{
            Robot.m_ChassisSubsystem.moveR(t);
        }
    }
}
