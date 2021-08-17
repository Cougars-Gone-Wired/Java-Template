package frc.robot;

public class Constants {

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

    // Intake constants here
    public class IntakeConstants {
        public static final double DEADZONE = 0.15;
        public static final int INTAKE_MOTOR_ID = 1;
    }

    // Climber constants here
    public class ClimberConstants {
        public static final double DEADZONE = 0.15;
        public static final int CLIMBER_LEFT_MOTOR_ID = 1;
        public static final int CLIMBER_RIGHT_MOTOR_ID = 2; 
    }

    // Arm movement constants here
    public class ArmConstants {
        public static final int SHOOTER_ARM_TOP_SOLENOID_PORT_1 = 1;
        public static final int SHOOTER_ARM_TOP_SOLENOID_PORT_2 = 2;
        public static final int SHOOTER_ARM_BOTTOM_SOLENOID_PORT_1 = 3;
        public static final int SHOOTER_ARM_BOTTOM_SOLENOID_PORT_2 = 4;
        public static final int INTAKE_ARM_SOLENOID_PORT_1 = 5;
        public static final int INTAKE_ARM_SOLENOID_PORT_2 = 6;
    }
}
