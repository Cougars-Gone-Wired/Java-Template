package frc.robot;

// import phoenix to control motors
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// I assume the phoenix stuff has to do with the motors involved in the shooter?
// import com.ctre.phoenix.motorcontrol.ControlMode;
// anyway phoenix imports were here in the original

public class Shooter {
    // FPID ramps up motor speeds over time
    // the fancy math terms basically mean it calculates how to get
    // from the current speed to the desired speed
    public static double F = 0.045; // constant added
    public static double P = .6 // proportional (fraction multiplied)
    public static double I = 0.0001; // integral (area under the curve)
    public static double D = 10; // derivative (slope of the curve)
}