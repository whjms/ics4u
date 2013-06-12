import javax.swing.*;
import java.util.*;

/** Data model for the combo box that allows the user to select students
 * to view.
 * @author Qasim Ali
 */
public class StudentComboBoxModel extends AbstractListModel implements ComboBoxModel {
	
	private ArrayList<String> students = new ArrayList<String>(); // Data
	private Course course;
	private String selected = null;  // Contents of the currently selected item
	
	/** Create this model, given a Course to read data from
	 * @param course    the Course to get data from
	 */
	public StudentComboBoxModel(Course course) {
		this.course = course;
	}
	
	/** Required for implementing AbstractListModel
	 * @param   index   the index of the element to get
	 * @return          the value of the specified element
	 */
	public Object getElementAt(int index) {
		return this.students.get(index);
	}
	
	/** Required for implementing AbstractListModel
	 * @return          the number of elements in the model's list
	 */
	public int getSize() {
		return this.students.size();
	}
	
	/** Required for implementing ComboBoxModel
	 * @return           the currently selected item
	 */
	public Object getSelectedItem() {
		return this.selected;
	}
	
	/** Required for implementing ComboBoxModel
	 * @param item       the new value of the selected item
	 */
	public void setSelectedItem(Object item) {
		 this.selected = (String)item;  // Assume all items given can be cast
	}
	
	/** Updates data to reflect the Course's
	 */
	public void update() {
		this.students.clear();
		this.students.add("All Students");
		
		// Get the list of students from the Course and add it to the list
		Vector<String> studentList = this.course.getStudentNames();
		for(String student : studentList) {
			this.students.add(student);
		}
		/* Alert the associated ComboBox to update itself. Passed the event
		 * source and the interval of indicies of changed elements (assuming all
		 * elements changed)
		 */
		this.fireContentsChanged(this, 0, this.students.size());
	}
}

