package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class SetGripperSpeedCommand extends Command {

    private double speed;

    public SetGripperSpeedCommand(double speed) {
        requires(Robot.gripperSubsystem);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       Robot.gripperSubsystem.setLeftSpeed(speed);
       Robot.gripperSubsystem.setRightSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gripperSubsystem.inDangerOn(Robot.elevatorsubsystem.convertTicksToHeight());
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.gripperSubsystem.setLeftSpeed(0);
        Robot.gripperSubsystem.setRightSpeed(0);
    }

    // Called when another command which requires one or more of the same
// subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}