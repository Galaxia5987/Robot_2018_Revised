package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.subsystems.gripper.Gripper;

import static robot.Constants.Intake.INTAKING_SPEED;

public class IntakeIn extends Command {
    private double time;
    private Timer timer = new Timer();

    public IntakeIn(double time) {
        requires(Robot.gripper);
        requires(Robot.intake);
        this.time = time;
    }

    @Override
    protected void initialize() {
        timer.reset();
        timer.start();

    }

    @Override
    protected void execute() {
        Robot.intake.setSpeed(INTAKING_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() > time;
    }

    @Override
    protected void end() {
        Robot.intake.setSpeed(0);
    }
}
