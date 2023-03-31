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
    public static final double getIntakeSpeed(){

        double forward = 0, backward = 0;

        if(operatorController.getLeftBumperPressed()){
            backward = 1;
        }
        if(operatorController.getRightBumperPressed()){
            forward = 1;
        }

        return forward - backward;
    }


    // Intake Wrist Rotation
    public static final double getWristSpeed(){
        double forward = 0, backward = 0;

        //if (operatorController.getPOV() == 0) {
        //    forward = 1;
        //}
        //if (operatorController.getPOV() == 180) {
        //    backward = 1;
        //}

        if (operatorController.getPOV() == 0) {
            return 1;
        }
        if (operatorController.getPOV() == 180) {
            return -1;
        }
        else{
            return 0;
        }
        //return forward - backward;
    }



    // Driver Inputs, comment sponsored by RaidyShadyLaidy69 
    public static final double getDriverSpeed(){
        return driverController.getLeftY();
    }

    public static final double getDriverRotation(){
        return driverController.getRightX();
    }
    public static final boolean balance(){
        return driverController.getAButton();
    }

    // Elevator Inputs
    public static double manualelevatorUp(){
        return operatorController.getRightTriggerAxis();
    }

    public static double manualelevatorDown(){
        return operatorController.getLeftTriggerAxis();
    }

    public static boolean autoelevatorRetraction(){
        return operatorController.getAButton();
    }
}
