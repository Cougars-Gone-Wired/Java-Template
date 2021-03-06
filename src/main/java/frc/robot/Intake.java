
package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake {
    private static final double INTAKE_SPEED = 0.75;

    private WPI_TalonSRX intakeMotor;

    public Intake() {
        intakeMotor = new WPI_TalonSRX(Constants.IntakeConstants.INTAKE_MOTOR_ID);
        initialize();
    }

    public void initialize() {
        setNotMoving();
    }

    public enum IntakeStates {
        NOT_MOVING, INTAKING, OUTTAKING
    }

    private IntakeStates currentIntakeState;

    public void controlIntake(double intakeAxis) {

        switch (currentIntakeState) {
            case NOT_MOVING:
                if (intakeAxis >= Constants.IntakeConstants.DEADZONE
                        && Robot.arms.isArmShootingPosition() 
                        && !Robot.arms.isArmClimbingPosition()) {
                    setIntaking();
                } else if (intakeAxis <= -Constants.IntakeConstants.DEADZONE 
                        && !Robot.arms.isIntakeUpPositon() 
                        && Robot.arms.isArmShootingPosition() && 
                        !Robot.arms.isArmClimbingPosition()) {
                    setOuttaking();
                }
                break;

            case INTAKING:
                if (Robot.arms.isIntakeUpPositon()) {
                    setStop();
                } else {
                    setIntaking();
                }
                if (intakeAxis < Constants.IntakeConstants.DEADZONE  
                        || !Robot.arms.isArmShootingPosition()
                        || Robot.arms.isArmClimbingPosition()) {
                    setNotMoving();
                }
                break;

            case OUTTAKING:
                if (intakeAxis > -Constants.IntakeConstants.DEADZONE 
                        || Robot.arms.isIntakeUpPositon() 
                        || !Robot.arms.isArmShootingPosition()
                        || Robot.arms.isArmClimbingPosition()) {
                    setNotMoving();
                }
                break;
        }
    }

    public boolean isNotMoving() {
        return currentIntakeState == IntakeStates.NOT_MOVING;
    }

    public boolean isIntaking() {
        return currentIntakeState == IntakeStates.INTAKING;
    }

    public boolean isOuttaking() {
        return currentIntakeState == IntakeStates.OUTTAKING;
    }

    public void setNotMoving() {
        intakeMotor.set(0);
        currentIntakeState = IntakeStates.NOT_MOVING;
    }

    public void setIntaking() {
        intakeMotor.set(INTAKE_SPEED);
        currentIntakeState = IntakeStates.INTAKING;
    }

    public void setOuttaking() {
        intakeMotor.set(-INTAKE_SPEED);
        currentIntakeState = IntakeStates.OUTTAKING;
    }

    public void setStop() {
        intakeMotor.set(0);
    }

    public void setMotorsBrake() {
        intakeMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void setMotorsCoast() {
        intakeMotor.setNeutralMode(NeutralMode.Coast);
    }
} 