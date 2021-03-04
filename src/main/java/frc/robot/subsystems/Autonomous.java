package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Autonomous extends Subsystem{
    private Timer timer;

    @Override
    protected void initDefaultCommand() {
    }
    public Autonomous(){
        timer = new Timer();
    }
    public void initTime(){
        timer.start();
    }

    public void start(){
        System.out.println(timer.get());
    }
    
}
