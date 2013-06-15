import java.awt.event.*;
import javax.swing.*;

/** Handler that is used to enable and disable components in StartupWindow when
 * one of the radio buttons is clicked.
 * @author Qasim Ali
 */
public class StartupButtonHandler implements ActionListener {
  private JRadioButton button; // Radio button to watch for events
  private StartupWindow window; // Window that contains the JRadioButton
  
  /** Creates this handler
   * @param button    the radio button to monitor for events
   */
  public StartupButtonHandler(JRadioButton button, StartupWindow window) {
    this.button = button;
    this.window = window;
  }
  
  /** Disables/enables components in StartupWindow via disableNew and 
   * disableLoad when the associated radio button is clicked
   * @param e    the triggered event
   */
  public void actionPerformed(ActionEvent e) {
    // Disable either the 'new course'or the 'load course' components
    if(this.button.getText().equals("Load course"))
      this.window.disableNew();
    // The button triggered must be the 'new course' button, so disable load
    // components
    else
      this.window.disableLoad();
  }
}
