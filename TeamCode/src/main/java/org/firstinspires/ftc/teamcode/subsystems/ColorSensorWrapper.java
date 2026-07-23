package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ColorSensorWrapper {
    public static double minR = 0.2, maxR = 0.4;
    public static double minG = 0.4, maxG = 0.6;
    public static double minB = 0, maxB = 0.25;

    // cached color sensor values
    private double red, green, blue;
    private double sensorRed, sensorGreen, sensorBlue;
    private final Telemetry telemetry;
    private final ColorSensor colorSensor;

    public ColorSensorWrapper(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.colorSensor = hardwareMap.get(ColorSensor.class, "color sensor");
    }

    public void update() {
        sensorRed = colorSensor.red();
        sensorGreen = colorSensor.green();
        sensorBlue = colorSensor.blue();

        double sum = sensorRed + sensorGreen + sensorBlue;

        red = (sensorRed / sum) * 255;
        green = (sensorGreen / sum) * 255;
        blue = (sensorBlue / sum) * 255;

        telemetry.addData("red", red);
        telemetry.addData("green", green);
        telemetry.addData("blue", blue);
    }

    public boolean seesColorInRange() {
        boolean redValid = minR<=red && maxR>=red;
        boolean greenValid = minG<=green && maxG>=green;
        boolean blueValid = minB<=blue && maxB>=blue;

        return redValid && greenValid && blueValid;
    }
}
