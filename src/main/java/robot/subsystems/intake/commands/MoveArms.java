package robot.subsystems.intake.commands;


import edu.wpi.first.wpilibj.command.InstantCommand;
import robot.Robot;

import static robot.Robot.intake;

public class MoveArms extends InstantCommand {
    private Direction INTAKE_SOLENOID_DIRECTION;

    public MoveArms(Direction direction) {
        requires(Robot.intake);
        INTAKE_SOLENOID_DIRECTION = direction;
    }

    @Override
    protected void initialize() {
        intake.setArms(INTAKE_SOLENOID_DIRECTION);
    }

    public enum Direction {
        UP,
        DOWN
    }

}
