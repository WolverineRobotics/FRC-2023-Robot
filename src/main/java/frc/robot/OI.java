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
    // Triggers now used for intake/output of cones and cubes 
    public static final boolean takeConeCube(){
        return operatorController.getLeftTriggerAxis() > 0;
    }

    public static final boolean releaseConeCube(){
        return operatorController.getRightTriggerAxis() > 0;
    }
}
