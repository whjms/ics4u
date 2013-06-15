/** The startup class. Contains the main method.
 */
public class Startup {
	
	public static void main (String args[]) {
		StartupWindow sw = new StartupWindow();
    Course course = null;  // Course to pass to MainWindow
    
    // Wait until the StartupWindow has a Course loaded/created. Ugly, but not
    // enough time to learn about the Swing event queue
    while(sw.getCourse() == null) {
      try {
        Thread.sleep(1);
      }
      // If Startup can't sleep, then something must be very wrong with the
      // environment - exit
      catch(InterruptedException e) {
        System.out.println("Critical error: InterruptedException in Startup");
        e.printStackTrace();
        System.exit(0);
      }
    }
    
    course = sw.getCourse();  // Get the course from StartupWindow
    sw.dispose();  // Close the startup window
    
    MainWindow mw = new MainWindow(course);
    course.setView(mw);
	}
}

