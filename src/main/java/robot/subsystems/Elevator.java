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
     * Set height of the eleavator
     *
     * @param height
     */
    public void setHeight(double height) {
        liftMaster.set(ControlMode.MotionMagic, height, DemandType.ArbitraryFeedForward, FEED_FORWARD);
        if (height < 0 && getHeight() < 0) {
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

}
