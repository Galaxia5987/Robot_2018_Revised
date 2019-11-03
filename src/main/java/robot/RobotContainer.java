
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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import robot.subsystems.elevator.commands.MoveElevator;
import robot.subsystems.intake.commands.IntakeIn;
import robot.subsystems.intake.commands.MoveArms;

import static robot.subsystems.intake.commands.MoveArms.Direction;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class RobotContainer {
    public XboxController xbox = new XboxController(2);
    private Joystick left = new Joystick(1);
    private Joystick right = new Joystick(0);
    private Button a = new JoystickButton(left, 3);


    public RobotContainer() {
        a.whenPressed(new MoveElevator(0.5));

    }

    public Command getAutonomous() {
        return new MoveElevator(0.75);
    }
}
