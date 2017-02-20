package org.usfirst.frc.team3735.robot;

import org.usfirst.frc.team3735.robot.util.DriveOI;
import org.usfirst.frc.team3735.robot.util.JoystickPOVButton;
import org.usfirst.frc.team3735.robot.commands.ballintake.BallIntakeRollerIn;
import org.usfirst.frc.team3735.robot.commands.ballintake.BallIntakeRollerOff;
import org.usfirst.frc.team3735.robot.commands.gearintake.GearIntakeDropOff;
import org.usfirst.frc.team3735.robot.commands.gearintake.GearIntakeFeeding;
import org.usfirst.frc.team3735.robot.commands.gearintake.GearIntakeToggleOpenClose;
import org.usfirst.frc.team3735.robot.commands.scaler.ScalerUp;
import org.usfirst.frc.team3735.robot.commands.shooter.ShooterOff;
import org.usfirst.frc.team3735.robot.commands.shooter.ShooterOn;
import org.usfirst.frc.team3735.robot.commands.shooter.ShooterSwitchEnabled;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GTAOI implements DriveOI{
	
	Joystick joy;
	Joystick cojoy;
	
	public GTAOI(){
		
		
		//joystick port mapping
		joy = new Joystick(0);
		cojoy = new Joystick(1);	
		
		//Button Mapping for driver joy-stick
		//currently mapped for next level shit
		Button a = new JoystickButton(joy,1);
		Button b = new JoystickButton(joy,2);
		Button x = new JoystickButton(joy,3);
		Button y = new JoystickButton(joy,4);
		Button lb = new JoystickButton(joy,5);
		Button rb = new JoystickButton(joy,6);
		Button back = new JoystickButton(joy,7);
		Button start = new JoystickButton(joy,8);
		Button ls = new JoystickButton(joy,9);
		Button rs = new JoystickButton(joy,10);
		
		Button pov0 = new JoystickPOVButton(joy,0);
		Button pov45 = new JoystickPOVButton(joy,45);
		Button pov90 = new JoystickPOVButton(joy,90);
		Button pov135 = new JoystickPOVButton(joy,135);
		Button pov180 = new JoystickPOVButton(joy,180);
		Button pov225 = new JoystickPOVButton(joy,225);
		Button pov270 = new JoystickPOVButton(joy,270);
		Button pov315 = new JoystickPOVButton(joy,315);

		
		//Button Mapping for codriver joy-stick
		//currently mapped for normal mode
		Button cX = new JoystickButton(cojoy,1);
		Button cA = new JoystickButton(cojoy,2);
		Button cB = new JoystickButton(cojoy,3);
		Button cY = new JoystickButton(cojoy,4);
		Button cLB = new JoystickButton(cojoy,5);
		Button cRB = new JoystickButton(cojoy,6);
		Button cLT = new JoystickButton(cojoy,7);
		Button cRT = new JoystickButton(cojoy,8);
		Button cBack = new JoystickButton(cojoy,9);
		Button cStart = new JoystickButton(cojoy,10);
		Button cLS = new JoystickButton(cojoy,11);
		Button cRS = new JoystickButton(cojoy,12);
		
		Button cpov0 = new JoystickPOVButton(cojoy,0);
		Button cpov45 = new JoystickPOVButton(cojoy,45);
		Button cpov90 = new JoystickPOVButton(cojoy,90);
		Button cpov135 = new JoystickPOVButton(cojoy,135);
		Button cpov180 = new JoystickPOVButton(cojoy,180);
		Button cpov225 = new JoystickPOVButton(cojoy,225);
		Button cpov270 = new JoystickPOVButton(cojoy,270);
		Button cpov315 = new JoystickPOVButton(cojoy,315);
		
		b.whenPressed(new BallIntakeRollerIn());
		b.whenReleased(new BallIntakeRollerOff());
		
		rb.toggleWhenPressed(new GearIntakeToggleOpenClose());
		//rt.whileHeld(new GearIntakeFeeding());
		//lt.whenPressed(new GearIntakeDropOff());
		
		a.whileHeld(new ScalerUp());
		
		y.whenPressed(new ShooterSwitchEnabled());
		
		
	}
	
	
	
	public double getMainLeftX(){
		return joy.getX();
	}
	public double getMainLeftY(){
		return joy.getY();
	}
//	public double getMainRightX(){
//		return joy.getTwist();
//	}
//	public double getMainRightY(){
//		return joy.getThrottle();
//	}
	public double getMainRightTrigger(){
		return joy.getThrottle();
	}
	public double getMainLeftTrigger(){
		return joy.getZ();
	}
	
//	public double getCoLeftX(){
//		return joy.getX();
//	}
//	public double getCoLeftY(){
//		return joy.getY();
//	}
//	public double getCoRightX(){
//		return joy.getTwist();
//	}
//	public double getCoRightY(){
//		return joy.getThrottle();
//	}
	public double getCoLeftTrigger(){
		return cojoy.getZ();
	}
	public double getCoRightTrigger(){
		return cojoy.getThrottle();
	}
	

	@Override
	public double getDriveMove() {
		return getMainRightTrigger() - getMainLeftTrigger();
	}
	@Override
	public double getDriveTurn() {
		return getMainLeftX() * -1;
	}
	

	public void log() {
		SmartDashboard.putNumber("Get X:", joy.getX());
		SmartDashboard.putNumber("Get Y:", joy.getY());
		SmartDashboard.putNumber("Get Twist:", joy.getTwist());
		SmartDashboard.putNumber("Get Throttle:", joy.getThrottle());
		SmartDashboard.putNumber("Get Dicection Degrees:", joy.getDirectionDegrees());
		SmartDashboard.putNumber("Get Magnitutde:", joy.getMagnitude());
		SmartDashboard.putNumber("Get Z:", joy.getZ());
		SmartDashboard.putBoolean("Get Top:", joy.getTop());
		SmartDashboard.putNumber("Get POV:", joy.getPOV());
		SmartDashboard.putNumber("Get Count:", joy.getAxisCount());
		//SmartDashboard.putData("values ", AxisType.values());
		
	}
	
}