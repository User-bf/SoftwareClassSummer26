package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.collector.CollectorTemplate;

import java.util.stream.Collector;

@Config
@TeleOp(name = "Test TeleOp", group = "TeleOp")
public class TestTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        CollectorTemplate collector = new CollectorTemplate(hardwareMap, telemetry);

        waitForStart();
        telemetry.update();

        while (opModeIsActive()){
            if(gamepad1.right_bumper) {
                if(collector.getCollectorState() == CollectorTemplate.CollectorState.OFF){
                    collector.setCollectorState(CollectorTemplate.CollectorState.IN);
                }
                else if (collector.getCollectorState() == CollectorTemplate.CollectorState.IN){
                    collector.setCollectorState(CollectorTemplate.CollectorState.OFF);
                }
            } else if(gamepad1.left_bumper) {
                if(collector.getCollectorState() == CollectorTemplate.CollectorState.OFF){
                    collector.setCollectorState(CollectorTemplate.CollectorState.OUT);
                }
                else if (collector.getCollectorState() == CollectorTemplate.CollectorState.OUT){
                    collector.setCollectorState(CollectorTemplate.CollectorState.OFF);
                }
            }
        }
    }
}
