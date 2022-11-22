package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.Drive;
import org.firstinspires.ftc.teamcode.subsystem.Gripper;
import org.firstinspires.ftc.teamcode.subsystem.Lift;
@TeleOp
public class TeleOp13266 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Lift lift = new Lift(this);
        Gripper gripper = new Gripper(this);
        Drive drive = new Drive(this,true);
        //insert iniit here

        waitForStart();
        while (opModeIsActive()) {
            drive.manualControl();
            lift.teleOpCommand();
            gripper.teleOpCommand();
            telemetry.update();
        }

    }
}
