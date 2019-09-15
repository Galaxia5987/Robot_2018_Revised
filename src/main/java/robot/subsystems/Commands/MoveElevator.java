package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.subsystems.ElevatorConstants;


public class MoveElevator extends Command {
    double targetHeight;
    MoveElevator moveElevator = new MoveElevator(0.8);
    public MoveElevator(double height) {
        requires(Robot.elevatorSubsystem);
        targetHeight = height;
    }

    @Override
    protected void initialize() {
        Robot.elevatorSubsystem.setHeight(targetHeight);
    }

    @Override
    protected void execute() {
        Robot.elevatorSubsystem.setHeight(targetHeight);
    }

    @Override
    protected boolean isFinished() {
        return Robot.elevatorSubsystem.getHeight() >= targetHeight - ElevatorConstants.HEIGHT_ERROR;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {

    }
}
