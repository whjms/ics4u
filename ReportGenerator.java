import java.io.*;
import java.util.*;
import javax.swing.*;

/** Generates a report for a student with the given name. Reports are in HTML
 * and are saved to user-specified-directory/studentNumber.html.
 * @author Qasim Ali
 */
public class ReportGenerator {
 /** Create this generator for the specified student.
  * @param name    the student's name, in the format "First Second"
  * @param course  the course to read data from
  */
  public static void generateReport(String name, Course course) {
    String studentNumber = course.getStudentNumber(name);
    
    // Check if the course actually has this student. Should never happen, as 
    // student names are read from a table of their names, but useful for debug
    if(studentNumber.equals("000000")) {
      System.out.println("Error generating report for \'" + name + "\': course"
              + " returned default value.");
    }
    
    Student student = null;
    
    // Get the student object that matches the student number
    for(Student s : course.getStudents()) {
      if(studentNumber.equals(s.getNumber()))
        student = s;
    }
    
    // Create a new File within the user-chosen directory
    File outputFile = new File(ReportGenerator.getDirectory(),
            studentNumber + ".html");
            
    PrintWriter out = null;
    try {
      out = new PrintWriter(outputFile);
    }
    // Error creating PrintWriter, abort
    catch(FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Error saving report: file cannot be"
              + " created.", "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    
    ReportGenerator.writeReport(out, student, course);
    out.close();
  }
  
  /** Opens a file chooser that allows the user to select a directory to save
   * the report to
   * @return    the user-specified directory
   */
  private static File getDirectory() {
    JFileChooser fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int result = fc.showSaveDialog(null);
    if(result != JFileChooser.APPROVE_OPTION)
      return null;
    else
      return fc.getCurrentDirectory();
  }
  
  /** Output the HTML using the given PrintWriter
   * @param  writer    the PrintWriter to use
   * @param  student   the student to read data from
   * @param  course    the course to read data from
   */
  private static void writeReport(PrintWriter out, Student student, Course course) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    //=====HEAD=====
    out.println("<head>");
    out.println("<title>Report for " + student.getNumber() + "</title>");
    //=====HEAD=====STYLE===== 
    out.println("<style type=\"text/css>\"");
    out.println("body {font-family:\"Arial\",\"DejaVu Sans\", sans-serif;}");
    out.println("h3{font-size:14pt;font-weight:normal}");
    out.println("h1{font-weight:normal;}");
    out.println("h2{width:100%;font-size:13pt;border-bottom:1px solid black;font-weight:bold;}");
    out.println("table{border:1px solid black;border-collapse:collapse;width:100%;}");
    out.println("thead{font-weight:bold;border-bottom:2px solid black;background:#08f;color:#fff;}");
    out.println("td{border-left:1px solid black;border-right:1px solid black;text-align:center;}");
    out.println("</style></head><body>");
    //=====BODY=====
    //=====BODY=====INFO=====
    out.println("<h1>Student Information</h1>");
    out.println("<div id=\"info\">");
    out.println("<h3>" + student.getNumber() + "</h3>");
    out.println("<h3>" + student.getFirstName() + " " + student.getLastName() + "</h3>");
    out.println("<h3>" + course.getCode() + "</h3>");
    out.println("</div>");
    //=====BODY=====COURSE WEIGHTINGS=====
    out.println("<h2>Course Weightings</h2>");
    out.println("<table><thead><td>K/U</td><td>T/I</td><td>AP</td><td>CO</td></thead>");
    out.println("<tr>");
    out.println("<td>" + course.getCourseWeightings(Course.K) + "</td>");
    out.println("<td>" + course.getCourseWeightings(Course.T) + "</td>");
    out.println("<td>" + course.getCourseWeightings(Course.A) + "</td>");
    out.println("<td>" + course.getCourseWeightings(Course.C) + "</td></tr></table>");
    //=====BODY=====COURSE MARKS======
    out.println("<h2>Course Marks</h2>");
    out.println("<table><thead><td>Overall</td><td>K/U</td><td>T/I</td><td>AP</td><td>CO</td></thead>");
    out.println("<tr>");
    out.println("<td>" + course.getStudentMark(student) + "</td>");
    out.println("<td>" + student.getMark(Course.K) + "</td>");
    out.println("<td>" + student.getMark(Course.T) + "</td>");
    out.println("<td>" + student.getMark(Course.A) + "</td>");
    out.println("<td>" + student.getMark(Course.C) + "</td>");
    out.println("</tr></table>");
    //=====BODY=====ASSIGNMENTS=====
    out.println("<h2>Assignments</h2>");
    out.println("<table><thead><td>Name</td><td>K/U</td><td>T/I</td><td>AP</td><td>CO</td></thead>");
    for(Assignment a : student.getAssignments()) {
      out.println("<tr>");
      out.println("<td>" + a.getName() + "</td>");
      out.println("<td>" + a.getPercentage(Course.K) + "</td>");
      out.println("<td>" + a.getPercentage(Course.T) + "</td>");
      out.println("<td>" + a.getPercentage(Course.A) + "</td>");
      out.println("<td>" + a.getPercentage(Course.C) + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    //=====BODY=====
    out.println("</body>");
    out.println("</html>");
  }
}
