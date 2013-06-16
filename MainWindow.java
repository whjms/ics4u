import javax.swing.*;

/** The main application window. Contains all other components.
 * @author Qasim Ali
 */
public class MainWindow extends JFrame{
  private Course course;
  private CourseInfoView info;
  private AssignmentTab atab;
  private StudentTab stab;
  private JPanel contentPane;
  
  /** Create the application with the specified Course
   * @param course    the Course to get data from
   */
  public MainWindow(Course course) { 
    super("GRADEschool 2K13 - " + course.getCode());
    this.course = course;
    this.initUI();
    // Make file save popup appear when window closes
    this.addWindowListener(new MainWindowExitAdapter(this.course));
  }

  /** Initialize and layout UI components
   */
  private void initUI() {
    this.contentPane = new JPanel();
    this.contentPane.setLayout(new BoxLayout(this.contentPane,
                                             BoxLayout.Y_AXIS));
    this.setContentPane(this.contentPane);
    this.info = new CourseInfoView(this.course, this);
    this.atab = new AssignmentTab(this.course, this);
    this.stab = new StudentTab(this.course, this);
    
    // Load images from images subdirectory - use getClass().getResource() to
    // load files from images directory in the packaged JAR file
    ImageIcon studentIcon = new ImageIcon(this.getClass().getResource(
            "images/students.png"));
    ImageIcon assignmentIcon = new ImageIcon(this.getClass().getResource(
            "images/assignments.png"));
    
    // Create and lay out tabs, adding tooltips and icons
    JTabbedPane tab = new JTabbedPane();
    tab.addTab("Assignments", assignmentIcon, this.atab, "View all assignments");
    tab.addTab("Students", studentIcon, this.stab, "View information for all students");
    
    this.contentPane.add(this.info);
    this.contentPane.add(tab);
    this.pack();
    this.setVisible(true);
  }
  
  /** Update all other components
   */
  public void update() {
    this.info.update();
    this.stab.update();
    this.atab.update();
  }
}
