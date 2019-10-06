package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.subsystems.Elevator;
import robot.subsystems.ElevatorConstants;


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
        return Math.abs(targetHeight - Robot.elevator.getHeight()) <= ElevatorConstants.HEIGHT_THRESHOLD;
    }

    @Override
    protected void interrupted() {}

    @Override
    protected void end() {}
}
