package q4;

import java.time.LocalDate;

public class User implements Comparable<User> {
  private int id;
  private static int userID = 0;
  private String name;
  private String phoneNumber;
  private String major;
  private LocalDate registrationDate;
  
  public User(String name, String phoneNumber, String major, LocalDate registrationDate) {
    super();
    setID();
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.major = major;
    this.registrationDate = registrationDate;
  }
  
  private void setID() {
    id = userID++;
  }
  
  private int getID() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public String getMajor() {
    return major;
  }
  public void setMajor(String major) {
    this.major = major;
  }
  
  public LocalDate getRegistrationDate() {
    return registrationDate;
  }
  public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }
  
  @Override
  public String toString() {
    return "id# " + id + ", name: " + name + ", phone: " + phoneNumber + ", major: " + major + ", registration date: " + registrationDate;
  }

  @Override
  public int compareTo(User o) {
    return this.getRegistrationDate().compareTo(o.getRegistrationDate());
  }
}
