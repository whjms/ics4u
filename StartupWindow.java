import javax.swing.*;
import java.awt.border.*;

/** Window that appears before the main window. Allows the user to either create
 * a new course or load an existing one.
 * @author Qasim Ali
 */
 public class StartupWindow extends JFrame {
   private JPanel newCoursePanel; // Contains components for creating new course
   private JPanel loadCoursePanel; // Contains components for loading course
   private JPanel contentPane;  // Main panel
   private JLabel welcomeLabel;  // Provides instructions for the user
   
   // Radio buttons used to select between new and loading courses
   private JRadioButton loadButton;
   private JRadioButton newButton;
   private ButtonGroup group;  // Used to prevent multiple buttons from being
                               // selected
   private JTextField fileName;  // Displays the chosen course's filename
   private JTextField courseCode;  // Allows the user to enter a new course's 
                                   // code
   private JButton okButton;  // Allows the user to confirm and close the window
   private JButton fileButton;  // Allows the user to select a file
   
   public StartupWindow() {
     super("GRADEschool 2K13");
     this.initUI();
     this.layoutUI();
     this.registerControllers();
   }
   
   /** Initialize UI components
    */
    private void initUI() {
      // Initialize panels
      this.contentPane = new JPanel();
      this.setContentPane(this.contentPane);
      this.newCoursePanel = new JPanel();
      this.loadCoursePanel = new JPanel();
      
      this.loadButton = new JRadioButton("Load course");
      this.newButton = new JRadioButton("New course");
      this.group = new ButtonGroup();
      this.group.add(loadButton);
      this.group.add(newButton);
      
      this.fileName = new JTextField();
      this.fileName.setEditable(false);  // User can only change filename by
                                         // opening file chooser dialog
    }
    
    /** Layout UI components
     */
    private void layoutUI() {
    }
    
    /** Register controllers for radio buttons, ok button, and file chooser 
     * button
     */
    private void registerControllers() {
    }
    
    /** Disable all components within the loadCoursePanel
     */
    public void disableLoad() {
    }
    
    /** Disable all components within the newCoursePanel
     */
    public void disableNew() {
    }
 }
