package org.firstinspires.ftc.teamcode.subsystems.collector;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.sax.StartElementListener;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class CollectorTemplate {

    public static double collectorOffPower = 0;
    public static double collectorInPower = 0.99;
    public static double collectorOutPower = -0.99;
    public double prevCollectorPower;

    public enum CollectorState{
        OFF, IN, OUT
    }

    public CollectorState collectorState;
    private DcMotor collectorMotor;

    public CollectorTemplate(HardwareMap hardwareMap,Telemetry telemetry) {
        collectorMotor = hardwareMap.get(DcMotor.class, "intake");
        setCollectorState(CollectorState.OFF);
    }

    public void update() {
        double curPower = 0;
        switch (collectorState) {
            case OFF:
                curPower = 0;
                collectorMotor.setPower(curPower);
                break;
            case IN:
                curPower = collectorInPower;
                collectorMotor.setPower(curPower);
                break;
            case OUT:
                curPower = collectorOutPower;
                collectorMotor.setPower(curPower);
                break;
        }


            telemetry.addData("Collector State", getCollectorState());
            telemetry.update();
    }

    public void setCollectorOff() {
        collectorMotor.setPower(collectorOffPower);
    }
    public void setCollectorIn() {
        collectorMotor.setPower(collectorInPower);
    }
    public void setCollectorOut() {
        collectorMotor.setPower(collectorOutPower);
    }
    public double getCollectorPower(){
        return collectorMotor.getPower();
    }
    public CollectorState getCollectorState() {
        return collectorState;
    }
    public void setCollectorState(CollectorState collectorState){
        this.collectorState = collectorState;
    }

}