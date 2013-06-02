import javax.swing.*;

/** A window that lets the user specify a new assignment's properties,
 * including its name, totals for each category, and weightings
 */
public class AssignmentCreator extends JDialog {
  private Course course;

  private JLabel nameLabel; // Instructs user to enter assignment name
  private JTextField nameField; // Field for assignment name entry

  private JLabel[4] categoryLabels; // Labels that specify mark category names

  private JPanel totalPanel;  // Panel that contains fields for entry of totals
  private JTextField[4] totalFields;  // Text fields for category totals

  private JPanel weightingPanel;  // Panel that contains fields for weightings
  private JTextField[4] weightingFields;  // Text fields for category weightings

  private JPanel buttonPanel;  // Contains buttons
  private JButton okButton;
  private JButton cancelButton;

  private JPanel contentPane;  // Main panel for this window

  // Event handlers for ok & cancel buttons
  private AssignmentCreatorAcceptController okController;
  private AssignmentCreatorCancelController cancelController;

  /** Creates an AssignmentCreator with the given Course to add an assignment 
   * to. Shows the creator window and disables the main window until the user
   * has created a course or chosen to cancel the operation. 
   */
  public AssignmentCreator(Course course, JFrame mainWindow) {
    super(mainWindow, "Create Assignment", true);  // Creates a modal dialog 
                                                   // that disables mainWindow
    this.initUI();
    this.registerControllers();
  }

  /** Initializes UI components and sets up layout
   */
  private void initUI() {
    this.contentPane = new JPanel();
    this.setContentPane(this.contentPane);
  }

  /** Registers controllers for buttons 
   */
  private void registerControllers() {
  }
} 
