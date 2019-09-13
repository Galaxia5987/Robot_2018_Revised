package robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

import static robot.Robot.Intake;

public class armsDownwards extends Command {
    @Override
    protected void initialize() {
        Intake.armsDownwards();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
