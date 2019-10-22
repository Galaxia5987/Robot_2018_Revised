package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

/**
 * ERRORNOUS DONT RUN!
 */
public class SetGripperSpeed extends Command {

    private double speed;

    public SetGripperSpeed(double speed) {
        requires(Robot.gripper);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.gripper.setVelocities(speed, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.gripper.setVelocities(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; //TODO: Add proper isFinished.
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.gripper.setVelocities(0, 0);
    }

    // Called when another command which requires one or more of the same
// subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}