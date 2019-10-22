package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

import static robot.Constants.Gripper.DEFAULT_SPEED;
import static robot.Constants.Gripper.MIN_SHOOTING_HEIGHT;

public class Shoot extends InstantCommand {
    private Timer timer = new Timer();

    public Shoot() {
        requires(Robot.gripper);
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
        if (Robot.elevator.getHeight() < MIN_SHOOTING_HEIGHT) {
            if (!Robot.intake.areArmsFolded()) {
                Robot.gripper.setVelocities(DEFAULT_SPEED, DEFAULT_SPEED);
                Robot.intake.setSpeed(DEFAULT_SPEED);
            }
        } else
            Robot.gripper.setVelocities(DEFAULT_SPEED, DEFAULT_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (Robot.elevator.getHeight() < MIN_SHOOTING_HEIGHT) {
            if (!Robot.intake.areArmsFolded()) {
                Robot.gripper.setVelocities(DEFAULT_SPEED, DEFAULT_SPEED);
                Robot.intake.setSpeed(DEFAULT_SPEED);
            }
        } else
            Robot.gripper.setVelocities(DEFAULT_SPEED, DEFAULT_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return Robot.gripper.getTimeout() >= timer.get();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        timer.stop();
        Robot.gripper.setVelocities(0, 0);
        Robot.intake.setSpeed(0);
    }
}