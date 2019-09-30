package robot.subsystems.Intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends Subsystem {

    private Victor leftVictor = new Victor(RobotMap.INTAKE_MOTOR_LEFT);
    private Victor rightVictor = new Victor(RobotMap.INTAKE_MOTOR_RIGHT);
    private DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID1,RobotMap.INTAKE_SOLENOID2);

    /**
     *
     */
    public IntakeSubsystem() {
        leftVictor.setInverted(RobotMap.INTAKE_LEFT_REVERSED);
    }

    public void setArms(boolean direction){
        if (direction == false){
            solenoid.set(DoubleSolenoid.Value.kForward);
        } else {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        }
    }

    /**
     * sets the speed of the wheels of the intake
     * @param speed a number from -1 to 1
     */
    public void setSpeed(double speed){
        leftVictor.setSpeed(speed);
        rightVictor.setSpeed(speed);
    }
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}