/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;


/**
 *
 * @author Developer
 */
public class TheCompressor extends Subsystem {

    private Compressor compressor;
    
    public TheCompressor() {
        super();
        compressor = new Compressor(RobotMap.COMPRESSOR_GAUGE, RobotMap.COMPRESSOR_PORT);
        compressor.start();
    }

    protected void initDefaultCommand() {
    }

}
