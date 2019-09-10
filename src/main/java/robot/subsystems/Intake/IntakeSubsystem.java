package robot.subsystems.Intake;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends Subsystem {

    Victor leftVictor = new Victor(RobotMap.INTAKE_MOTOR_LEFT);
    Victor rightVictor = new Victor(RobotMap.INTAKE_MOTOR_RIGHT);

    public IntakeSubsystem(){

    }

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