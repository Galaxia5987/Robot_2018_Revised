package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
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
        return Robot.elevator.getHeight() >= targetHeight - ElevatorConstants.HEIGHT_ERROR;
    }

    @Override
    protected void interrupted() {}

    @Override
    protected void end() {}
}
