package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static XboxController driverController;
    private static XboxController operatorController;

    public OI(){
        driverController = new XboxController(Constants.DRIVER_CONTROLLER);
        operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);
    }

    public static final boolean exampleButton(){
        return driverController.getAButton();
    }

    // Intake Inputs
    public static final boolean takeCone(){
        return operatorController.getLeftBumperPressed();
    }

    public static final boolean releaseCone(){
        return operatorController.getRightBumperPressed();
    }

    public static final boolean takeCube(){
        return operatorController.getLeftTriggerAxis() > 0;
    }

    public static final boolean releaseCube(){
        return operatorController.getRightTriggerAxis() > 0;
    }
}
