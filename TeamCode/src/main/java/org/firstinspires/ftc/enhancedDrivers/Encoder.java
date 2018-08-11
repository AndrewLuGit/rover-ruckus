package org.firstinspires.ftc.enhancedDrivers;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Encoder {
    private ExpansionHub HUB;
    private int PORT;
    private int PPR;
    private int resetTicks = 0;
    private int secant = 1;
    DcMotorSimple.Direction direction = DcMotorSimple.Direction.FORWARD;

    public Encoder(ExpansionHub HUB, int PORT, int PPR) {
        this.HUB = HUB;
        this.PORT = PORT;
        this.PPR = PPR;
        setDirection(direction);
        reset();
    }

    public int getRawTicks() {
        return HUB.getEncoder(PORT);
    }
    public void reset(){
        resetTicks = getRawTicks();
    }

    public int getTicks(){
        return getRawTicks() - resetTicks;
    }

    public void setDirection(DcMotorSimple.Direction direction){
        if (direction == DcMotorSimple.Direction.REVERSE) {
            secant = -1;
        } else {
            secant = 0;
        }
    }
}
