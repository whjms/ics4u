import java.io.*;
import javax.swing.*;

/** Loads and saves Courses
 * @author Qasim Ali
 */
public class FileManager {
  /** Serialize the specified course, saving it to the specified file.
   * @param fileName    the file to save to
   * @param course      the course to save
   */
  public static void saveCourse(String fileName, Course course) {
    try {
      // Create output streams for the given filename
      FileOutputStream fo = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(fo);
      out.writeObject(course);
      out.close();
      fo.close();
    }
    // Thrown when the file is a directory or can't be written to, so alert the
    // user and exit the program
    catch(FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error opening \'" + fileName
              + "\' for writing: file is either a directory or cannot be "
              + "written to", "Error writing file", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    // Thrown when an exception occurs when writing the file from writeObject()
    catch(IOException e) {
      // Alert the user and exit
      JOptionPane.showMessageDialog(null, "Error writing \'" + fileName
              + "\': " + e.getMessage(), "Error writing file", 
              JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }
  
  public static Course loadCourse(String fileName) {
  }
}
