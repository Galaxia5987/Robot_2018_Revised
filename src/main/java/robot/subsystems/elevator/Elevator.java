package robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.Constants;

import static robot.Ports.Elevator.*;
import static robot.Constants.Elevator.*;

public class Elevator extends Subsystem {

    private TalonSRX liftMaster = new TalonSRX(MOTOR);
    private double targetHeight = 0;
    public Elevator() {
        liftMaster.configMotionSCurveStrength(S_CURVE_STRENGTH);
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, TALON_PID_SLOT, 0);
        liftMaster.setSensorPhase(ENCODER_REVERSED);
        liftMaster.config_kP(TALON_PID_SLOT, KP, TALON_TIMEOUT_MS);
        liftMaster.config_kI(TALON_PID_SLOT, KI, TALON_TIMEOUT_MS);
        liftMaster.config_kD(TALON_PID_SLOT, KD, TALON_TIMEOUT_MS);
        liftMaster.configSelectedFeedbackCoefficient(TICKS_PER_METER);
        liftMaster.setInverted(TALON_REVERSED);
        liftMaster.configMotionCruiseVelocity((int) (2*TICKS_PER_METER ));
        liftMaster.configMotionAcceleration((int) (1*TICKS_PER_METER ));
        liftMaster.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Set position of the elevator to 0 if the height is under 0.
     *
     * @param height in meters
     */
    public void update(double height) {
        if (height < DROP_HEIGHT && getHeight() < DROP_HEIGHT) {
            liftMaster.set(ControlMode.PercentOutput, 0);
        }
    }

    /**
     * @return desired height in meters
     */
    public double getHeight() {
        return liftMaster.getSelectedSensorPosition()/ TICKS_PER_METER;
    }

    /**
     * Set position of the elevator.
     *
     * @param height in meters
     */
    public void setHeight(double height) {
        height = constrain(MAX_HEIGHT, height, MIN_HEIGHT);
        targetHeight = height;
        liftMaster.set(ControlMode.MotionMagic, height, DemandType.ArbitraryFeedForward, FEED_FORWARD);
    }

    /**
     * return the target height the talon is trying to reach
     * @return target height in meters
     */
    public double getTargetHeight(){
        return targetHeight;
    }
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Constrain a value within a range.
     *
     * @param minimum set minimum height value
     * @param value   target height
     * @param maximum set maximum height value
     * @return value double in the range, if the value is less than the minimum or greater than the maximum it will cap it accordingly to the maximum or minimum value
     */
    private double constrain(double minimum, double value, double maximum) {
        return Math.min(maximum, Math.max(minimum, value));
    }

}
