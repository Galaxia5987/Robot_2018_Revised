package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

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
        return timer.get() > INTAKE_OPERATION_TIME;
    }

    @Override
    protected void end() {
        timer.stop();
        Robot.intake.setSpeed(0);
    }

}
