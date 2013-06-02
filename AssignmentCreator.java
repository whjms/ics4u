import javax.swing.*;

/** A window that lets the user specify a new assignment's properties,
 * including its name, totals for each category, and weightings
 */
public class AssignmentCreator extends JDialog {
  private Course course;

  /** Creates an AssignmentCreator with the given Course to add an assignment 
   * to. Shows the creator window and disables the main window until the user
   * has created a course or chosen to cancel the operation. 
   */
  public AssignmentCreator(Course course, JFrame mainWindow) {
    super(mainWindow, "Create Assignment", true);  // Creates a modal dialog 
                                                   // that disables mainWindow
  }

  private void initUI() {
  }

  private void registerControllers() {
  }
} 
