import javax.swing.*;
import java.awt.border.*;

/** Window that appears before the main window. Allows the user to either create
 * a new course or load an existing one.
 * @author Qasim Ali
 */
 public class StartupWindow extends JFrame {
   public StartupWindow() {
     super("GRADEschool 2K13");
     this.initUI();
     this.layoutUI();
     this.registerControllers();
   }
   
   /** Initialize UI components
    */
    private void initUI() {
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
    publid void disableNew() {
    }
 }
