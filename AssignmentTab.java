import javax.swing.*;

/** The 'Assignments' tab of the MainView.  Provides an interface for the user
 * to change the Course's assignments, as well as list them.
 * @author Qasim Ali 
 * Created June 1, 2013
 */
public class AssignmentTab extends JPanel {
  private JTable assignmentTable;  // Displays assignment information 
  private JScrollPane tableScroll;  // Allows user to scroll through
                                    // AssignmentTable 
  private Course course;  // Model to fetch data from

  // Buttons 
  private JButton editAssignmentButton;
  private JButton addAssignmentButton;
  private JButton removeAssignmentButton;

  private AssignmentTableModel tableModel; // Table model that assignmentTable
                                           // uses to get data from 
  // Controllers for buttons
  private AssignmentAddController addController;
  private AssignmentEditController editController;
  private AssignmentRemoveController removeController;

  public AssignmentTab(Course course) {
    this.course = course;
    this.initUI(); 
  }
} 
