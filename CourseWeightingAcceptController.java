import javax.swing.*;
import java.awt.event.*;

/** Event handler for the 'OK' button on CourseWeightingEditor. Validates
 * user input, then passes the new weightings to the course.
 */

public class CourseWeightingAcceptController implements ActionListener {
	
  private Course course;
  private JTextField[] fields;
  private CourseWeightingEditor editor;
  
  /** Create this controller.
   * @param course    the course to send the new values to
   * @param fields    the fields to read weightings from
   * @param editor    the editor that 'owns' this controller
   */
	public CourseWeightingAcceptController(Course course, JTextField[] fields, 
          CourseWeightingEditor editor) {
    this.course = course;
    this.fields = fields;
    this.editor = editor;
  }
  
  public void ActionPerformed(ActionEvent e) {
  }
}

