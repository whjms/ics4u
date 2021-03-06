import javax.swing.*;

/** The 'Assignments' tab of the MainView.  Provides an interface for the user
 * to change the Course's assignments, as well as list them.
 * @author Qasim Ali 
 */
public class AssignmentTab extends JPanel {
  private JTable table;  // Displays assignment information 
  private JScrollPane tableScroll;  // Allows user to scroll through
                                    // AssignmentTable 
  private Course course;  // Model to fetch data from
  private JFrame mainWindow; 

  // Buttons 
  private JButton editButton;
  private JButton addButton;
  private JButton removeButton;

  private AssignmentTableModel tableModel; // Table model that assignmentTable
                                           // uses to get data from 
  // Controllers for buttons
  private AssignmentAddController addController;
  private AssignmentEditController editController;
  private AssignmentRemoveController removeController;

  /** Creates an AssignmentTab with the given Course model 
   * @param course    the Course model to read data from 
   * @param mainWindow the JFrame that serves as the main window. Used by modal
   *                   dialogs so that it can be disabled while the dialog is 
   *                   open
   */
  public AssignmentTab(Course course, JFrame mainWindow) {
    super();
    this.course = course;
    this.mainWindow = mainWindow;
    this.initUI(); 
    this.registerControllers();
    this.update();
  }

  /** Initializes UI components 
   */
  private void initUI() {
    this.tableModel = new AssignmentTableModel(this.course);
    this.table = new JTable(this.tableModel);
    this.table.setAutoCreateRowSorter(true);

    this.tableScroll = new JScrollPane(this.table);
    this.table.setFillsViewportHeight(true);  // Makes the table fill its 
                                              // parent container tableScroll
    this.editButton = new JButton("Edit assignment...");
    this.addButton = new JButton("Add assignment...");
    this.removeButton = new JButton("Delete assignment");

    JPanel buttonPanel = new JPanel();  // Contains buttons to add/remove/edit 
                                        // assignments, all aligned on one 
                                        // row
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    buttonPanel.add(this.editButton);
    buttonPanel.add(this.removeButton);
    buttonPanel.add(this.addButton);

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(this.tableScroll);
    this.add(buttonPanel);    
  }

  /** Creates and registers controllers with assignment add/edit/remove buttons 
   */
  private void registerControllers() {
    // Initialize controllers
    this.removeController = new AssignmentRemoveController(this.course, this.table,
            this.tableModel);
    this.addController = new AssignmentAddController(this.course, this.mainWindow);
    this.editController = new AssignmentEditController(this.course, this.table, this.tableModel, this.mainWindow);
    
    // Link controllers
    this.addButton.addActionListener(this.addController);
    this.editButton.addActionListener(this.editController);
    this.removeButton.addActionListener(this.removeController);
  }

  /** Updates components to reflect the Course's data 
   */
  public void update() {
    this.tableModel.update();
  }
} 
