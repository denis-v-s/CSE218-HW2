package q4;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import q1.*;

public class EnrollmentAppController {
  @FXML private TextField txtName;
  @FXML private TextField txtPhone;
  @FXML private TextField txtMajor;
  @FXML private DatePicker dtRegistrationDate;
  @FXML private Button btnQueueUp;
  @FXML private Button btnPopulate;
  @FXML private Button btnReset;
  @FXML private TextArea txtRegistered;
  @FXML private TextArea txtWaitlist;
  @FXML private Label lblQueue;
  
  private PriorityQueue<User> pq = new PriorityQueue<>();
  
  public void queueUser() {
    String name = txtName.getText();
    String phone = txtPhone.getText();
    String major = txtMajor.getText();
    LocalDate date = dtRegistrationDate.getValue();
    
    User user = new User(name, phone, major, date);
    pq.insert(user);
    lblQueue.setText("Queued (" + pq.size() + ")");
    clearEntryFields();
  }
  
  public void populateLists() {
    int i = 0;
    while (!pq.isEmpty()) {
      User user = pq.remove(); 
      if (i++ < 5) {
        txtRegistered.appendText(user.toString() + "\r\n");
      } else {
        txtWaitlist.appendText(user.toString() + "\r\n"); 
      }
    }
  }
  
  public void resetQueue() {
    pq = new PriorityQueue<>();
    lblQueue.setText("Queued (" + pq.size() + ")");
    txtRegistered.clear();
    txtWaitlist.clear();
    clearEntryFields();
  }
  
  private void clearEntryFields() {
    txtName.clear();
    txtPhone.clear();
    txtMajor.clear();
  }
}
