package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {

    // Mobility
    private Joystick mobilityController;
    private boolean armUpBumper;
    private boolean armDownBumper;
    private double climberUpTrigger;
    private double climberDownTrigger;
    private double driveSpeedAxis;
    private double driveTurnAxis;
    private boolean driveSideToggle;
    private boolean limelightButton;
    private boolean stopCameraButton;

    // Manipulator
    private Joystick manipulatorController;
    private boolean intakeArmDownBumper;
    private boolean intakeArmUpBumper;
    private double intakeAxis;
    private double shooterTrigger;
    private boolean shooterModeToggle;
    private double feederOuttakeTrigger;
    private double chomperOverrideAxis;
    private boolean greenPositonButton;
    private boolean yellowPositionButton;
    private boolean bluePositionButton;
    private boolean redPositionButton;
    
    public Controllers() {
        mobilityController = new Joystick(Constants.ControllerConstants.MOBILITY_CONTROLLER_ID);
        manipulatorController = new Joystick(Constants.ControllerConstants.MANIPULATOR_CONTROLLER_ID);
    }

    public void updateControllerValues() {
        // Mobility
        armUpBumper = mobilityController.getRawButtonPressed(Constants.ControllerConstants.ARM_UP_BUMPER);
        armDownBumper = mobilityController.getRawButtonPressed(Constants.ControllerConstants.ARM_DOWN_BUMPER);
        climberUpTrigger = mobilityController.getRawAxis(Constants.ControllerConstants.CLIMBER_UP_TRIGGER);
        climberDownTrigger = mobilityController.getRawAxis(Constants.ControllerConstants.CLIMBER_DOWN_TRIGGER);
        driveSpeedAxis = mobilityController.getRawAxis(Constants.ControllerConstants.DRIVE_SPEED_AXIS);
        driveTurnAxis = mobilityController.getRawAxis(Constants.ControllerConstants.DRIVE_TURN_AXIS);
        driveSideToggle= mobilityController.getRawButtonPressed(Constants.ControllerConstants.DRIVE_SIDE_TOGGLE);
        limelightButton = mobilityController.getRawButton(Constants.ControllerConstants.LIMELIGHT_BUTTON);
        stopCameraButton = mobilityController.getRawButtonPressed(Constants.ControllerConstants.STOP_CAMERA_BUTTON);

        // Manipulator
        intakeArmDownBumper = manipulatorController.getRawButton(Constants.ControllerConstants.INTAKE_ARM_DOWN_BUMPER);
        intakeArmUpBumper = manipulatorController.getRawButton(Constants.ControllerConstants.INTAKE_ARM_UP_BUMPER);
        intakeAxis = -manipulatorController.getRawAxis(Constants.ControllerConstants.INTAKE_AXIS);
        shooterTrigger = manipulatorController.getRawAxis(Constants.ControllerConstants.SHOOTER_TRIGGER);
        shooterModeToggle = manipulatorController.getRawButtonPressed(Constants.ControllerConstants.SHOOTER_MODE_TOGGLE);
        feederOuttakeTrigger = manipulatorController.getRawAxis(Constants.ControllerConstants.FEEDER_OUTTAKE_TRIGGER);
        chomperOverrideAxis = -manipulatorController.getRawAxis(Constants.ControllerConstants.CHOMPER_OVERRIDE_AXIS);
        greenPositonButton = manipulatorController.getRawButtonPressed(Constants.ControllerConstants.GREEN_POSITION_BUTTON);
        yellowPositionButton = manipulatorController.getRawButtonPressed(Constants.ControllerConstants.YELLOW_POSITION_BUTTON);
        bluePositionButton = manipulatorController.getRawButtonPressed(Constants.ControllerConstants.BLUE_POSITION_BUTTON);
        redPositionButton = manipulatorController.getRawButtonPressed(Constants.ControllerConstants.RED_POSITION_BUTTON);
    }

    // Mobilty
    public boolean isArmUpBumper() {
        return armUpBumper;
    }

    public boolean isArmDownBumper() {
        return armDownBumper;
    }

    public double getClimberUpTrigger() {
        return climberUpTrigger;
    }

    public double getClimberDownTrigger() {
        return climberDownTrigger;
    }
    
    public double getDriveSpeedAxis() {
        return driveSpeedAxis;
    }

    public double getDriveTurnAxis() {
        return driveTurnAxis;
    }

    public boolean isDriveSideToggle() {
        return driveSideToggle;
    }

    public boolean isLimelightButton() {
        return limelightButton;
    }

    public boolean isStopCameraButton() {
        return stopCameraButton;
    }

    // Manipulator
    public boolean isIntakeArmDownBumper() {
        return intakeArmDownBumper;
    }

    public boolean isIntakeArmUpBumper() {
        return intakeArmUpBumper;
    }

    public double getIntakeAxis() {
        return intakeAxis;
    }

    public double getShooterTrigger() {
        return shooterTrigger;
    }

    public boolean isShooterModeToggle() {
        return shooterModeToggle;
    }

    public double getFeederOuttakeTrigger() {
        return feederOuttakeTrigger;
    }

    public double getChomperOverrideAxis() {
        return chomperOverrideAxis;
    } 

    public boolean isGreenPositionButton() {
        return greenPositonButton;
    }

    public boolean isYellowPositionButton() {
        return yellowPositionButton;
    }

    public boolean isBluePositionButton() {
        return bluePositionButton;
    }
    
    public boolean isRedPositionButton() {
        return redPositionButton;
    }
}
