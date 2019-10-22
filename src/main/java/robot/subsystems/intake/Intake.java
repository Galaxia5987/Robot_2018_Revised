package robot.subsystems.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import static robot.Ports.Intake.*;
import static robot.Constants.Intake.*;
import static robot.subsystems.intake.commands.MoveArms.Direction;


public class Intake extends Subsystem {

    private Victor leftMotor = new Victor(MOTOR_LEFT);
    private Victor rightMotor = new Victor(MOTOR_RIGHT);
    private DoubleSolenoid solenoid = new DoubleSolenoid(SOLENOID_FORWARD, SOLENOID_REVERSE);


    public Intake() {
        leftMotor.setInverted(LEFT_REVERSED);
        rightMotor.setInverted(RIGHT_REVERSED);
    }

    /**
     * Set the direction in which the arms move.
     *
     * @param direction either UP or DOWN
     */
    public void setArms(Direction direction) {
        if (direction == Direction.UP)
            solenoid.set(DoubleSolenoid.Value.kForward);
        else
            solenoid.set(DoubleSolenoid.Value.kReverse);

    }

    /**
     * returns the state of the arms
     * @return true if the arms are up/folded
     */
    public boolean areArmsFolded(){
        return solenoid.get() == DoubleSolenoid.Value.kForward;
    }
    /**
     * Set the speed of the wheels of the intake.
     *
     * @param speed a number from -1 to 1
     */
    public void setSpeed(double speed) {
        leftMotor.setSpeed(speed);
        rightMotor.setSpeed(speed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}