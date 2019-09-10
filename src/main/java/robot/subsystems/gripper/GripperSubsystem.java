package robot.subsystems.gripper;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class GripperSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from commands.

    private final double MIN_HEIGHT = 1;
    private Victor rightMotor = new Victor(RobotMap.RIGHT_MOTOR_PORT);
    private Victor leftMotor = new Victor(RobotMap.LEFT_MOTOR_PORT);

    public GripperSubsystem() {
        rightMotor.setInverted(true);
        leftMotor.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());

    }

    public boolean inDangerOn(double currentHeight) {
        return currentHeight > MIN_HEIGHT;
    }

    public void setRightSpeed(double speed) {
        rightMotor.setSpeed(speed);
    }

    public void setLeftSpeed(double speed) {
        leftMotor.setSpeed(speed);
    }
}