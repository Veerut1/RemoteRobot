Remote Robot
This is simple library consists of Java Robot functionalities through handling the remote machine and consists of running external programs by invoking the Runtime class's exec() method.

Using RemoteRobot
* Export poroject as JAR
* Start RemoteRobot server on a remote machine

java -jar RemoteRobot.jar (Default port 4445) OR java -jar RemoteRobot.jar 8888
Configure RemoteRobot in project
* Add RemoteRobot jar in the project
* Create RemoteRobot object
RemoteRobot robot = new RemoteRobot("localhost",4445);

Some of the example methods are mentioned below...
Screenshot Capturing
Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); robot.getRobotImpl().createScreenCapture(capture,"D://My Projects");
Invoking external events
robot.getRobotImpl().exec("notepad");
