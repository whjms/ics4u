import javax.swing.*;
import java.awt.*;

/** Gets data from the passed AssignmentEditor, validates it, and sends it to 
 * the Course.
 */
public class AssignmentEditorAcceptController {
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
    // Create a list of new values for the weightings from the weighting fields
    double[] weightingValues = new double[4];
    for(int i = 0; i < 3; i++) 
      weightingValues[i] = Double.parseDouble(weightings[i].getText());

    // Create a list of new totals 
    int[] totalValues = new int[4];
    for(int i = 0; i < 3; i++)
      totalValues[i] = Integer.parseInt(totals[i].getText());

    // Tell the Course to change the assignment's values 
    this.course.setWeightings(weightingValues, this.name);
    this.course.setTotals(this.totalValues, this.name);
    this.course.setAssignmentSummative(this.summative.isSelected(), this.name);
    
    // Close the editor window 
    this.editor.close();
  }

} 
