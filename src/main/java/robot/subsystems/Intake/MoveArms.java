package robot.subsystems.Intake;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

import java.time.Instant;

import static robot.Robot.intake;

public class MoveArms extends InstantCommand {
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

}
