/**
 * 
 */
package com.remote.robot;
import java.rmi.Naming;

import com.remote.serverhandler.RobotImpl;


/**
 * @author Virupaksha Tippa
 *	30-Sep-2019
 */
public class RemoteRobot  {

	
	private String host;
	private int port;
	private RobotImpl robotImpl;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public RobotImpl getRobotImpl() {
		return robotImpl;
	}
	public void setRobotImpl(RobotImpl robotImpl) {
		this.robotImpl = robotImpl;
	}
	
	public RemoteRobot() {
		super();
	}
	public RemoteRobot(String host, int port) {
		super();
		this.host = host;
		this.port = port;
		
		try{ 
			this.robotImpl =(RobotImpl)Naming.lookup("rmi://"+host+":"+port+"/rmtRb");
		  }catch(Exception e){e.printStackTrace();}
		
		
	}
	
}
