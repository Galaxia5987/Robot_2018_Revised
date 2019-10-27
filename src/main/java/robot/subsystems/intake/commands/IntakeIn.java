package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

import static robot.Constants.Gripper.*;
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
        timer.start();
    }

    @Override
    protected void execute() {
        //if (Robot.elevator.getHeight() <= INTAKE_THRESHOLD && !Robot.elevator.areArmsFolded() && Robot.gripper.getCubeDistance() <= MIN_CUBE_DISTANCE) {
            Robot.intake.setSpeed(INTAKING_SPEED);
            Robot.gripper.setSpeed(DEFAULT_SPEED);
        //}
    }

    @Override
    protected boolean isFinished() {
        return timer.get() > INTAKE_OPERATION_TIME || Robot.elevator.getHeight() >= INTAKE_THRESHOLD || Robot.elevator.areArmsFolded() || !(Robot.gripper.getCubeDistance() <= MIN_CUBE_DISTANCE);
    }

    @Override
    protected void interrupted(){
        end();
    }

    @Override
    protected void end() {
        timer.stop();
        Robot.intake.setSpeed(0);
    }

}
