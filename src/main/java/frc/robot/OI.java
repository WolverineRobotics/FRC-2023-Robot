package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static XboxController driverController;
    private static XboxController operatorController;

    public OI(){
        driverController = new XboxController(Constants.DRIVER_CONTROLLER);
        operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);
    }

    public static double manualElevatorUp(){
        return operatorController.getRightTriggerAxis() > 0.3; 
    }
    public static double manualElevatorDown(){
        return operatorController.getLeftTriggerAxis() < 0.3; 
    }
    public static double manualElevatorRetract(){
        return operatorController.getAButton(); 

        /* Possibly no need for any values to pass through this? 
           I feel like it'll just check if getAButton is (0, 1), no need to check for any partial presses.
        */
    }
}
