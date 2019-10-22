package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Constants;
import robot.Robot;
import robot.subsystems.elevator.Elevator;
import robot.subsystems.gripper.Gripper;

import static robot.Constants.Elevator.MIN_HEIGHT;
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
    }

    @Override
    protected void execute() {
        if (Robot.elevator.getHeight() <= INTAKE_THRESHOLD && !Robot.elevator.areArmsFolded()) {
            Robot.intake.setSpeed(INTAKING_SPEED);
            timer.start();
        }
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
