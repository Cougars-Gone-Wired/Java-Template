package frc.robot;

// Phoenix is used to control and configure the Falcon 500 motor(s)
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// https://www.ctr-electronics.com/downloads/api/java/html/enumcom_1_1ctre_1_1phoenix_1_1motorcontrol_1_1_control_mode.html
import com.ctre.phoenix.motorcontrol.ControlMode;
// for letting the shooter motor coast instead of brake in neutral mode
import com.ctre.phoenix.motorcontrol.NeutralMode;
// manage sensors
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;


// I assume the phoenix stuff has to do with the motors involved in the shooter?
// import com.ctre.phoenix.motorcontrol.ControlMode;
// anyway phoenix imports were here in the original

public class Shooter {
    /*
    There are two "ShooterModes":
        PID (proportional integral derivative) changes speed over time
        VOLTAGE gives a straight voltage amount to the motors (dead reckoning)
    */

    // PID constants
    public static double F = 0.045;  // constant added
    public static double P = 0.6;    // proportional (fraction multiplied)
    public static double I = 0.0001; // integral (area under the curve)
    public static double D = 10;     // derivative (slope of the curve)

    // Voltage constants
    public static double VOLTAGE_TO_VELOCITY = 20480; // need to figure out units
    public static double INITIAL_DESIRED_VELOCITY = INITIAL_SHOOTER_SPEED * VOLTAGE_TO_VELOCITY;
    public static double VOLTAGE_INITIAL_VELOCITY_THRESHOLD = 5;//250
    public static double PID_INITIAL_VELOCITY_THRESHOLD = 5;
    public static double VOLTAGE_VELOCITY_THRESHOLD = 130;//50
    public static double PID_VELOCITY_THRESHOLD = 70;
}