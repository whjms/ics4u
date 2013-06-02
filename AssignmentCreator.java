import javax.swing.*;
import java.awt.*;

/** A window that lets the user specify a new assignment's properties,
 * including its name, totals for each category, and weightings
 */
public class AssignmentCreator extends JDialog {
  private Course course;

  private JLabel nameLabel; // Instructs user to enter assignment name
  private JTextField nameField; // Field for assignment name entry

  private JPanel mainPanel;  // Contains labels and entry fields
  private JLabel[] categoryLabels; // Labels that specify mark category names
  private JTextField[] totalFields;  // Text fields for category totals
  private JTextField[] weightingFields;  // Text fields for category weightings
  private JLabel totalLabel;  // Heading for total fields
  private JLabel weightingLabel;  // Heading for weighting fields

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
    this.layoutUI();
    this.registerControllers();
  }

  /** Initializes UI components
   */
  private void initUI() {
    this.contentPane = new JPanel();
    this.setContentPane(this.contentPane);
    this.contentPane.setLayout(new BoxLayout(this.contentPane,
            BoxLayout.Y_AXIS));

    this.mainPanel = new JPanel();
    this.mainPanel.setLayout(new GridLayout(3, 4));

    // Initialize labels
    this.categoryLabels = new JLabel[4];
    this.categoryLabels[Course.COMMUNICATION] = new JLabel("C/O:");
    this.categoryLabels[Course.APPLICATION] = new JLabel("AP:");
    this.categoryLabels[Course.KNOWLEDGE] = new JLabel("K/U:");
    this.categoryLabels[Course.THINKING] = new JLabel("T/I:");

    // Initialize text fields 
    for(int i = 0; i < 3; i++) {
      this.totalFields[i] = new JTextField();
      this.weightingFields[i] = new JTextField();
    }

    // Initialize buttons 
    this.okButton = new JButton("OK");
    this.cancelButton = new JButton("Cancel");

    // Initialize labels 
    this.totalLabel = new JLabel("Totals");
    this.weightingLabel = new JLabel("Weightings");

    this.buttonPanel = new JPanel();
  }

  /** Manage laying out components for this window 
   */
  private void layoutUI() {
    this.contentPane.setLayout(new BoxLayout(this.contentPane,
            BoxLayout.Y_AXIS));
    this.mainPanel.setLayout(new GridLayout(3, 4));
  }

  /** Registers controllers for buttons 
   */
  private void registerControllers() {
  }
} 
