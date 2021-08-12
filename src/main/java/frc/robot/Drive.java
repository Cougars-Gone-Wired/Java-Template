package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase { //NOTE: Understand SubsystemBase (https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj2/command/SubsystemBase.html)
    
    // The speed adjustment factors on a scale of 0 (never moves) to 1 (full power)
    public static double DRIVE_SPEED = 0.7;
    public static double TURN_SPEED = 0.5;

    // Define motor, 
    private WPI_TalonFX leftFrontMotor;
    private WPI_TalonFX leftMiddleMotor;
    private WPI_TalonFX leftRearMotor;
    private SpeedControllerGroup leftMotors;

    private WPI_TalonFX rightFrontMotor;
    private WPI_TalonFX rightMiddleMotor;
    private WPI_TalonFX rightRearMotor;
    private SpeedControllerGroup rightMotors;

    private DifferentialDrive robotDrive;
    // private Encoders encoders;
    // private Gyro gyro;

    public Drive() {
        leftFrontMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_FRONT_MOTOR_ID);
        leftMiddleMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_MIDDLE_MOTOR_ID);
        leftRearMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_REAR_MOTOR_ID);
        leftMotors = new SpeedControllerGroup(leftFrontMotor, leftMiddleMotor, leftRearMotor);

        rightFrontMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_FRONT_MOTOR_ID);
        rightMiddleMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_MIDDLE_MOTOR_ID);
        rightRearMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_REAR_MOTOR_ID);
        rightMotors = new SpeedControllerGroup(rightFrontMotor, rightMiddleMotor, rightRearMotor);

        // encoders = new Encoders(this);
        // gyro = new Gyro();

        initMotors();

        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
        robotDrive.setDeadband(Constants.DriveConstants.DEADZONE);
        robotDrive.setSafetyEnabled(false);

        initalize();
    }

    public void initMotors() {
        leftFrontMotor.configOpenloopRamp(0);
        leftMiddleMotor.configOpenloopRamp(0);
        leftRearMotor.configOpenloopRamp(0);

        rightFrontMotor.configOpenloopRamp(0);
        rightMiddleMotor.configOpenloopRamp(0);
        rightRearMotor.configOpenloopRamp(0);
    }

    public void initalize() {
        leftFrontMotor.set(0);
        leftMiddleMotor.set(0);
        leftRearMotor.set(0);

        rightFrontMotor.set(0);
        rightMiddleMotor.set(0);
        rightRearMotor.set(0);

        // resetOdometry(new Pose2d());

        currentDriveState = DriveStates.SHOOTER_SIDE;
    }

    public enum DriveStates {
        SHOOTER_SIDE, INTAKE_SIDE
    }

    private DriveStates currentDriveState;

    public void robotDrive(double driveSpeedAxis, double driveTurnAxis, boolean toggle) {
        driveSpeedAxis *= DRIVE_SPEED;
        driveTurnAxis *= TURN_SPEED;

        switch (currentDriveState) {
            case SHOOTER_SIDE:
                robotDrive.arcadeDrive(driveSpeedAxis, -driveTurnAxis);
                if (toggle) {
                    setIntakeSide();
                }
                break;

            case INTAKE_SIDE:
                robotDrive.arcadeDrive(-driveSpeedAxis, -driveTurnAxis);
                if (toggle) {
                    setShooterSide();
                }
                break;
        }
    }

    public boolean isShooterSide() {
        return currentDriveState == DriveStates.SHOOTER_SIDE;
    }
    
    public boolean isIntakeSide() {
        return currentDriveState == DriveStates.INTAKE_SIDE;
    }

    public void setShooterSide() {
        currentDriveState = DriveStates.SHOOTER_SIDE;
    }

    public void setIntakeSide() {
        currentDriveState = DriveStates.INTAKE_SIDE;
    }

    public void setMotorsBrake() {
        leftFrontMotor.setNeutralMode(NeutralMode.Brake);
        leftMiddleMotor.setNeutralMode(NeutralMode.Brake);
        leftRearMotor.setNeutralMode(NeutralMode.Brake);

        rightFrontMotor.setNeutralMode(NeutralMode.Brake);
        rightMiddleMotor.setNeutralMode(NeutralMode.Brake);
        rightRearMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setMotorsCoast() {
        leftFrontMotor.setNeutralMode(NeutralMode.Coast);
        leftMiddleMotor.setNeutralMode(NeutralMode.Coast);
        leftRearMotor.setNeutralMode(NeutralMode.Coast);

        rightFrontMotor.setNeutralMode(NeutralMode.Coast);
        rightMiddleMotor.setNeutralMode(NeutralMode.Coast);
        rightRearMotor.setNeutralMode(NeutralMode.Coast);
    }

    // public void resetSensors() {
    //     encoders.resetEncoders();
    //     gyro.zeroHeading();
    // }
}
