package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

import static robot.Constants.Gripper.DEFAULT_SPEED;

public class InsertCube extends Command {
    private final double timeout = 5;
    private Timer timer = new Timer();

    public InsertCube() {
        requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
        Robot.gripper.setSpeed(-DEFAULT_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.gripper.setSpeed(-DEFAULT_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return timer.get() >= timeout || Robot.gripper.isCubeInside();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.gripper.setSpeed(0);
    }

}