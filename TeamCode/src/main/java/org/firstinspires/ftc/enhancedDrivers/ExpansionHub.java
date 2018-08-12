package org.firstinspires.ftc.enhancedDrivers;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.lynx.LynxNackException;
import com.qualcomm.hardware.lynx.LynxUsbDevice;
import com.qualcomm.hardware.lynx.commands.core.LynxGetBulkInputDataCommand;
import com.qualcomm.hardware.lynx.commands.core.LynxGetBulkInputDataResponse;
import com.qualcomm.robotcore.exception.RobotCoreException;

import org.firstinspires.ftc.teamcode.Subsystems.RobotTemplate;

public class ExpansionHub {
    private RobotTemplate robot;
    private String config;

    private LynxModule delegate = robot.hardwareMap.get(LynxModule.class, config);
    private LynxGetBulkInputDataResponse response = null;

    public ExpansionHub(RobotTemplate robot, String config) {
        this.robot = robot;
        this.config = config;
    }

    public void pull() {
        LynxGetBulkInputDataCommand command = new LynxGetBulkInputDataCommand(delegate);
        try {
            response = command.sendReceive();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (LynxNackException e) {
            e.printStackTrace();
        }
    }

    public void push() {}

    public void enablePhoneCharging(Boolean value) {
        try {
            delegate.enablePhoneCharging(value);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (LynxNackException e) {
            e.printStackTrace();
        }
    }
    public int getEncoder(int motorZ) {
        if (response != null){
            return response.getEncoder(motorZ);
        } else {
            return 0;
        }
    }
    public Boolean getDigitalInput(int digitalInputZ) {
        return response!=null && response.getDigitalInput(digitalInputZ);
    }
    public double getAnalogInput(int inputZ) {
        if (response != null){
            return response.getAnalogInput(inputZ);
        } else {
            return 0;
        }
    }
    public int getVelocity(int motorZ) {
        if (response != null){
            return response.getVelocity(motorZ);
        } else {
            return 0;
        }
    }
    public Boolean isAtTarget(int motorZ) {
        return response != null && response.isAtTarget(motorZ);
    }
    public Boolean isOverCurrent(int motorZ) {
        return response != null && response.isOverCurrent(motorZ);
    }
}
