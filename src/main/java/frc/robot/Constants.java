package frc.robot;

public class Constants {

    // Controller constants here
    public class ControllerConstants {

        // Mobility Controller
        static final int MOBILITY_CONTROLLER_ID = 1;
        static final int ARM_UP_BUMPER = 6;
        static final int ARM_DOWN_BUMPER = 5;
        static final int CLIMBER_UP_TRIGGER = 3;
        static final int CLIMBER_DOWN_TRIGGER = 2;
        static final int DRIVE_SPEED_AXIS = 1;
        static final int DRIVE_TURN_AXIS = 4;
        static final int DRIVE_SIDE_TOGGLE = 1;
        static final int LIMELIGHT_BUTTON = 2;
        static final int STOP_CAMERA_BUTTON = 8;

        // Manipulator Controller
        static final int MANIPULATOR_CONTROLLER_ID = 0;
        static final int INTAKE_ARM_DOWN_BUMPER = 6;
        static final int INTAKE_ARM_UP_BUMPER = 5;
        static final int INTAKE_AXIS = 1;
        static final int SHOOTER_TRIGGER = 3;
        static final int SHOOTER_MODE_TOGGLE = 8;
        static final int FEEDER_OUTTAKE_TRIGGER = 2;
        static final int CHOMPER_OVERRIDE_AXIS = 5;
        static final int GREEN_POSITION_BUTTON = 1;
        static final int YELLOW_POSITION_BUTTON = 2;
        static final int BLUE_POSITION_BUTTON = 4;
        static final int RED_POSITION_BUTTON = 3;
    }

    // Drive constants here
    public class DriveConstants {

        // Drive motor controller IDs go here. NOTE: Maybe should be on Settings page on Dashboard?
        public static final int LEFT_FRONT_MOTOR_ID = 1;
        public static final int LEFT_MIDDLE_MOTOR_ID = 2;
        public static final int LEFT_REAR_MOTOR_ID = 3;
        public static final int RIGHT_FRONT_MOTOR_ID = 4;
        public static final int RIGHT_MIDDLE_MOTOR_ID = 5;
        public static final int RIGHT_REAR_MOTOR_ID = 6;
        
        public static final double DEADZONE = 0.15; // Last year's value was 0.15
    }
}
