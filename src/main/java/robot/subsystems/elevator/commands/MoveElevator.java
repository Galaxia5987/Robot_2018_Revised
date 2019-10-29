package robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

import static robot.Constants.Elevator.HEIGHT_THRESHOLD;
import static robot.Constants.Elevator.TICKS_PER_METER;
import static robot.Robot.elevator;


public class MoveElevator extends Command {
    private double targetHeight;

    public MoveElevator(double height) {
        requires(elevator);
        targetHeight = height;
    }

    @Override
    protected void initialize() {
        elevator.setHeight(targetHeight);
        System.out.println("begin");
    }

    @Override
    protected void execute() {
        System.out.println((int) (2*TICKS_PER_METER * 0.1));
        elevator.update(targetHeight);
        System.out.println(elevator.getHeight());

    }

    @Override
    protected boolean isFinished()
    {
        return Math.abs(targetHeight - elevator.getHeight()) <= HEIGHT_THRESHOLD;
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected void end() {
        System.out.println("End");
    }
}
