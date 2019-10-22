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
        public static final double TICKS_PER_METER = 0;
        public static final double KP = 0.2;
        public static final double KI = 0.0;
        public static final double KD = 0.0;
        public static final int TALON_PID_SLOT = 0;
        public static final double FEED_FORWARD = 0;
        public static final double MAX_HEIGHT = 1.0;
        public static final double MIN_HEIGHT = 0.0;
        public static final double DROP_HEIGHT = 0.05;
        public static final double HEIGHT_THRESHOLD = 0.05;
        public static final boolean TALON_REVERSED = false;
        public static final boolean ENCODER_REVERSED = false;
    }

    public static class Gripper {
        public static final boolean LEFT_REVERSED = false;
        public static final boolean RIGHT_REVERSED = false;
        public static final double MIN_CUBE_DISTANCE = 2;
        public static final double DEFAULT_SPEED  = 0.7; //TODO: Choose reasonable number
        /**
         * for case that the intake is up
         */
        public static final double MIN_SHOOTING_HEIGHT  = 0.7; //TODO: Choose reasonable number
        public static final double MIN_REVERSE_SHOOT_HEIGHT = 0.7;
    }

    public static class Intake {
        public static final int SOLENOID_FORWARD = 0;
        public static final int SOLENOID_REVERSE = 1;
        public static final boolean LEFT_REVERSED = false;
        public static final boolean RIGHT_REVERSED = false;
    }
}
