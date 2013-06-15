/**
 * Displays an ImageIcon
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ImageComponent extends JComponent {
  private ImageIcon pic;
  
  public ImageComponent(ImageIcon pic) { 
    super();
    this.pic = pic;
    this.setPreferredSize(new Dimension(this.pic.getIconWidth(), 
                                        this.pic.getIconHeight()));
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(this.pic.getImage(), 0, 0, null);
  }
  
  public void setImage(ImageIcon i) {
    this.pic = i;
    this.repaint();
    this.setPreferredSize(new Dimension(this.pic.getIconWidth(), 
                                        this.pic.getIconHeight()));
  }
}
