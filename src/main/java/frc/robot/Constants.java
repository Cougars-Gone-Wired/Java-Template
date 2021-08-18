package frc.robot;

public class Constants {

    // Drive constants here
    public class DriveConstants{

        // Drive motor controller IDs go here. NOTE: Maybe should be on Settings page on Dashboard?
        public static final int LEFT_FRONT_MOTOR_ID = 1;
        public static final int LEFT_MIDDLE_MOTOR_ID = 2;
        public static final int LEFT_REAR_MOTOR_ID = 3;
        public static final int RIGHT_FRONT_MOTOR_ID = 4;
        public static final int RIGHT_MIDDLE_MOTOR_ID = 5;
        public static final int RIGHT_REAR_MOTOR_ID = 6;
        
    }

    // Climber constants here
    public class ClimberConstants{
        public static final double DEADZONE = 0.15;
        public static final int CLIMBER_LEFT_MOTOR_ID = 1;
        public static final int CLIMBER_RIGHT_MOTOR_ID = 2; 
    }

    // Shooter constants here
    public class ShooterConstants{
        public static final int SHOOTER_MOTOR_ID = 1;
    }
}
