package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.subsystems.gripper.Gripper;

import static robot.Constants.Intake.*;

public class IntakeIn extends Command {
    private Timer timer = new Timer();

    public IntakeIn() {
        requires(Robot.gripper);
        requires(Robot.intake);
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
