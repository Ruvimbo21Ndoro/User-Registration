/* User.java
 * This is the user section

 * 26 July 2022
*/
package com.mycompany.userregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class User {
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/UserRegistrationDB";
    private final String dbUsername = "Adminstrator"; 
    private final String dbPassword = "password";
    
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;

    public User() {
    }

    public User(String title, String firstName, String lastName, String gender, String email, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", password=" + password + '}';
    }
    
    public boolean isEmailUnique(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean unique = false;
        
           int ok;
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, dbUsername, dbPassword);
               statement = connection.createStatement();
               resultSet = statement.executeQuery("SELECT* FROM userRegistration WHERE email = '"+ email+"'");
               if(!resultSet.next()){
                 //  JOptionPane.showMessageDialog(null, "Successful registration.");
                   unique = true;
               }/*else{
                   JOptionPane.showMessageDialog(null, "Error: Could not add subject");
                  // txtSubjectCode.hasFocus();
               }*/
               
           }catch(SQLException sqe){
               JOptionPane.showMessageDialog(null,"Error: Could not add registration"+ sqe);
           }catch(Exception exception){
               JOptionPane.showMessageDialog(null, "Error: "+ exception);
               //txtSubjectCode.hasFocus();
           }finally {
               try{
                 if(statement != null)  
                     statement.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }try{
                 if(connection != null)  
                     connection.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }
           }
           return unique;

    }
    
    public void saveToDB(){
        
           Connection connection = null;
           PreparedStatement statement = null;
           int ok;
           String sql = "INSERT INTO UserRegistration VALUES(?,?,?,?,?,?)";
           
           try{
               connection = DriverManager.getConnection(DATABASE_URL, dbUsername, dbPassword);
               statement = connection.prepareStatement(sql);
               statement.setString(1, title);
               statement.setString(2, firstName);
               statement.setString(3, lastName);
               statement.setString(4, gender);
               statement.setString(5, email);
               statement.setString(6, password);
               
               ok = statement.executeUpdate();
               if(ok>0){
                   JOptionPane.showMessageDialog(null, "Success! User added.");
               }else{
                   JOptionPane.showMessageDialog(null, "Error: Could not add user");
               }
               
           }catch(SQLException sqe){
               JOptionPane.showMessageDialog(null,"Error: "+sqe.getMessage());
           }catch(Exception exception){
               JOptionPane.showMessageDialog(null, "Error: "+ exception.getMessage());
            
           }finally {
               try{
                 if(statement != null)  
                     statement.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }try{
                 if(connection != null)  
                     connection.close();
               }catch(Exception exception){
                   JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
               }
           }
           
    }
}
