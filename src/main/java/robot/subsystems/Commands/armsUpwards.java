package robot.subsystems.Commands;


import edu.wpi.first.wpilibj.command.Command;

import static robot.Robot.Intake;

public class armsUpwards extends Command {
    @Override
    protected void initialize() {
        Intake.armsUpwards();
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
