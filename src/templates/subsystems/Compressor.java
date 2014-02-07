/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class Compressor extends Subsystem {

    private Relay compressor;
    
    public Compressor() {
        super();
        compressor = new Relay(RobotMap.COMPRESSOR_PORT);
        compressor.set(Relay.Value.kOn);
    }

    protected void initDefaultCommand() {
    }

}
