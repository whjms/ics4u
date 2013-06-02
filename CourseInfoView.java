import javax.swing.*;
import java.util.ArrayList;

/** A panel that contains labels that display basic course info, including 
  * means, medians, and student/assignment info
  * Created May 30, 2013
  * @author Qasim Ali
  */
public class CourseInfoView extends JPanel {
  private Course course; // Model
 
  // General course info 
  private JPanel infoPanel; // Contains general course info
  private JLabel nameLabel; // Displays the Course's name
  private JLabel students;  // Displays number of students
  private JLabel assignments; // Displays number of assignments
  
  // 'Means' section
  private JPanel meanPanel;
  private JLabel courseMean;
  private JLabel[] meanLabels; // Contains labels that display means for each
                               // category

  // 'Medians' section
  private JPanel medianPanel;
  private JLabel courseMedian;
  private JLabel kMedian; // Knowledge
  private JLabel cMedian; // Communication
  private JLabel tMedian; // Thinking
  private JLabel aMedian; // Application
  
  public CourseInfoView(Course course) { 
    super();
    this.course = course;
    this.initUI();
    this.update();
  }
  
  /** Initializes UI components
    */
  private void initUI() {
    this.initMean();
    this.initMedian();
    this.initInfo();

    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.add(this.infoPanel);
    this.add(this.meanPanel);
    this.add(this.medianPanel);
  }

  /** Initialize and add components for median section 
   */
  private void initMedian() {
    // Initialize labels 
    this.courseMedian = new JLabel("Course: ");
    this.medianLabels = new JLabel[4];
    this.medianLabels[Course.COMMUNICATION] = new JLabel("CO: ");
    this.medianLabels[Course.THINKING] = new JLabel("T/I: ");
    this.medianLabels[Course.APPLICATION] = new JLabel("AP: ");
    this.medianLabels[Course.KNOWLEDGE] = new JLabel("K/U: ");

    this.medianPanel = new JPanel();
    this.medianPanel.setBorder(BorderFactory.createTitledBorder(
            "Course Medians"));
    this.medianPanel.setLayout(new BoxLayout(this.medianPanel,
            BoxLayout.Y_AXIS));

    // Add components
    this.medianPanel.add(this.courseMean);
    for(JLabel label : this.medianLabels) {
      this.medianPanel.add(label);
    }
  }

  /** Initialize and add components for mean section
   */
  private void initMean() {
    // Initialize labels 
    this.courseMean = new JLabel("Course: ");
    this.meanLabels = new JLabel[4];
    this.meanLabels[Course.COMMUNICATION] = new JLabel("CO: ");
    this.meanLabels[Course.THINKING] = new JLabel("T/I: ");
    this.meanLabels[Course.APPLICATION] = new JLabel("AP: ");
    this.meanLabels[Course.KNOWLEDGE] = new JLabel("K/U: ");

    this.meanPanel = new JPanel();
    this.meanPanel.setBorder(BorderFactory.createTitledBorder("Course Means"));
    this.meanPanel.setLayout(new BoxLayout(this.meanPanel, BoxLayout.Y_AXIS));

    // Add components
    this.meanPanel.add(this.courseMean);
    for(JLabel label : this.meanLabels) {
      this.meanPanel.add(label);
    }
  }

  /** Initializles and adds components for infoPanel
   */
  private void initInfo() {
    this.infoPanel = new JPanel();
    this.nameLabel = new JLabel("Course code: ");
    this.students = new JLabel("Students: ");
    this.assignments = new JLabel("Assignments: ");

    this.infoPanel.setLayout(new BoxLayout(this.infoPanel, BoxLayout.Y_AXIS));
    this.infoPanel.add(this.nameLabel);
    this.infoPanel.add(this.students);
    this.infoPanel.add(this.assignments);
  }
  
  /** Updates general course info labels 
   */
  private void updateCourseInfo() {
    this.students.setText("Students: " + this.course.getStudents().size());
    this.assignments.setText("Assignments: "
            + this.course.getAssignmentOutlines().size());
  }

  /** Updates course mean info labels 
   */
  private void updateMean() {
    this.courseMean.setText("Course: " + this.course.getMean());
    this.meanLabels[Course.COMMUNICATION].setText("CO: " 
            + this.course.getMean(Course.COMMUNICATION));
    this.meanLabels[Course.KNOWLEDGE].setText("K/U: "
            + this.course.getMean(Course.KNOWLEDGE));
    this.meanLabels[Course.APPLICATION].setText("AP: "
            + this.course.getMean(Course.APPLICATION));
  }

  /** Updates course median info labels 
   */
  private void updateMedian() {
    this.courseMedian.setText("Course: " + this.course.getMedian());
    this.medianLabels[Course.COMMUNICATION].setText("CO: "
            + this.course.getMedian(Course.COMMUNICATION));
    this.medianLabels[Course.KNOWLEDGE].setText("K/U: " 
            + this.course.getMedian(Course.KNOWLEDGE));
    this.medianLabels[Course.APPLICATION].setText("AP: " 
            + this.course.getMedian(Course.APPLICATION));
  }

  /** Update labels to reflect the Course's data
   */
  private void update() {
    this.updateCourseInfo();
    this.updateMean();
    this.updateMedian();
  }
}