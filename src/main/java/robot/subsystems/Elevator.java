package robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;


import static robot.subsystems.ElevatorConstants.*;

public class Elevator extends Subsystem {

    private TalonSRX liftMaster = new TalonSRX(RobotMap.ELEVATOR_MOTOR);

    public Elevator() {

        liftMaster.configMotionSCurveStrength(4);
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        liftMaster.setSensorPhase(ENCODER_REVERSED);
        liftMaster.config_kP(TALON_PID_SLOT, 0.2, TALON_TIMEOUT_MS);
        liftMaster.config_kI(TALON_PID_SLOT, 0, TALON_TIMEOUT_MS);
        liftMaster.config_kD(TALON_PID_SLOT, 0, TALON_TIMEOUT_MS);
        liftMaster.configSelectedFeedbackCoefficient(TICKS_PER_METER);

    }


    /**
     * Set height of the elevator
     *
     * @param height
     */
    public void setHeight(double height) {
        height = constrain(ElevatorConstants.MAX_HEIGHT, height, ElevatorConstants.MIN_HEIGHT);
        liftMaster.set(ControlMode.MotionMagic, height, DemandType.ArbitraryFeedForward, FEED_FORWARD);
    }
    public void update(double height) {
        if (height < ELEVATOR_DROP_HEIGHT && getHeight() < ELEVATOR_DROP_HEIGHT) {
            liftMaster.set(ControlMode.PercentOutput, 0);
        }
    }

    /**
     * @return desired height in meters
     */
    public double getHeight() {
        return liftMaster.getSelectedSensorPosition();
    }


    @Override
    protected void initDefaultCommand() {

    }

    /**
     * Keep height of the elevator between minimum and maximum values
     * @param minimum
     * @param value
     * @param maximum
     * @return
     */
    private double constrain(double minimum, double value, double maximum){
        return Math.min(maximum, Math.max(minimum , value));
    }

}
