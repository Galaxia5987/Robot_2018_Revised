package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class TakeCubeCommand extends Command {
    private Timer timer = new Timer();
    private final double timeout = 5;

    public TakeCubeCommand() {
        requires(Robot.gripperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        Robot.gripperSubsystem.setLeftSpeed(-1);
        Robot.gripperSubsystem.setRightSpeed(-  1);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= timeout || Robot.gripperSubsystem.isCubeInside();
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