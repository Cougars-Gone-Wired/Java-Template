package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Arms {
    
    private DoubleSolenoid shooterArmTopSolenoid;
    private DoubleSolenoid shooterArmBottomSolenoid;
    private DoubleSolenoid intakeArmSolenoid;

    public Arms() {
        shooterArmTopSolenoid = new DoubleSolenoid(Constants.ArmConstants.SHOOTER_ARM_TOP_SOLENOID_PORT_1, Constants.ArmConstants.SHOOTER_ARM_TOP_SOLENOID_PORT_2);
        shooterArmBottomSolenoid = new DoubleSolenoid(Constants.ArmConstants.SHOOTER_ARM_BOTTOM_SOLENOID_PORT_1, Constants.ArmConstants.SHOOTER_ARM_BOTTOM_SOLENOID_PORT_2);
        intakeArmSolenoid = new DoubleSolenoid(Constants.ArmConstants.INTAKE_ARM_SOLENOID_PORT_1, Constants.ArmConstants.INTAKE_ARM_SOLENOID_PORT_2);
        initialize();
    }

    public void initialize() {
        setStartingPosition();
        setUpPosition();
    }

    public enum ShooterArmStates {
        STARTING_POSITION, SHOOTING_POSITION, UPPER_SHOOTING_POSITION, CLIMBING_POSITION
    }

    private ShooterArmStates currentShooterArmState;

    public void controlArm(boolean moveUpButton, boolean moveDownButton) {

        switch (currentShooterArmState) {
            case STARTING_POSITION:
                if (moveDownButton && !moveUpButton) {
                    setShootingPosition();
                } else if (!moveDownButton && moveUpButton && currentIntakeArmState != IntakeShooterArmStates.UP) {
                    setUpperShootingPosition();
                }
                break;

            case SHOOTING_POSITION:
                if (!moveDownButton && moveUpButton) {
                    setStartingPosition();
                }
                break;

            case UPPER_SHOOTING_POSITION:
                if (moveDownButton && !moveUpButton) {
                    setStartingPosition();
                } else if (!moveDownButton && moveUpButton && currentIntakeArmState != IntakeShooterArmStates.UP) {
                    setClimbingPosition();
                }
                break;

            case CLIMBING_POSITION:
                if (moveDownButton && !moveUpButton) {
                    setUpperShootingPosition();
                }
                break;
        }
    }

    public boolean isArmStartingPosition() {
        return currentShooterArmState == ShooterArmStates.STARTING_POSITION;
    }

    public boolean isArmShootingPosition() {
        return currentShooterArmState == ShooterArmStates.SHOOTING_POSITION;
    }

    public boolean isArmUpperShootingPosition() {
        return currentShooterArmState == ShooterArmStates.UPPER_SHOOTING_POSITION;
    }

    public boolean isArmClimbingPosition() {
        return currentShooterArmState == ShooterArmStates.CLIMBING_POSITION;
    }

    public void setStartingPosition() {
        shooterArmTopSolenoid.set(DoubleSolenoid.Value.kForward);
        shooterArmBottomSolenoid.set(DoubleSolenoid.Value.kReverse);
        currentShooterArmState = ShooterArmStates.STARTING_POSITION;
    }

    public void setShootingPosition() {
        shooterArmTopSolenoid.set(DoubleSolenoid.Value.kReverse);
        shooterArmBottomSolenoid.set(DoubleSolenoid.Value.kReverse);
        currentShooterArmState = ShooterArmStates.SHOOTING_POSITION;
    }

    public void setUpperShootingPosition() {
        shooterArmTopSolenoid.set(DoubleSolenoid.Value.kReverse);
        shooterArmBottomSolenoid.set(DoubleSolenoid.Value.kForward);
        currentShooterArmState = ShooterArmStates.UPPER_SHOOTING_POSITION;
    }

    public void setClimbingPosition() {
        shooterArmTopSolenoid.set(DoubleSolenoid.Value.kForward);
        shooterArmBottomSolenoid.set(DoubleSolenoid.Value.kForward);
        currentShooterArmState = ShooterArmStates.CLIMBING_POSITION;
    }

    public enum IntakeShooterArmStates {
        UP, DOWN
    }

    private IntakeShooterArmStates currentIntakeArmState;

    public void controlIntakeArm(boolean intakeArmDownBumper, boolean intakeArmUpBumper) {

        switch (currentIntakeArmState) {
            case DOWN:
                if (!intakeArmDownBumper && intakeArmUpBumper && currentShooterArmState != ShooterArmStates.CLIMBING_POSITION) {
                    setUpPosition();
                }
                break;

            case UP:
                if (intakeArmDownBumper && !intakeArmUpBumper) {
                    setDownPosition();
                }
                break;
        }
    }

    public boolean isIntakeUpPositon() {
        return currentIntakeArmState == IntakeShooterArmStates.UP;
    }

    public boolean isIntakeDownPositon() {
        return currentIntakeArmState == IntakeShooterArmStates.DOWN;
    }

    public void setUpPosition() {
        intakeArmSolenoid.set(DoubleSolenoid.Value.kReverse);
        currentIntakeArmState = IntakeShooterArmStates.UP;
    }

    public void setDownPosition() {
        intakeArmSolenoid.set(DoubleSolenoid.Value.kForward);
        currentIntakeArmState = IntakeShooterArmStates.DOWN;
    }
}
