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

    /*
    public static double manualElevatorUp(){
        return operatorController.getRightTriggerAxis(); 
    }
    public static double manualElevatorDown(){
        return operatorController.getLeftTriggerAxis(); 
    }
    public static double manualElevatorRetract(){
        return operatorController.getAButton();
    }
    */
}
