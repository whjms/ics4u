import java.awt.*;
import javax.swing.*;

/** Closes the passed AssignmentCreator when the associated component triggers
 * an event.
 */
public class AssignmentCreatorCancelController implements ActionListener {
  private AssignmentCreator creator;

  public AssignmentCreatorCancelController(AssignmentCreator creator) {
    this.creator = creator;
  }

  public void actionPerformed(ActionEvent e) {
    this.creator.close();
  }
} 
