package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ArmSubSystem extends SubsystemBase{

    private final CANSparkMax m_topMotor1; // Elbow Motor
    private final CANSparkMax m_bottomMotor1; // Arm Motor
    private final Encoder shoulder_encoder, elbow_encoder; // Encoders

    // Initial Positions of Shoulder/Elbow
    private int shoulder_position = 0 
    private int elbow_position = 0  

    public ArmSystem(){

        m_topMotor1 = new CANSparkMax(Constants.ELBOW_MOTOR); 
        m_bottomMotor1 = new CANSparkMax(Constants.SHOULDER_MOTOR);
        shoulder_encoder = new Encoder(Constants.SHOULDER_ENCODER_A, Constants.SHOULDER_ENCODER_B, false, Encoder.EncodingType.k2X);

    }

    public void rotateElbow(double speed){
        m_topMotor1.set(speed);
    }

    public void rotateShoulder(double speed){
        m_bottomMotor1.set(speed);
    }

    public int getShoulderAngle(){
        return shoulder_encoder.get();
    }
}
