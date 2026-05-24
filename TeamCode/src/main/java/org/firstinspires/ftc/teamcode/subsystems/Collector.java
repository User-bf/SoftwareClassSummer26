package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Collector {
    public enum IntakeState {
        OFF,
        INTAKE,
        EXTAKE
    }

    private final DcMotorEx intakeMotor;
    public IntakeState intakeState = IntakeState.OFF;
    private double lastFrameMotorPower = 0;

    public Collector(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotorEx.class, Hardware.intakeMotorName);
    }

    public void update() {
        double motorPower = 0;

        switch (intakeState) {
            case OFF:
                motorPower = 0;
                break;
            case INTAKE:
                motorPower = 1;
                break;
            case EXTAKE:
                motorPower = -1;
                break;
        }

        if (Math.abs(motorPower - lastFrameMotorPower) > 0.001)
            intakeMotor.setPower(motorPower);

        lastFrameMotorPower = motorPower;
    }

    public IntakeState getIntakeState() {
        return intakeState;
    }
    public void setIntakeState(IntakeState intakeState) {
        this.intakeState = intakeState;
    }
}