package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.RobotMap;
import robot.subsystems.ElevatorConstants;
import robot.subsystems.ElevatorSubsystem;


public class MoveElevator extends Command {
    double targetHeight;
    MoveElevator moveElevator = new MoveElevator(0.8);
    public MoveElevator(double height) {
        requires(Robot.elevatorsubsystem);
        targetHeight = height;
    }

    @Override
    protected void initialize() {
        Robot.elevatorsubsystem.setHeight(targetHeight);
    }

    @Override
    protected void execute() {
        Robot.elevatorsubsystem.setHeight(targetHeight);
    }

    @Override
    protected boolean isFinished() {
        return Robot.elevatorsubsystem.getHeight() >= targetHeight - 0.05;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {

    }
}
