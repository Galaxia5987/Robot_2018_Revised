package robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
    public TalonSRX liftMaster = new TalonSRX(14);
    public ElevatorSubsystem(){

    }

    @Override
    protected void initDefaultCommand() {

    }
}
