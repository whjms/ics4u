import java.awt.event.*;
import javax.swing.*;

/** Event listener that automatically saves the Course when a MainWindow closes
 * @author Qasim Ali
 */
public class MainWindowExitAdapter extends WindowAdapter {
  private Course course;   // Course to save
  
  /** Create this adapter
   * @param course    the Course to save
   */
  public MainWindowExitAdapter(Course course) {
    this.course = course;
  }
  
  /** Save the course when the associated frame closes, getting the target file
   * name from the user in the process
   * @param e    the triggered event
   */
  public void windowClosing(WindowEvent e) {    
    // Alert the user that they should save, disabling the main window in the
    // process
    JOptionPane.showMessageDialog((MainWindow)e.getSource(), "Please choose a file to save"
            + " this course's data to.", "Save",
            JOptionPane.INFORMATION_MESSAGE);
            
    JFileChooser fc = new JFileChooser();
    int result = fc.showSaveDialog((MainWindow)e.getSource());
    
    // Will not save if the user hits 'cancel'
    if(result == JFileChooser.APPROVE_OPTION)
      FileManager.saveCourse(fc.getSelectedFile().getPath(), this.course);
    
    // Quit
    System.exit(0);
  }
}
