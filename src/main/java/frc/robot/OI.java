package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
    private static XboxController driverController;
    private static XboxController operatorController;

    public OI(){
        driverController = new XboxController(Constants.DRIVER_CONTROLLER);
        operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);
    }

    public static double manualelevatorUp(){
        return operatorController.getLeftTriggerAxis();
    }

    public static double manualelevatorDown(){
        return operatorController.getRightTriggerAxis();
    }

    public static boolean autoelevatorRetraction(){
        return operatorController.getAButton();
    }
}