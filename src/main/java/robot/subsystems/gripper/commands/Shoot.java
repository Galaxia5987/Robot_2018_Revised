package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

import static robot.Constants.Gripper.MIN_SHOOTING_HEIGHT;

public class Shoot extends InstantCommand {
    private Timer timer = new Timer();
    private double timeout, speed;

    public Shoot(double speed, double timeout) {
        requires(Robot.gripper);
        requires(Robot.intake);
        this.speed = speed;
        this.timeout = timeout;
    }

    public Shoot(double speed) {
        this(speed, 0);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        timer.reset();
        timer.start();
        applyPower();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        applyPower();
    }

    private void applyPower() {
        if (Robot.elevator.getHeight() > MIN_SHOOTING_HEIGHT)
            if (Robot.intake.areArmsFolded()) {
                Robot.gripper.setSpeed(speed);
                Robot.intake.setSpeed(speed);
            }
    }

    @Override
    protected boolean isFinished() {
        return timeout >= timer.get() || Robot.intake.areArmsFolded();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        timer.stop();
        Robot.gripper.setSpeed(0);
        Robot.intake.setSpeed(0);
    }
}