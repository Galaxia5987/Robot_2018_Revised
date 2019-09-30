package robot.subsystems.Intake;


import edu.wpi.first.wpilibj.command.Command;

import static robot.Robot.intake;

public class MoveArms extends Command {
    public Direction INTAKE_SOLENOID_DIRECTION;
    public enum Direction {
        UP,
        DOWN
    }
    public MoveArms(Direction direction){
        INTAKE_SOLENOID_DIRECTION = direction;
    }

    @Override
    protected void initialize() {
        intake.setArms(INTAKE_SOLENOID_DIRECTION);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
