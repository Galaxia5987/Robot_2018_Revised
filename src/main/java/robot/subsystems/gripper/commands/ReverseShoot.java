package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

import static robot.Constants.Gripper.DEFAULT_SPEED;
import static robot.Constants.Gripper.MIN_REVERSE_SHOOT_HEIGHT;

public class ReverseShoot extends InstantCommand {

    private Timer timer = new Timer();

    public ReverseShoot() {
        requires(Robot.gripper);
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
        Robot.gripper.setVelocities(-DEFAULT_SPEED, -DEFAULT_SPEED);
        Robot.intake.setSpeed(-DEFAULT_SPEED);
    }

    @Override
    protected void execute() {
        Robot.gripper.setVelocities(-DEFAULT_SPEED, -DEFAULT_SPEED);
        Robot.intake.setSpeed(-DEFAULT_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return Robot.gripper.getTimeout() >= timer.get() || Robot.elevator.getHeight() < MIN_REVERSE_SHOOT_HEIGHT;
    }

    @Override
    protected void end() {
        timer.stop();
        Robot.gripper.setVelocities(0, 0);
    }
}
