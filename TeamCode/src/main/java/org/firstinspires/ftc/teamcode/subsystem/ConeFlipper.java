package org.firstinspires.ftc.teamcode.subsystem;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ConeFlipper extends BaseSubsystem {
    public static class Constants {
        public static Hardware hardware;
        public static Position position;
        private static class Hardware{

            public static Servo.Direction BOTTOM_DIRECTION = Servo.Direction.FORWARD;
            public static Servo.Direction TOP_DIRECTION = Servo.Direction.FORWARD;

        }
        private static class Position {
            public static double
                    LIFT = 0,
                    DROP = 1;
            public static double
                    HIDDEN = 0,
                    GET_CONE = 0.5,
                    FEED_CONE = 1;
        }
    }

    private final Servo coneFlipperBottom;
    private final Servo coneFlipperTop;

    public ConeFlipper(@NonNull OpMode opMode) {
        super(opMode);
        coneFlipperBottom = opMode.hardwareMap.get(Servo.class, "coneFlipperBottom");
        coneFlipperTop = opMode.hardwareMap.get(Servo.class, "coneFlipperTop");

        coneFlipperTop.setDirection(Constants.Hardware.TOP_DIRECTION);
        coneFlipperBottom.setDirection(Constants.Hardware.BOTTOM_DIRECTION);

        hide();
        lift();
    }

    @Override
    protected void manualControl() {

    }

    public void hide() {
        coneFlipperTop.setPosition(Constants.Position.HIDDEN);
    }

    public void lift() {
        coneFlipperBottom.setPosition(Constants.Position.LIFT);
    }

    public void getCone() {
        coneFlipperTop.setPosition(Constants.Position.GET_CONE);
    }

    public void drop() {
        coneFlipperBottom.setPosition(Constants.Position.DROP);
    }

    public void feedCone() {
        coneFlipperTop.setPosition(Constants.Position.FEED_CONE);
    }
}
