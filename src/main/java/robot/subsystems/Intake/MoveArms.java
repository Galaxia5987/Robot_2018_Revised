package robot.subsystems.Intake;


import edu.wpi.first.wpilibj.command.Command;
import robot.RobotMap;

import static robot.Robot.Intake;

public class MoveArms extends Command {
    @Override
    protected void initialize() {
        Intake.setArms(IntakeSubsystem.INTAKE_SOLENOID_DIRECTION);
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
