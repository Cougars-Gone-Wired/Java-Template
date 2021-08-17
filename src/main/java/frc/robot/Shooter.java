package frc.robot;

// Phoenix is used to control and configure the Falcon 500 motor(s)
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// https://www.ctr-electronics.com/downloads/api/java/html/enumcom_1_1ctre_1_1phoenix_1_1motorcontrol_1_1_control_mode.html
import com.ctre.phoenix.motorcontrol.ControlMode;
// for letting the shooter motor coast instead of brake in neutral mode
import com.ctre.phoenix.motorcontrol.NeutralMode;
// manage sensors
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;

public class Shooter {
    public static double INITIAL_SHOOTER_SPEED = 1.00; // -1 to 1

    /*
    There are two "ShooterModes":
        PID (proportional integral derivative) changes speed over time
        VOLTAGE gives a straight voltage amount to the motors (dead reckoning)
    */
    public enum ShooterModes {
        VOLTAGE, PID
    }
    ShooterModes currentShooterMode;

    public enum ShooterStates {
        NOT_MOVING, SHOOTING
    }
    private ShooterStates currentShooterState; // not sure why this is private

    // PID constants
    public static double F = 0.045;  // constant added
    public static double P = 0.6;    // proportional (fraction multiplied)
    public static double I = 0.0001; // integral (area under the curve)
    public static double D = 10;     // derivative (slope of the curve)
    // how fast we have to be going to start motors when on PID
    public static double PID_INITIAL_VELOCITY_THRESHOLD = 5;
    // how close we have to be to the real value (acceptable error) when on PID
    public static double PID_VELOCITY_THRESHOLD = 70;

    // Voltage constants
    public static double VOLTAGE_TO_VELOCITY = 20480; // need to figure out units
    public static double INITIAL_DESIRED_VELOCITY = INITIAL_SHOOTER_SPEED * VOLTAGE_TO_VELOCITY;
    // how fast we have to be going to start motors when on voltage
    public static double VOLTAGE_INITIAL_VELOCITY_THRESHOLD = 5;
    // how close we have to be to the real value (acceptable error) when on voltage
    public static double VOLTAGE_VELOCITY_THRESHOLD = 130;

}