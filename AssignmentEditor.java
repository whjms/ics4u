import javax.swing.*;
import java.awt.*;

/** A modal dialog that provides the user methods to edit an assignment's 
 * totals and weightings
 */
public class AssignmentEditor extends JDialog {
  private Course course;

  private String name;  // Assignment name

  private JPanel contentPane;   // This window's content pane 
  private JPanel mainPanel;     // Panel that contains labels and fields for 
                                // data entry
  private JLabel[] categories;  // Labels used to identify each category 
  private JTextField[] weightings;  // Fields for user to enter weightings 
  private JTextField[] totals;   // Fields for user to enter category totals 

  private JLabel totalLabel;    // Heading for totals section 
  private JLabel weightingLabel;  // Heading for weightings section
  private JPanel buttonPanel;   // Container for buttons 
  private JButton okButton;
  private JButton cancelButton;

  private JCheckBox summative;  // Check whether or not the assignment is to be
                                // treated as summative
  
  /** Shows the editor window for the assignment with the given name
   * @param course    the Course model to use
   * @param name      the name of the assignment to edit 
   * @param mainWindow    the application's main window 
   */
  public AssignmentEditor(Course course, String name, JFrame mainWindow) {
    super(mainWindow, "Editing assignment \'" + name + "\'", true);
    this.course = course;
    this.name = name;

    this.initUI();
    this.layoutUI();
    this.registerControllers();
  }

  /** Initialize UI components
   */
  private void initUI() {
    this.contentPane = new JPanel();
    this.setContentPane(this.contentPane);

    this.mainPanel = new JPanel();
    
    // Arrays used to populate text fields
    int[] assignmentTotals = this.course.getTotals(this.name);
    double[] assignmentWeightings = this.course.getWeightings(this.name);

    // Initialize text fields with the assignment's current values
    this.totals[Course.C] = new JTextField(Integer.toString(
            assignmentTotals[Course.C]);
    this.totals[Course.T] = new JTextField(Integer.toString(
            assignmentTotals[Course.T]);
    this.totals[Course.A] = new JTextField(Integer.toString(
            assignmentTotals[Course.A]);
    this.totals[Course.K] = new JTextField(Integer.toString(
            assignmentTotals[Course.K]);
    this.weightings[Course.C] = new JTextField(Double.toString(
            assignmentWeightings[Course.C]);
    this.weightings[Course.T] = new JTextField(Double.toString(
            assignmentWeightings[Course.T]);
    this.weightings[Course.A] = new JTextField(Double.toString(
            assignmentWeightings[Course.A]);
    this.weightings[Course.K] = new JTextField(Double.toString(
            assignmentWeightings[Course.K]);

    // Initialize labels 
    this.categories[Course.C] = new JLabel("C/O:");
    this.categories[Course.A] = new JLabel("AP:");
    this.categories[Course.K] = new JLabel("K/U:");
    this.categories[Course.T] = new JLabel("T/I:");
    this.totalLabel = new JLabel("Totals");
    this.weightingLabel = new JLabel("Weightings");

    // Initialize buttons 
    this.okButton = new JButton("OK");
    this.cancelButton = new JButton("Cancel");
                                               
    this.summative = new JCheckBox("Summative", true);
  }

  /** Sets up the layout for UI components 
   */
  private void layoutUI() {
   this.contentPane.setLayout(new BoxLayout(this.contentPane,
          BoxLayout.Y_AXIS));
   this.mainPanel.setLayout(new GridLayout(3, 5));
   this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, 
          BoxLayout.X_AXIS));
   
   // Add first row of components to mainPanel 
   this.mainPanel.add(new JPanel());  // Empty panel for spacing 
   this.mainPanel.add(this.totalLabel);
   this.mainPanel.add(this.weightingLabel);
   
   // Add second row
   this.mainPanel.add(this.categories[Course.T]);
   this.mainPanel.add(this.totals[Course.T]);
   this.mainPanel.add(this.weightings[Course.T]);

   // Add third row
   this.mainPanel.add(this.categories[Course.K]);
   this.mainPanel.add(this.totals[Course.K]);
   this.mainPanel.add(this.weightings[Course.K]);

    // Add fourth row
   this.mainPanel.add(this.categories[Course.A]);
   this.mainPanel.add(this.totals[Course.A]);
   this.mainPanel.add(this.weightings[Course.A]);

   // Add fifth row
   this.mainPanel.add(this.categories[Course.C]);
   this.mainPanel.add(this.totals[Course.C]);
   this.mainPanel.add(this.weightings[Course.C]);

   // layout buttons 
   this.buttonPanel.add(this.okButton);
   this.buttonPanel.add(this.cancelButton);

   // Add panels to content pane 
   this.contentPane.add(this.mainPanel);
   this.contentPane.add(this.summative);
   this.contentPane.add(this.buttonPanel);
  }

  /** Registers controllers for buttons 
   */
  private void registerControllers() { 
    JDialog parentDialog = this;
    CancelController cancelController = new CancelController(parentDialog);
    this.cancelButton.addActionListener(cancelController);

    AssignmentEditorAcceptController acceptController = 
            AssignmentEditorAcceptController(this.course, this, this.totals,
            this.weightings, this.name, this.summative);
  }
} 
