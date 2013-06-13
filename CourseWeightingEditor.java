import javax.swing.*;
import java.awt.*;
import java.awt.border.*;

/** A dialog that allows the user to edit a course's weightings for each
 * category
 * @author Qasim Ali
 */
public class CourseWeightingEditor extends JDialog {
  private Course course;
  private JPanel contentPane;
  private JLabel[] categoryLabels;  // Contains labels for category fields
  private JTextField[] categoryFields;  // Contains category fields

  /** Creates an editor for the specified course 
   * @param course    the course to edit 
   */
  public CourseWeightingEditor(Course course, MainWindow mw) {
    super(mw, "Editing " + this.course.getCode(), true);
    this.course = course;
    
    this.initUI();
    this.registerControllers();
    this.pack();
    this.setVisible(true);
  }

  /** Initializes UI components
   */
  private void initUI() {
    this.contentPane = new JPanel();
    this.setContentPane(this.contentPane);
    
    this.categoryLabels = new JLabel[4];
    this.categoryFields = new JTextField[4];
    
    // Initialize labels
    this.categoryLabels[Course.C] = new JLabel("C/O:");
    this.categoryLabels[Course.T] = new JLabel("T/I:");
    this.categoryLabels[Course.A] = new JLabel("AP:");
    this.categoryLabels[Course.K] = new JLabel("K/U:");
    
    // Initialize text fields
    for(int i = 0; i < 3; i++) {
      this.categoryFields = new JTextField();
    }
  }
} 
