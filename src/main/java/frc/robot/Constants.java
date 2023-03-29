package frc.robot;

public class Constants {
    //DIO ports
    public static final int DRIVE_LEFT_ENCODER_A = 0; //plugged into NAVX
    public static final int DRIVE_LEFT_ENCODER_B = 1;
    public static final int DRIVE_RIGHT_ENCODER_A = 2;
    public static final int DRIVE_RIGHT_ENCODER_B = 3;

    public static final int LIFT_ENCODER_A = 1;
    public static final int LIFT_ENCODER_B = 2;
    public static final int LIFT_UPPER_LIMIT = 3;
    public static final int LIFT_LOWER_LIMIT = 4;

    public static final int SHOULDER_ENCODER_A = 5;
    public static final int SHOULDER_ENCODER_B = 6;
    
    public static final int ELBOW_ENCODER_A = 7;
    public static final int ELBOW_ENCODER_B = 8;

    public static final int INTAKE_CUBE_SENSOR = 9;

    //CAN
    public static final int DRIVE_LEFT_MOTOR_1 = 0;
    public static final int DRIVE_LEFT_MOTOR_2 = 1;
    public static final int DRIVE_RIGHT_MOTOR_1 = 2;
    public static final int DRIVE_RIGHT_MOTOR_2 = 3;

    public static final int ELEVATOR_MOTOR_A = 4;
    public static final int ELEVATOR_MOTOR_B = 5;

    public static final int SHOULDER_MOTOR = 6;
    public static final int ELBOW_MOTOR = 7;

    public static final int INTAKE_WRIST_MOTOR = 0; // I DONT KNOW WHAT VALUE THESE MOTORS SHOULD BE - OUEN
    public static final int INTAKE_WHEEL_MOTOR = 0; 

    //USB
    public static final int DRIVER_CONTROLLER = 0;
    public static final int OPERATOR_CONTROLLER = 1;
}