
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import robot.subsystems.Intake.commands.IntakeIn;
import robot.subsystems.Intake.commands.MoveArms;
import robot.subsystems.drivetrain.commands.DriveCommand;

import static robot.subsystems.Intake.commands.MoveArms.Direction;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public XboxController xbox = new XboxController(2);
    Button a = new JoystickButton(xbox, 1);
    Button b = new JoystickButton(xbox, 2);
    Button x = new JoystickButton(xbox, 3);
    Button y = new JoystickButton(xbox, 4);
    private Joystick right = new Joystick(0);
    Button triggerRight = new JoystickButton(right, 7);
    private Joystick left = new Joystick(1);
    Button triggerLeft = new JoystickButton(left, 6);
    private Button left10 = new JoystickButton(left, 10);
    private Button right11 = new JoystickButton(right, 11);

    public OI() {
        b.whenPressed(new DriveCommand(0.4));
        x.whenPressed(new DriveCommand(-0.4));
        left10.whenPressed(new MoveArms(Direction.UP));
        right11.whenPressed(new MoveArms(Direction.DOWN));
        a.whenPressed(new IntakeIn(-1, 6));
    }
}
