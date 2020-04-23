/**
 * 
 */
package com.remote.serverhandler;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * @author Virupaksha Tippa
 *	30-Sep-2019
 */
public class ServerHandler extends UnicastRemoteObject implements RobotImpl,Serializable {

	/**
	 * @throws RemoteException
	 */

	private static final long serialVersionUID = 4504335566538035171L;
	private Robot robot;
	

	public ServerHandler() throws RemoteException, AWTException {
		super();
		this.robot = new Robot();
	}

	@Override
	public boolean createScreenCapture(Rectangle screenRect,String path) {
		
		try {
			BufferedImage  img = robot.createScreenCapture(screenRect);
			String pattern1 = "dd-M-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern1);
			String date = simpleDateFormat.format(new Date());
			String pattern2 = "hh-mm-ss";
			simpleDateFormat = new SimpleDateFormat(pattern2);
			String time = simpleDateFormat.format(new Date());
			System.out.println(date);
			String filePath = path+"//"+date+"_"+time+".png";
			ImageIO.write(img, "png", new File(filePath)); 
            System.out.println("Screenshot saved in "+filePath);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private	String separatorsToSystem(String res) {
	    if (res==null) return null;
	    if (File.separatorChar=='\\') {
	        // From Windows to Linux/Mac
	        return res.replace('/', File.separatorChar);
	    } else {
	        // From Linux/Mac to Windows
	        return res.replace('\\', File.separatorChar);
	    }
	}

	@Override
	public void delay(int ms) throws RemoteException {
		robot.delay(ms);
	}

	@Override
	public int getAutoDelay() throws RemoteException {
		return robot.getAutoDelay();
	}

	@Override
	public void keyPress(int keycode) throws RemoteException {
		robot.keyPress(keycode);
	}

	@Override
	public void keyRelease(int keycode) throws RemoteException {
		robot.keyRelease(keycode);
	}

	@Override
	public void mouseMove(int x, int y) throws RemoteException {
		robot.mouseMove(x, y);
	}

	@Override
	public void mousePress(int buttons) throws RemoteException {
		robot.mousePress(buttons);
	}

	@Override
	public void mouseRelease(int buttons) throws RemoteException {
		robot.mouseRelease(buttons);
	}

	@Override
	public void mouseWheel(int wheelAmt) throws RemoteException {
		robot.mouseWheel(wheelAmt);
	}

	@Override
	public void setAutoDelay(int ms) throws RemoteException {
		robot.setAutoDelay(ms);
	}

	@Override
	public void setAutoWaitForIdle(boolean isOn) throws RemoteException {
		robot.setAutoWaitForIdle(isOn);
	}

	@Override
	public  void exec(String command) throws IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec(command);
	}
	
	@Override
	public void exec(String[] cmdarray) throws IOException {
		Runtime.getRuntime().exec(cmdarray);
	}

	@Override
	public void exec(String command, String[] envp) throws IOException {
		 Runtime.getRuntime().exec(command, envp);
	}

	@Override
	public void exec(String[] cmdarray, String[] envp) throws IOException {
		 Runtime.getRuntime().exec(cmdarray, envp);
	}

	@Override
	public void exec(String command, String[] envp, File dir) throws IOException {
		 Runtime.getRuntime().exec(command, envp, dir);
	}

	@Override
	public void exec(String[] cmdarray, String[] envp, File dir) throws IOException {
		Runtime.getRuntime().exec(cmdarray, envp, dir);
	}

}
