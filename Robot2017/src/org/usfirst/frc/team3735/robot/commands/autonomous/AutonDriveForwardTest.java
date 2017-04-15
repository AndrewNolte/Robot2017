package org.usfirst.frc.team3735.robot.commands.autonomous;

import org.usfirst.frc.team3735.robot.commands.drive.DriveBrake;
import org.usfirst.frc.team3735.robot.commands.drive.ExpDrive;
import org.usfirst.frc.team3735.robot.commands.drive.movedistance.DriveMoveDistanceExpNavx;
import org.usfirst.frc.team3735.robot.commands.drive.movedistance.DriveMoveDistanceNavx;
import org.usfirst.frc.team3735.robot.commands.drive.movedistance.DriveMoveDistancePID;
import org.usfirst.frc.team3735.robot.commands.drive.movedistance.DriveMoveDistancePIDBroken;
import org.usfirst.frc.team3735.robot.commands.drive.movedistance.DriveMoveDistanceVisionExp;
import org.usfirst.frc.team3735.robot.commands.gearintake.GearIntakeDropOff;
import org.usfirst.frc.team3735.robot.subsystems.Vision.Pipes;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveForwardTest extends CommandGroup {

    public AutonDriveForwardTest(){
    	/* Let Move FWD Only */
    	/* All the Timing Needs Adjustment     |    */ 
    	/*                                    This */
    	/*                                     |   */
    	//112 + 20
    	//addSequential(new DriveMoveDistanceInches(86),2.6); /* Straight To Pin*/
    	//addSequential(new DriveMoveDistanceNavx(86),2.6); /* Straight To Pin*/
    	addSequential(new DriveMoveDistanceVisionExp(Pipes.Peg,.7,75));
    	//addSequential(new DriveMoveDistanceExpNavx(75,.7),2.6);

    	//addSequential(new DriveMoveDistance(86),2.6); /* Straight To Pin*/
    	addSequential(new DriveBrake(),.4);
    	//addSequential(new Wait(.4));
    	//addSequential(new GearIntakeDropOff(),4);
     }
}
