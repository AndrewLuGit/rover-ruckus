package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "test",group = "TeleOp")
public class BasicOpMode extends OpMode {
    private  StickyGamepad stickyGamepad1;
    private DcMotor driveLeft, driveRight;
    @Override
    public void init() {
        stickyGamepad1 = new StickyGamepad(gamepad1);
        driveLeft = hardwareMap.get(DcMotor.class,"tankLeft");
        driveRight = hardwareMap.get(DcMotor.class,"tankRight");
        driveLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        stickyGamepad1.update();

        double x=0, omega;

        x = gamepad1.left_stick_y;

        omega = gamepad1.right_stick_x;

        driveLeft.setPower(x-omega);
        driveRight.setPower(x+omega);
    }
}
