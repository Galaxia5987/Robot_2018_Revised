package robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

import static robot.Ports.Drivetrain.*;

public class Drivetrain extends Subsystem {
    public TalonSRX leftMaster = new TalonSRX(LEFT_MASTER_PORT);
    public TalonSRX rightMaster = new TalonSRX(RIGHT_MASTER_PORT);
    public VictorSPX right1 = new VictorSPX(RIGHT_SLAVE1_PORT);
    public VictorSPX left1 = new VictorSPX(LEFT_SLAVE1_PORT);
    public VictorSPX right2 = new VictorSPX(RIGHT_SLAVE2_PORT);
    public VictorSPX left2 = new VictorSPX(LEFT_SLAVE2_PORT);

    public Drivetrain() {
        leftMaster.setInverted(DrivetrainConstants.LEFT_MASTER_REVERSED);
        left1.setInverted(DrivetrainConstants.LEFT_SLAVE1_REVERSED);
        left2.setInverted(DrivetrainConstants.LEFT_SLAVE2_REVERSED);
        rightMaster.setInverted(DrivetrainConstants.RIGHT_MASTER_REVERSED);
        right1.setInverted(DrivetrainConstants.RIGHT_SLAVE1_REVERSED);
        right2.setInverted(DrivetrainConstants.RIGHT_SLAVE2_REVERSED);

        right1.follow(rightMaster);
        right2.follow(rightMaster);
        left1.follow(leftMaster);
        left2.follow(leftMaster);
    }

    public void setLeftSpeed(double speed) {
        leftMaster.set(ControlMode.PercentOutput, speed);
    }

    public void setRightSpeed(double speed) {
        rightMaster.set(ControlMode.PercentOutput, speed);
    }

    public double getLeftDistance() {
        return convertTicksToDistance(leftMaster.getSelectedSensorPosition());
    }

    public double getRightDistance() {
        return convertTicksToDistance(rightMaster.getSelectedSensorPosition());
    }

    public int convertDistanceToTicks(double distance) {
        return (int) (distance * DrivetrainConstants.TICKS_PER_METER);
    }

    public double convertTicksToDistance(int tick) {
        return tick / DrivetrainConstants.TICKS_PER_METER;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
