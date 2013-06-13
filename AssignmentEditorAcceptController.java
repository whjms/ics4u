import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Gets data from the passed AssignmentEditor, validates it, and sends it to 
 * the Course.
 * @author Qasim Ali
 */
public class AssignmentEditorAcceptController implements ActionListener {
  private Course course;
  private AssignmentEditor editor;
  private JTextField[] totals;
  private JTextField[] weightings;
  private String name;
  private JCheckBox summative;
  
  /** Creates the controller for the passed AssignmentEditor and Course.
   * @param course    the Course model to edit 
   * @param editor    the editor dialog that created this controller 
   * @param totals    array of fields containing assignment totals 
   * @param weightings    array of fields containing assignment weightings
   * @param assignmentName    the name of the assignment to edit 
   */
  public AssignmentEditorAcceptController(Course course, 
          AssignmentEditor editor, JTextField[] totals,
          JTextField[] weightings, String assignmentName, JCheckBox summative) {
    this.course = course;
    this.editor = editor;
    this.totals = totals;
    this.weightings = weightings;
    this.name = assignmentName;
    this.summative = summative;
  }

  /** Get values from all fields and pass them to the Course 
   * @param e    the triggered event 
   */
  public void actionPerformed(ActionEvent e) {
    try {
      // Create a list of new values for the weightings from the weighting fields
      double[] weightingValues = new double[4];
      for(int i = 0; i < 4; i++) {
        weightingValues[i] = Double.parseDouble(weightings[i].getText());

        // Make sure weightings are >= 0
        if(weightingValues[i] < 0) 
          throw new NumberFieldException(weightingValues[i], 
                  "category weightings");
      }
    
      // Create a list of new totals 
      int[] totalValues = new int[4];
      for(int i = 0; i < 4; i++) {
       totalValues[i] = Integer.parseInt(totals[i].getText());

       if(totalValues[i] <= 0) // Ensure values for all fields are sane 
        throw new NumberFieldException(totalValues[i], "category totals");
      }

      // Tell the Course to change the assignment's values 
      this.course.setWeightings(this.name, weightingValues);
      this.course.setTotals(this.name, totalValues);
      this.course.setAssignmentSummative(this.name, this.summative.isSelected());
    
      // Close the editor window 
      this.editor.dispose();
    }
    catch(NumberFormatException ex) {
      // One of the text fields' contents could not be parsed, so do nothing
    }
    catch(NumberFieldException ex) {
      // Let the user know what they did wrong 
      JOptionPane.showMessageDialog(this.editor, ex.toString(), 
              "Error editing assignment", JOptionPane.ERROR_MESSAGE);
    }
  }

} 
