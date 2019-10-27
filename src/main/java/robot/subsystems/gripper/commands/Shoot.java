package robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

import static robot.Constants.Gripper.MIN_SHOOTING_HEIGHT;
import static robot.Robot.intake;

public class Shoot extends InstantCommand {
    private Timer timer = new Timer();
    private double timeout, speed;

    public Shoot(double speed, double timeout) {
        requires(Robot.gripper);
        requires(intake);
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
        if (Robot.elevator.getHeight() > MIN_SHOOTING_HEIGHT) {
            if (!intake.areArmsFolded()) {
                Robot.gripper.setSpeed(speed);
                intake.setSpeed(speed);
            }
        } else
            Robot.gripper.setSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (Robot.elevator.getHeight() > MIN_SHOOTING_HEIGHT) {
            if (!intake.areArmsFolded()) {
                Robot.gripper.setSpeed(speed);
                intake.setSpeed(speed);
            }
        } else
            Robot.gripper.setSpeed(speed);
    }

    @Override
    protected boolean isFinished() {
        return timeout >= timer.get() || !intake.areArmsFolded();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        timer.stop();
        Robot.gripper.setSpeed(0);
        intake.setSpeed(0);
    }
}