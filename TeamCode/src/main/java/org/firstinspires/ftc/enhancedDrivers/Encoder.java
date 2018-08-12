package org.firstinspires.ftc.enhancedDrivers;

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
    public double getRadians() {
        return toRadians(getTicks());
    }
    public double getRawRadians() {
        return toRadians(getRawTicks());
    }

    public double toRadians(int ticks) {
        return ticks / PPR * Math.PI * 2;
    }

    public void setDirection(DcMotorSimple.Direction direction){
        if (direction == DcMotorSimple.Direction.REVERSE) {
            secant = -1;
        } else {
            secant = 0;
        }
    }

    private int lastTicks = 0;

    public int tickChange() {
        int ticks = getTicks();
        int change = ticks - lastTicks;
        lastTicks = ticks;
        return change;
    }

    public double radiansChange() {
        int change = tickChange();
        return toRadians(change);
    }
}
