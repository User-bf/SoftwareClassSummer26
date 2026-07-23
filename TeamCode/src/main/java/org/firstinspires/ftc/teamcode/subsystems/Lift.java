package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift {
    private DcMotor liftMotor;
    private Telemetry telemetry;
    private double targetPos;
    public Lift(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        this.liftMotor = hardwareMap.get(DcMotor.class, "lift motor");

    }
}
