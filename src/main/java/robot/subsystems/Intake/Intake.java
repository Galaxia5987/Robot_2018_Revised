package robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class Intake extends Command {
    private Timer timer = new Timer();

    public Intake() {

    }

    @Override
    protected void initialize() {
        timer.reset();
       timer.start();

    }

    @Override
    protected void execute() {
        Robot.Intake.setSpeed(-1);
    }

    @Override
    protected boolean isFinished() {
        return timer.hasPeriodPassed(6);
    }

    @Override
    protected void end() {
    }
}
