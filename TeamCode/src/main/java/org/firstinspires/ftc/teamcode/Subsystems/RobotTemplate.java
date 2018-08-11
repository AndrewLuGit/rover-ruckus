package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.enhancedDrivers.ExpansionHub;

public abstract class RobotTemplate {
    OpMode opMode;
    String[] revHubNames;
    ExpansionHub[] revHubs;
    public HardwareMap hardwareMap;

    public RobotTemplate(OpMode opMode, String[] revHubNames) {
        this.opMode = opMode;
        this.revHubNames = revHubNames;
        this.hardwareMap = this.opMode.hardwareMap;

        for (int i = 0; i < this.revHubNames.length; i ++) {
            revHubs[i] = new ExpansionHub(this, this.revHubNames[i]);
        }
    }

    public ExpansionHub getHub(int index) {
        return revHubs[index];
    }

    public abstract void onStart();
    public abstract void autoPostInit();
}
