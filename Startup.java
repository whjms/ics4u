/** The startup class. Contains the main method.
 */
import javax.swing.*;

public class Startup {
	
	public static void main (String args[]) {
    try {
      // Make application appear native (no difference on Linux, as Java only
      // supports GTK
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    }
    // System look and feel is always available, so these exceptions should not
    // appear, and if it does, there's nothing we can do 
    catch (UnsupportedLookAndFeelException e) { }
    catch (ClassNotFoundException e) { }
    catch (InstantiationException e) { }
    catch (IllegalAccessException e) { }
    
    // enable anti-aliased text (if the system has it enabled)
    System.setProperty("awt.useSystemAAFontSettings","on");
    System.setProperty("swing.aatext", "true");
    
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

