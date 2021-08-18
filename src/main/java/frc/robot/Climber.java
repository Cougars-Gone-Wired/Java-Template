package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode; //Desired mode when the Controller output throttle is neutral (brake/coast)
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup; //Allows for multiple SpeedController objects to be linked together.
import edu.wpi.first.wpilibj.Timer;

// import frc.robot.Constants.ClimberConstants;

public class Climber {

    //Motors
    private WPI_TalonSRX climberLeftMotor;
    private WPI_TalonSRX climberRightMotor;
    private SpeedControllerGroup climberMotors;

    //Speed (0-1)
    private static double CLIMBER_UP_SPEED = 1.0;
    private static double CLIMBER_DOWN_SPEED = 0.7;

    //Controls
    private boolean climberUpTriggerBool;
    private boolean climberDownTriggerBool;

    private static double startTime;


    public Climber() {
        climberLeftMotor = new WPI_TalonSRX(Constants.ClimberConstants.CLIMBER_LEFT_MOTOR_ID);
        climberRightMotor = new WPI_TalonSRX(Constants.ClimberConstants.CLIMBER_RIGHT_MOTOR_ID);
        climberMotors = new SpeedControllerGroup(climberLeftMotor, climberRightMotor);
        initalize();
    }

    public void initalize() {
        startTime = Timer.getFPGATimestamp(); //Returns robot run time in seconds.
        setNotMoving();
    }

    private enum ClimberStates {
        TOP, NOT_MOVING, MOVING_UP, MOVING_DOWN
    }

    private ClimberStates currentClimberState;

    public void climberControls(double climberUpTrigger, double climberDownTrigger) {
        climberUpTriggerBool = (climberUpTrigger >= Constants.ClimberConstants.DEADZONE);
        climberDownTriggerBool = (climberDownTrigger >= Constants.ClimberConstants.DEADZONE);

        switch (currentClimberState) {
            case TOP:
                if (climberUpTriggerBool && !climberDownTriggerBool && Robot.arms.isArmClimbingPosition()) {
                    setMovingUp();
                }else if (!climberUpTriggerBool && climberDownTriggerBool && Robot.arms.isArmClimbingPosition()) {
                    setMovingDown();
                }
                break;

            case NOT_MOVING:
                if (climberUpTriggerBool && !climberDownTriggerBool && Robot.arms.isArmClimbingPosition()) {
                    setMovingUp();
                }
                break;

            case MOVING_UP:
                if (!climberUpTriggerBool || climberDownTriggerBool) {
                    setTop();
                }
                break;
            
            case MOVING_DOWN:
                if (!climberDownTriggerBool || climberUpTriggerBool) {
                    setNotMoving();
                }
                break;
        }
    }

    public boolean isNotMoving() {
        return currentClimberState == ClimberStates.NOT_MOVING;
    }
    
    public boolean isMovingUp() {
        return currentClimberState == ClimberStates.MOVING_UP;
    }
    
    public boolean isMovingDown() {
        return currentClimberState == ClimberStates.MOVING_DOWN;
    }
    
    public void setTop() {
        climberMotors.set(0);
        currentClimberState = ClimberStates.TOP;
    }
    
    public void setNotMoving() {
        climberMotors.set(0);
        currentClimberState = ClimberStates.NOT_MOVING;
    }
    
    public void setMovingUp() {
        climberMotors.set(CLIMBER_UP_SPEED);
        currentClimberState = ClimberStates.MOVING_UP;
    }
    
    public void setMovingDown() {
        climberMotors.set(-CLIMBER_DOWN_SPEED);
        currentClimberState = ClimberStates.MOVING_DOWN;
    }
    
    public void setMotorsBrake() {
        climberLeftMotor.setNeutralMode(NeutralMode.Brake);
        climberRightMotor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void setMotorsCoast() {
        climberLeftMotor.setNeutralMode(NeutralMode.Coast);
        climberRightMotor.setNeutralMode(NeutralMode.Coast);
    }
    
    public static boolean isClimbTime() {
        return Timer.getFPGATimestamp() - startTime > 120;
    }
}