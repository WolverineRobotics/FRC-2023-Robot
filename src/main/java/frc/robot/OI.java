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
    public static final boolean takeObject(){
        return operatorController.getLeftBumperPressed();
    }

    public static final boolean releaseObject(){
        return operatorController.getRightBumperPressed();
    }
    public static final boolean moveWristForward(){
        return operatorController.getLeftY() > 0.3;
    }

    public static final boolean moveWristBackward(){
        return operatorController.getLeftY() < 0;
    }

}
