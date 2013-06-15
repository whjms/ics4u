import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

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
  
  public void actionPerformed(ActionEvent e) {
    try {
      // Create a list of weighting values
      int[] weights = new int[4];
      int sum = 0;  // used to make sure totals are valid
      
      for(int i = 0; i < 4; i++) {
        weights[i] = Integer.parseInt(fields[i].getText());
        sum += weights[i]
        
        // Make sure weightings are >= 0
        if(weights[i] < 0)
          throw new NumberFieldException(weights[i], "course weightings");
      }
      
      // Totals don't add up to 100, so something's off
      if(sum != 100)
        throw new IOException();  // This should be a custom exception, but use
                                  // this for testing
      
      // Send the values to the course
      this.course.setCourseWeightings(weights);
      
      // Close the editor
      this.editor.dispose();
      
    }
    catch(NumberFormatException ex) {
      // Alert the user if a value cannot be parsed
      JOptionPane.showMessageDialog(this.editor, "Error parsing course "
              + "weightings. Ensure all values are whole numbers.", 
              "Error editing course", JOptionPane.ERROR_MESSAGE);
    }
    catch(NumberFieldException ex) {
      JOptionPane.showMessageDialog(this.editor, ex.toString(),
              "Error editing course", JOptionPane.ERROR_MESSAGE);
    }
    // ex's type should be changed to a custom exception later on: sum != 100
    catch(IOException ex) {
      JOptionPane.showMessageDialog(this.editor, "Error editing course: "
              + "weightings must add up to 100.", "Error editing course",
              JOptionPane.ERROR_MESSAGE);
    }
  }
}

