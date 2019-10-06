package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

public class ShootCommand extends InstantCommand {

    public ShootCommand() {
        requires(Robot.gripperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }


    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
// subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}