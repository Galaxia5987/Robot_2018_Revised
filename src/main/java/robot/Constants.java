package robot;

public class Constants {
    public static class Drivetrain {
        public static final double TICKS_PER_METER = 256 / (4 * 0.0254 * Math.PI);

        public static final boolean RIGHT_MASTER_REVERSED = true;
        public static final boolean RIGHT_SLAVE1_REVERSED = true;
        public static final boolean RIGHT_SLAVE2_REVERSED = true;
        public static final boolean LEFT_MASTER_REVERSED = false;
        public static final boolean LEFT_SLAVE1_REVERSED = false;
        public static final boolean LEFT_SLAVE2_REVERSED = false;
    }

    public static class Elevator {
        public static final int S_CURVE_STRENGTH = 4;
        public static final int TALON_TIMEOUT_MS = 20;
        public static final double TICKS_PER_METER = 16814;
        public static double KP = 0.1;
        public static double KI = 0.0;
        public static double KD = 0;
        public static final int TALON_PID_SLOT = 0;
        public static final double FEED_FORWARD = 0;
        public static final double MAX_HEIGHT = 2 ;
        public static final double MIN_HEIGHT = -0.01;
        public static final double DROP_HEIGHT = 0.05;
        public static final double HEIGHT_THRESHOLD = 0.000;
        public static final boolean TALON_REVERSED = true;
        public static final boolean ENCODER_REVERSED = true;
    }

    public static class Gripper {
        public static final boolean LEFT_REVERSED = false;
        public static final boolean RIGHT_REVERSED = false;
        public static final double MIN_CUBE_DISTANCE = 2;
        public static final double MIN_SHOOTING_HEIGHT  = 2.5; //If the height is under this constant, the cube might hit the wrists
        public static final double MIN_REVERSE_SHOOT_HEIGHT = 2.5; //Minimum height which wont hit the back of the elevator.
    }

    public static class Intake {
        public static final int SOLENOID_FORWARD = 0;
        public static final int SOLENOID_REVERSE = 1;
        public static final boolean LEFT_REVERSED = false;
        public static final boolean RIGHT_REVERSED = false;
    }
}
