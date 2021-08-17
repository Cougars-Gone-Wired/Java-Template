package frc.robot;

// Phoenix is used to control and configure the Falcon 500 motor(s)
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// control modes specify velocity profiles, motion profiling?
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
    public static int IZONE = 1400;  // related to PID but I don't know how yet
    public static double D = 10;     // derivative (slope of the curve)

    // how fast we have to be going to start motors when on PID
    public static double PID_INITIAL_VELOCITY_THRESHOLD = 5;
    // how close we have to be to the real value (acceptable error) when on PID
    public static double PID_VELOCITY_THRESHOLD = 70;

    // Voltage constants
    // need to figure out units
    public static double VOLTAGE_TO_VELOCITY = 20480;
    public static double INITIAL_DESIRED_VELOCITY = INITIAL_SHOOTER_SPEED * VOLTAGE_TO_VELOCITY;
    // how fast we have to be going to start motors when on voltage
    public static double VOLTAGE_INITIAL_VELOCITY_THRESHOLD = 5;
    // how close we have to be to the real value (acceptable error) when on voltage
    public static double VOLTAGE_VELOCITY_THRESHOLD = 130;

    private WPI_TalonFX shooterMotor;
    private TalonFXSensorCollection sensors;

    private double shooterSpeed;
    private double desiredVelocity;

    public Shooter() {
        shooterMotor = new WPI_TalonFX(Constants.ShooterConstants.SHOOTER_MOTOR_ID);
        sensors = new TalonFXSensorCollection(shooterMotor);
        initialize();
    }

    public void initialize() {
        // change motor spin direction (may be removed depending on the robot)
        shooterMotor.setInverted(true);
        // coast (as opposed to brake) when not giving voltage to the motor
        shooterMotor.setNeutralMode(NeutralMode.Coast);

        // set up PID
        // args for these functions are: slot, value, timeout in ms
        shooterMotor.config_kF(0, F, 10);
        shooterMotor.config_kP(0, P, 10);
        shooterMotor.config_kI(0, I, 10);
        shooterMotor.config_IntegralZone(0, IZONE, 10);
        shooterMotor.config_kD(0, D, 10);
        
        setNotMoving();
        shooterSpeed = INITIAL_SHOOTER_SPEED;
        desiredVelocity = INITIAL_DESIRED_VELOCITY;
    }

    public void setNotMoving() {
        shooterMotor.set(0);
        currentShooterState = ShooterStates.NOT_MOVING;
    }
}