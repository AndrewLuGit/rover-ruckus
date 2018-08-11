package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.I2cDeviceSynchImplOnSimple;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchSimple;

public class BetterI2cDeviceSynchImpOnSimple extends I2cDeviceSynchImplOnSimple {
    public BetterI2cDeviceSynchImpOnSimple(I2cDeviceSynchSimple simple, boolean isSimpleOwned) {
        super(simple, isSimpleOwned);
    }

    @Override
    public void setReadWindow(ReadWindow window) {
        //do nothing
    }
}
