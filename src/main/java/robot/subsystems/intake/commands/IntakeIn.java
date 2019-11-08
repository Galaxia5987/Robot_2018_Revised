package robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;

public class IntakeIn extends Command {
    private double speed;
    private double time;
    private Timer timer = new Timer();

    public IntakeIn(double speed, double time) {
        requires(Robot.intake);
        this.speed = speed;
        this.time = time;
    }

    public IntakeIn(double speed) {
        this(speed, 0);
    }

    @Override
    protected void initialize() {
        timer.reset();
        timer.start();

    }

    @Override
    protected void execute() {
        Robot.intake.setSpeed(speed);
    }

    @Override
    protected boolean isFinished() {
        return time > 0 && timer.get() > time;
    }

    @Override
    protected void end() {
        Robot.intake.setSpeed(0);
    }
}
