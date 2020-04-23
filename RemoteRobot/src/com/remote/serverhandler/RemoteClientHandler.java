/**
 * 
 */
package com.remote.serverhandler;

import java.awt.AWTException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Virupaksha Tippa
 *	30-Sep-2019
 */
public class RemoteClientHandler {
	
	
public static void main(String[] port) throws RemoteException {
		
		Registry rgsty;
		RobotImpl handler = null;
		try {
			handler = new ServerHandler();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		if(port.length!=0) {
				//System.setProperty("java.rmi.server.hostname","192.168.43.232");
				rgsty = LocateRegistry.createRegistry(Integer.parseInt(port[0]));
				rgsty.rebind("rmtRb",handler);
				 System.out.println("Robot server running on port : "+port[0]);
				  
		}else {
			rgsty = LocateRegistry.createRegistry(4445);
			rgsty.rebind("rmtRb",handler);
			 System.out.println("Robot server running on port : 4445");
			
		}
	}
	
}
