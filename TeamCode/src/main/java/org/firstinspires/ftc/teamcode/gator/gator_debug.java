package org.firstinspires.ftc.teamcode.gator;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Random;

@TeleOp(name = "gator")
public class gator_debug extends LinearOpMode {

    protected Servo head;
    protected Servo tail_back;
    protected Servo tail_front;

    Random random_time = new Random();
    Random random_tail = new Random();
    ElapsedTime time = new ElapsedTime();


    public void defaultInit(){
        head = hardwareMap.get(Servo.class, "head");
        tail_back = hardwareMap.get(Servo.class, "tail_back");
        tail_front = hardwareMap.get(Servo.class, "tail_front");
    }

    @Override
    public void runOpMode() throws InterruptedException {

        defaultInit();
        int low_bound = 40;
        int high_bound = 80;

        while (!isStarted() && !isStopRequested()) {
            head.setPosition(0.15);
            tail_back.setPosition(0.5);
            tail_front.setPosition(0.5);
        }

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            if(gamepad2.a){
                head.setPosition(0.15);
            }
            if(gamepad2.b){
                head.setPosition(0.5);
            }
            if(gamepad2.x) {
                tail_front.setPosition(0.35);
                tail_back.setPosition(0.35);
            }
            if(gamepad2.y) {
                tail_front.setPosition(0.42);
                tail_back.setPosition(0.42);
            }
            if(gamepad2.left_bumper) {
                tail_front.setPosition(0.5);
                tail_back.setPosition(0.43);
            }
            if(gamepad2.right_bumper) {
                tail_front.setPosition(0.5);
                tail_back.setPosition(0.57);
            }
            if(gamepad2.dpad_down) {
                tail_front.setPosition(0.58);
                tail_back.setPosition(0.58);
            }
            if(gamepad2.dpad_up) {
                tail_front.setPosition(0.65);
                tail_back.setPosition(0.65);
            }

        }

    }
}
