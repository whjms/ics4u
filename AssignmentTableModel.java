import javax.swing.table.*;
import java.util.*;

/** A data model used by the table within AssignmentTab. 
 */
public class AssignmentTableModel extends AbstractTableModel {
  private Course course;
  private ArrayList<ArrayList<Object>> data; // Data, arranged in rows

  private String[] columnNames = {"Name", "K/U Mean",
          "T/I Mean", "AP Mean", "CO Mean", "Summative"}; 

  /** Creates the data model, given a Course to read data from 
   * @param course    the course to read data 
   */
  public AssignmentTableModel(Course course) {
    this.course = course;
    this.data = new ArrayList<ArrayList<Object>>();
    this.update();
  }
  
  /** Returns the assignment name for the specified row index 
   * @param row    the row index of the assignment 
   * @return       the assignment's name 
   */
  public String getAssignmentName(int row) {
    return this.data.get(row)[0];
  }
  /** Returns the number of rows of data in the table. Required for any table 
   * model.
   * @return the number of rows 
   */
  public int getRowCount() {
    return this.data.size();
  }

  /** Returns the number of columns of data in the table. Required for any 
   * table model.
   * @return number of columns 
   */
  public int getColumnCount() {
    return 6; // Number of columns remains constant
  }

  /** Gets the value of a specific cell. Required for any table model. 
   * @param row    the row to read from 
   * @param column the column to read from 
   * @return the requested value 
   */
  public Object getValueAt(int row, int column) {
    return this.data.get(row).get(column);
  }

  /** Get the title of the specified column. Required for any table model. 
   */
  public String getColumnName(int col) {
    return this.columnNames[col];
  }

  /** Updates the model's data to reflect changes in the Course model, and 
   * alerts any associated JTable to update itself.
   */
  public void update() {
    this.data.clear(); 
    
    // Cycle through each row of data, adding information from the Course
    for(int i = 0; i < this.course.getAssignmentOutlines().size(); i++) {
      AssignmentOutline currentAssignment = this.course.
              getAssignmentOutlines().get(i);
      ArrayList<Object> currentRow = this.data.get(i);

      // Add each column of data to the current row 
      currentRow.add(currentAssignment.getName());   // Assignment name
      currentRow.add(this.course.getAssignmentMean(  // Knowledge mean
              currentAssignment.getName(), Course.K));
      currentRow.add(this.course.getAssignmentMean(  // Thinking mean
              currentAssignment.getName(), Course.T));
      currentRow.add(this.course.getAssignmentMean(  // Application mean
              currentAssignment.getName(), Course.A));
      currentRow.add(this.course.getAssignmentMean(  // Communication mean
              currentAssignment.getName(), Course.C));
      currentRow.add(currentAssignment.getSummative()); // Summative status

      this.data.add(currentRow); // Add the new row to the table
    }
    this.fireTableStructureChanged(); // Alert JTable that data has changed
  }
} 
