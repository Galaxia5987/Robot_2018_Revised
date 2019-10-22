package robot.subsystems.gripper;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import static robot.Constants.Gripper.*;
import static robot.Ports.Gripper.*;

public class Gripper extends Subsystem {

    private Victor rightMotor = new Victor(RIGHT_MOTOR_PORT);
    private Victor leftMotor = new Victor(LEFT_MOTOR_PORT);
    private AnalogInput proximity = new AnalogInput(PROXIMITY_PORT);
    private double speed, timeout;

    public Gripper(double speed, double timeout) {
        rightMotor.setInverted(RIGHT_REVERSED);
        leftMotor.setInverted(LEFT_REVERSED);
        this.timeout = timeout;
        this.speed = speed;
    }

    public Gripper(double speed) {
        this(speed, 0.0);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());

    }


    /**
     * @return current distance from the cube
     */
    private double getCubeDistance() {
        return proximity.getVoltage();
    }

    /**
     * @return whether there is a cube inside the gripper
     */
    public boolean isCubeInside() {
        return MIN_CUBE_DISTANCE < getCubeDistance();
    }

    /**
     * @param speed set speed for the right side of the gripper
     */
    private void setRightSpeed(double speed) {
        rightMotor.setSpeed(speed);
    }

    /**
     * @param speed set speed for the left side of the gripper
     */
    private void setLeftSpeed(double speed) {
        leftMotor.setSpeed(speed);
    }

    /**
     * Set right and left velocities.
     *
     * @param rightVelocity
     * @param leftVelocity
     */
    public void setVelocities(double rightVelocity, double leftVelocity) {
        setRightSpeed(rightVelocity);
        setLeftSpeed(leftVelocity);
    }

    public double getSpeed() {
        return speed;
    }

    public double getTimeout() {
        return timeout;
    }
}
