import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** Closes the passed JDialog when the associated component triggers
 * an event.
 * @author Qasim Ali
 */
public class CancelController implements ActionListener {
  private JDialog dialog;

  public CancelController(JDialog dialog) {
    this.dialog = dialog;
  }

  public void actionPerformed(ActionEvent e) {
    this.dialog.dispose();
  }
} 
