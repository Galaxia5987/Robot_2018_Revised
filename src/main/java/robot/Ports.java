package robot;

public class Ports {
    public static class Gripper {
        public static final int RIGHT_MOTOR_PORT = 0;
        public static final int LEFT_MOTOR_PORT = 1;
        public static final int PROXIMITY_PORT = 5;
    }

    public static class Intake {
        public static final int MOTOR_LEFT = 2;
        public static final int MOTOR_RIGHT = 5;
    }

    public static class Elevator {
        public static final int     MOTOR = 14;
    }

    public static class Drivetrain {
        public static final int LEFT_MASTER_PORT = 16;
        public static final int RIGHT_MASTER_PORT = 11;
        public static final int RIGHT_SLAVE1_PORT = 12;
        public static final int LEFT_SLAVE1_PORT = 14;
        public static final int LEFT_SLAVE2_PORT = 15;
        public static final int RIGHT_SLAVE2_PORT = 13;
    }
}