package robot.subsystems.elevator.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

import static robot.Constants.Elevator.HEIGHT_THRESHOLD;
import static robot.Robot.elevator;


public class MoveElevator extends Command {
    private double targetHeight;
    private NetworkTable elevatorTable = NetworkTableInstance.getDefault().getTable("Elevator");
    private NetworkTableEntry heightEntry = elevatorTable.getEntry("height");
    private NetworkTableEntry speedEntry = elevatorTable.getEntry("speed");
    private NetworkTableEntry errorEntry = elevatorTable.getEntry("error");

    public MoveElevator(double height) {
        requires(elevator);
        targetHeight = height;
    }

    @Override
    protected void initialize() {
        elevator.updateConstants();

        elevator.setHeight(targetHeight);
        errorEntry.setDouble(targetHeight - elevator.getHeight());
        speedEntry.setDouble(elevator.getSpeed());
        heightEntry.setDouble(elevator.getHeight());
    }

    @Override
    protected void execute() {
        //elevator.update(targetHeight);
        errorEntry.setDouble(targetHeight - elevator.getHeight());
        speedEntry.setDouble(elevator.getSpeed());
        heightEntry.setDouble(elevator.getHeight());
    }

    @Override
    protected boolean isFinished()
    {
        return Math.abs(targetHeight - elevator.getHeight()) <= HEIGHT_THRESHOLD;
    }

    @Override
    protected void end() {
        System.out.println("End");
    }
}
