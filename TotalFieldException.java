/** Exception that is thrown when the user enters an invalid value for a 
 * 'total' field for an assignment, whether when creating or editing it.
 * @author Qasim Ali
 */
public class TotalFieldException extends Exception {
  private int value; // the value of the field that that caused this to be thrown 

  /** Creates this object with the specified value
   * @param value    the value of the text field 
   */
  public TotalFieldException(int value) {
    this.value = value;
  }

  public String toString() {
    return "Error entering category total. \'" + this.value + "\' is not a " 
            + "valid value.";
  }
} 
