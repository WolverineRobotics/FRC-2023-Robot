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

    public static boolean manualelevatorRetraction(){
        return operatorController.getAButton();

         /* I'm not sure if I am to account for partial pressing of triggers..
            So that when it reaches a value where x > 0.5 or x < 0.5 for example, it should trip and execute.
            No account for buttons since they're either 0 or 1 I guess?
         */ 

    }
}