/**
 * 
 */
package com.remote.serverhandler;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Virupaksha Tippa
 *	30-Sep-2019
 */
public interface RobotImpl extends Remote{

	 public boolean createScreenCapture(Rectangle screenRect,String path) throws RemoteException;
	 public void delay(int ms) throws RemoteException;
	 public int getAutoDelay() throws RemoteException;
	 public void keyPress(int keycode) throws RemoteException;
	 public void keyRelease(int keycode) throws RemoteException;
	 public void mouseMove(int x, int y) throws RemoteException;
	 public void mousePress(int buttons) throws RemoteException;
	 public void mouseRelease(int buttons) throws RemoteException;
	 public void mouseWheel(int wheelAmt) throws RemoteException;
	 public void setAutoDelay(int ms) throws RemoteException;
	 public void setAutoWaitForIdle(boolean isOn) throws RemoteException;
	 public void exec(String command) throws IOException;
	 public void exec(String[] cmdarray) throws IOException;
	 public void exec(String command, String[] envp) throws IOException;
	 public void exec(String[] cmdarray, String[] envp) throws IOException;
	 public void exec(String command, String[] envp, File dir) throws IOException;
	 public void exec(String[] cmdarray, String[] envp, File dir) throws IOException;
	
	
}
