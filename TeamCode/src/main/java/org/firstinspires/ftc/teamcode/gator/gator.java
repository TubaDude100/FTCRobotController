package org.firstinspires.ftc.teamcode.gator;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.Random;

@TeleOp(name = "gator")
public class gator extends LinearOpMode {

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

            time.reset();



            int rand_time = random_time.nextInt((high_bound-low_bound) + low_bound);
            int rand_tail = random_tail.nextInt(3);

            telemetry.addData("rand_time", rand_time);
            telemetry.addData("rand_tale", rand_tail);
            telemetry.addData("time", time.seconds());
            telemetry.update();

            Thread.sleep(rand_time * 500);

            if(rand_time <= time.seconds()){
                if(head.getPosition() >= 0.4){
                    head.setPosition(0.15);
                } else {
                    head.setPosition(0.65);
                }

                if(rand_tail == 0){
                    tail_front.setPosition(0.5);
                    tail_back.setPosition(0.35);
                } if (rand_tail == 1){
                    tail_front.setPosition(0.8);
                    tail_back.setPosition(0.65);
                } if (rand_tail == 2){
                    Thread.sleep(1);
                } else {
                }

                time.reset();

            }
            telemetry.addData("rand_time", rand_time/2);
            telemetry.addData("rand_tale", rand_tail);
            telemetry.addData("time", time.seconds());
            telemetry.update();

        }

    }
}
