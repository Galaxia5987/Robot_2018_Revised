package robot.subsystems.Intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends Subsystem {

    Victor leftVictor = new Victor(RobotMap.INTAKE_MOTOR_LEFT);
    Victor rightVictor = new Victor(RobotMap.INTAKE_MOTOR_RIGHT);
    public DoubleSolenoid Solenoids = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID1,RobotMap.INAKE_SOLENOID2);
    IntakeSubsystem SLD = new IntakeSubsystem();
    public IntakeSubsystem(){

    }
    public void armsUpwards(){

        SLD.Solenoids.set(DoubleSolenoid.Value.kForward);
    }
    public void armsDownwards(){
        SLD.Solenoids.set(DoubleSolenoid.Value.kReverse);


    }
    public void setSpeed(double speed){
        leftVictor.setSpeed(-speed);
        rightVictor.setSpeed(speed);
    }
    public double getLeftSpeed(){
        return leftVictor.getSpeed();
    }
    public double getRightSpeed() {
        return rightVictor.getSpeed();
    }
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}