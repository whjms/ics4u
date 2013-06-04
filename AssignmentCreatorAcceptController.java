import javax.swing.*;
import java.awt.*;

/** Sends data for a new assignment to the specified Course by reading date
 * from the given JTextFields. Closes the AssignmentCreator once the assignment 
 * is created.
 */
public class AssignmentCreatorAcceptController {
  private Course course;
  private AssignmentCreator creator;
  private JTextField[] totals;
  private JTextField[] weightings;
  private JTextField nameField;

  /** Create the controller with the passed course, creator, and text fields.
   * @param course    the course model 
   * @param creator   the parent AssignmentCreator 
   * @param totals    array of textfields used to contain assignment totals 
   * @param weightings  array of textfields used to contain weightings 
   * @param nameField  text field that contains assignment name 
   */
  public AssignmentCreatorAcceptController(Course course,
          AssignmentCreator creator, JTextField[] totals,
          JTextField[]  weightings, JTextField nameField) {
    this.course = course;
    this.creator = creator;
    this.totals = totals;
    this.weightings = weightings;
    this.nameField = nameField;
  }

  /** Add a course with the user-entered data from the AssignmentCreator, if 
   * it doesn't already exist
   * @param e    the triggered event 
   */
  public void actionPerformed(ActionEvent e) {
    // Check if the assignment already exists
    if(this.course.assignmentExists(this.nameField.getText())) {
      // Alert the user if the assignment already exists 
      JOptionPane.showMessageDialog(this.creator,
              "An assignment with the specified name already exists.", 
              "Error adding course",
              JOptionPane.INFORMATION_MESSAGE);
    }
    // The assignment does not exist, so add it to the Course
    else
    {
      // Parse the values for totals 
      int[] totalVals = new int[4];
      totalVals[Course.C] = Integer.parseInt(this.totals[Course.C].getText());
      totalVals[Course.T] = Integer.parseInt(this.totals[Course.T].getText());
      totalVals[Course.K] = Integer.parseInt(this.totals[Course.K].getText());
      totalVals[Course.A] = Integer.parseInt(this.totals[Course.A].getText());

      // Parse the values for weightings 
      double[] weightVals = new double[4];
      weightVals[Course.C] = Double.parseDouble(this.weightings[Course.C].getText());
      weightVals[Course.T] = Double.parseDouble(this.weightings[Course.T].getText());
      weightVals[Course.K] = Double.parseDouble(this.weightings[Course.K].getText());
      weightVals[Course.A] = Double.parseDouble(this.weightings[Course.A].getText());

      this.course.createAssignment(this.nameField.getText(), 
              totalVals[Course.K], totalVals[Course.A], totalVals[Course.T],
              totalVals[Course.C]);
      this.course.setWeightings(weightVals, this.nameField.getText());

      // Close the creator window
      this.creator.close();
    }
  }
} 
