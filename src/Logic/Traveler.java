//NEW OK
package Logic;

import java.util.Date;

public class Traveler {
  
//INSTANTIEVARIABELEN
  private String passportnr;
  private String nationality;
  private String lastname;
  private String firstname;
  private Date dateofbirth;
  private String gender;
  private String email;

//CONSTRUCTOR
  public Traveler(String passportnr, String firstname, String lastname, String gender, String nationality, String email, Date dateofbirth) {
        this.passportnr = passportnr;
        this.nationality = nationality;
        this.lastname = lastname;
        this.firstname = firstname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.email = email;
  }

//GETTERS EN SETTERS
  public String getPassportnr() {
    return passportnr;
  }
                  
  public String getNationality() {
    return nationality;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public String getGender() {
    return gender;
  }

  public Date getDateofbirth() {
    return dateofbirth;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setPassportnr(String passportnr){
    this.passportnr = passportnr;
  }
  
  public void setNationality(String nationality){
      this.nationality = nationality;
  }
  
  public void setLastname(String lastname){
      this.lastname = lastname;
  }
  
  public void setFirstname(String firstname){
      this.firstname = firstname;
  }
  
  public void setGender(String gender){
      this.gender = gender;
  }
  
  public void setDateofbirth(Date dateofbirth){
      this.dateofbirth = dateofbirth;
  }
  
  public void setEmail(){
      this.email = email;
  }
}