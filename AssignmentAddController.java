import java.awt.event.*;
import javax.swing.*;

/** Manages the creation of an AssignmentCreator. Used within AssignmentTab to 
 * provide event handling for the 'Add assignment' button. 
 * @author Qasim Ali
 */
public class AssignmentAddController implements ActionListener {
  private Course course; // Course to pass to the AssignmentCreator
  private JFrame mainWindow; // JFrame that contains all components. Used by 
                             // AssignmentCreator to disable it.
  private AssignmentCreator creator;
  /** Create the handler with the specified Course to be passed to an 
   * AssignmentCreator.
   * @param course   the Course to use 
   * @param mainWindow  the parent window 
   */
  public AssignmentAddController(Course course, JFrame mainWindow) {
    super();
    this.course = course;
    this.mainWindow = mainWindow;
  }

  /** Make an AssignmentCreator appear, disabling mainWindow
   * @param e    the triggered event 
   */
  public void actionPerformed(ActionEvent e) {
    this.creator = new AssignmentCreator(this.course, this.mainWindow);
  }
} 
