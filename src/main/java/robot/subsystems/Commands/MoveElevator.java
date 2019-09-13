package robot.subsystems.Commands;

import edu.wpi.first.wpilibj.command.Command;


public class MoveElevator extends Command {
    double targetHeight;
    MoveElevator moveElevator = new MoveElevator(0.8);
    public MoveElevator(double height) {
        requires(Robot.elevatorsubsystem);
        targetHeight = height;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {

    }

    @Override
    protected void end() {
    }
}
