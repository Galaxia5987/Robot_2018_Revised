package robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

import static robot.Constants.Elevator.HEIGHT_THRESHOLD;


public class MoveElevator extends Command {
    private double targetHeight;

    public MoveElevator(double height) {
        requires(Robot.elevator);
        targetHeight = height;
    }

    @Override
    protected void initialize() {
        Robot.elevator.setHeight(targetHeight);
    }

    @Override
    protected void execute() {
        Robot.elevator.update(targetHeight);
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(targetHeight - Robot.elevator.getHeight()) <= HEIGHT_THRESHOLD;
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected void end() {
    }
}
