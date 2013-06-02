import java.awt.event.*;

/** Manages the creation of an AssignmentCreator. Used within AssignmentTab to 
 * provide event handling for the 'Add assignment' button. 
 */
public class AssignmentAddController implements ActionListener {
  private Course course; // Course to pass to the AssignmentCreator

  /** Create the handler with the specified Course to be passed to an 
   * AssignmentCreator.
   * @param course   the Course to use 
   */
  public AssignmentAddController(Course course) {
    super();
    this.course = course;
  }

  public void actionPerformed(ActionEvent e) {
    AssignmentCreator creator = new AssignmentCreator(this.course);
  }
} 
