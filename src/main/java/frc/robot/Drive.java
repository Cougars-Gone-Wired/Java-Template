package frc.robot;

// import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class Drive extends SubsystemBase { //NOTE: Understand SubsystemBase (https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj2/command/SubsystemBase.html)
    
    private WPI_TalonFX leftFrontMotor;
    private WPI_TalonFX leftMiddleMotor;
    private WPI_TalonFX leftRearMotor;
    private WPI_TalonFX rightFrontMotor;
    private WPI_TalonFX rightMiddleMotor;
    private WPI_TalonFX rightRearMotor;

    public Drive() {
        leftFrontMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_FRONT_MOTOR_ID);
        leftMiddleMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_MIDDLE_MOTOR_ID);
        leftRearMotor = new WPI_TalonFX(Constants.DriveConstants.LEFT_REAR_MOTOR_ID);
        rightFrontMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_FRONT_MOTOR_ID);
        rightMiddleMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_MIDDLE_MOTOR_ID);
        rightRearMotor = new WPI_TalonFX(Constants.DriveConstants.RIGHT_REAR_MOTOR_ID);
    }
}
