package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;


public class ReverseShoot extends InstantCommand {

    private Timer timer = new Timer();
    private double timeout, speed;

    public ReverseShoot(double speed, double timeout) {
        requires(Robot.gripper);
        this.timeout = timeout;
        this.speed = speed;
    }

    public ReverseShoot(double speed) {
        this(speed, 0);
    }

    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
        if (!isFinished())
            Robot.gripper.setSpeed(speed);
    }


    @Override
    protected void execute() {
        Robot.gripper.setSpeed(speed);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() >= timeout; //|| Robot.elevator.getHeight() > MIN_REVERSE_SHOOT_HEIGHT;
    }

    @Override
    protected void end() {
        timer.stop();
        Robot.gripper.setSpeed(0);
    }
}
