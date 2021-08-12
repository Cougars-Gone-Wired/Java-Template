package frc.robot;

// import phoenix to control motors
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// I assume the phoenix stuff has to do with the motors involved in the shooter?
// import com.ctre.phoenix.motorcontrol.ControlMode;
// anyway phoenix imports were here in the original

public class Shooter {
    /*
    There are two "ShooterModes":
        PID (proportional integral derivative) changes speed over time
        VOLTAGE gives a straight voltage amount to the motors.
    */

    // PID constants
    public static double F = 0.045; // constant added
    public static double P = 0.6 // proportional (fraction multiplied)
    public static double I = 0.0001; // integral (area under the curve)
    public static double D = 10; // derivative (slope of the curve)

    // Voltage constants
    public static double VOLTAGE_TO_VELOCITY = 20480; // need to figure out units
    public static double INITIAL_DESIRED_VELOCITY = INITIAL_SHOOTER_SPEED * VOLTAGE_TO_VELOCITY;
    public static double VOLTAGE_INITIAL_VELOCITY_THRESHOLD = 5;//250
    public static double PID_INITIAL_VELOCITY_THRESHOLD = 5;
    public static double VOLTAGE_VELOCITY_THRESHOLD = 130;//50
    public static double PID_VELOCITY_THRESHOLD = 70;
}