import java.awt.*;
import javax.swing.*;

/** Closes the passed JDialog when the associated component triggers
 * an event.
 */
public class CancelController implements ActionListener {
  private JDialog dialog;

  public CancelController(JDialog dialog) {
    this.dialog = dialog;
  }

  public void actionPerformed(ActionEvent e) {
    this.dialog.close();
  }
} 
