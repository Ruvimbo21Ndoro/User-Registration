/* UserGUI.java
 * This is the ueer gui section

 * 26 July 2022
*/
package com.mycompany.userregistration;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.apache.commons.validator.EmailValidator;


public class UserGUI extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JComboBox cboTitle;
    private JLabel lblErrorTitle;
    
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblErrorFirstName;
    
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblErrorLastName;
    
    private JLabel lblGender;
    private JPanel panelGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JLabel lblErrorGender;
    private ButtonGroup genderButtonGroup;
    
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblErrorEmail;
    
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JLabel lblPasswordError;
    
    private JLabel lblConfirmPassword;
    private JPasswordField txtConfirmPassword;
    private JLabel lblConfirmPasswordError;
    
    private JLabel lblTerms;
    private JCheckBox chkTerms;
    private JLabel lblErrorTerms;
    
    private JButton btnSave;
    private JButton btnClear;
    private JButton btnExit;
    
    public UserGUI(){
    super("User Registration");
    lblTitle = new JLabel("Title: ");
    String listOfTitles [] = {"Dr","Mr","Mrs","Rev","Prof","Miss"};
    cboTitle = new JComboBox(listOfTitles);
    lblErrorTitle = new JLabel("*required");
    lblErrorTitle.setForeground(Color.red);
    lblErrorTitle.setVisible(false);
    
    lblFirstName = new JLabel("First Name: ");
    txtFirstName = new JTextField(15);
    lblErrorFirstName = new JLabel("*required");
    lblErrorFirstName.setForeground(Color.red);
    lblErrorFirstName.setVisible(false);
    
    lblLastName = new JLabel("Last Name: ");
    txtLastName = new JTextField(15);
    lblErrorLastName = new JLabel("*required");
    lblErrorLastName.setForeground(Color.red);
    lblErrorLastName.setVisible(false);
    
    lblGender = new JLabel("Gender: ");
    panelGender = new JPanel();
    radFemale = new JRadioButton("Female: ");
    radMale = new JRadioButton("Male: ");
    genderButtonGroup = new ButtonGroup();
    genderButtonGroup.add(radFemale);
    genderButtonGroup.add(radMale);
    panelGender.setLayout(new GridLayout(1, 2));
    radFemale.setSelected(true);
    panelGender.add(radFemale);
    panelGender.add(radMale);
    lblErrorGender = new JLabel("*required");
    lblErrorGender.setForeground(Color.red);
    lblErrorGender.setVisible(false);
    
    lblEmail = new JLabel("Email: ");
    txtEmail = new JTextField(15);
    lblErrorEmail = new JLabel("*valid email required");
    lblErrorEmail.setForeground(Color.red);
    lblErrorEmail.setVisible(false);
    
    lblPassword = new JLabel("Password: ");
    txtPassword = new JPasswordField();
    lblPasswordError = new JLabel("*minimum of 8 characters required");
    lblPasswordError.setForeground(Color.red);
    lblPasswordError.setVisible(false);
    
    lblConfirmPassword = new JLabel("Confirm Password: ");
    txtConfirmPassword = new JPasswordField();
    lblConfirmPasswordError = new JLabel("*password does not match");
    lblConfirmPasswordError.setForeground(Color.red);
    lblConfirmPasswordError.setVisible(false);
    
    lblTerms = new JLabel("Terms and Conditions: ");
    chkTerms = new JCheckBox("i agree to the terms and conditions");
    lblErrorTerms = new JLabel("*required");
    lblErrorTerms.setForeground(Color.red);
    lblErrorTerms.setVisible(false);
    
    btnSave = new JButton("Save");
    btnClear = new JButton("Clear");
    btnExit = new JButton("Exit");
    btnSave.setEnabled(false);
}   
    
    public void setGUI(){
        this.setLayout(new GridLayout(9, 3));
        
        this.add(lblTitle);
        this.add(cboTitle);
        this.add(lblErrorTitle);
        
        this.add(lblFirstName);
        this.add(txtFirstName);
        this.add(lblErrorFirstName);
        
        this.add(lblLastName);
        this.add(txtLastName);
        this.add(lblErrorLastName);
        
        this.add(lblGender);
        this.add(panelGender);
        this.add(lblErrorGender);
        
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblErrorEmail);
        
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblPasswordError);
        
        this.add(lblConfirmPassword);
        this.add(txtConfirmPassword);
        this.add(lblConfirmPasswordError);
        
        this.add(lblTerms);
        this.add(chkTerms);
        this.add(lblErrorTerms);
        
        this.add(btnSave);
        this.add(btnClear);
        this.add(btnExit);
        
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        chkTerms.addActionListener(this);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    public boolean isInputValid(){
        boolean valid = true;
        
        if(txtFirstName.getText().equals("")){
            valid =  false;
            lblErrorFirstName.setVisible(true);
       
        }else
            lblErrorFirstName.setVisible(false);
        
        if(txtLastName.getText().equals("")){
            valid = false;
            lblErrorLastName.setVisible(true);
        }else{
            lblErrorLastName.setVisible(false);
        }
        
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(txtEmail.getText())){
            valid = false;
            lblErrorEmail.setVisible(true);
        }else{
            lblErrorEmail.setVisible(false);
        }
        
        if(txtPassword.getPassword().length < 8){
           valid = false;
           lblPasswordError.setVisible(true);
        }else{
            lblPasswordError.setVisible(false);
        }
        
        if(!Arrays.equals(txtPassword.getPassword(), txtConfirmPassword.getPassword())){
            valid = false;
            lblConfirmPasswordError.setVisible(true);
        }else{
            lblConfirmPasswordError.setVisible(false);
        }
        
        return valid;
    }
    
    public void resetForm(){
        cboTitle.setSelectedIndex(0);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        radFemale.setSelected(true);
        txtEmail.setText(null);
        txtPassword.setText(null);
        txtConfirmPassword.setText(null);
        chkTerms.setSelected(false);
        btnSave.setEnabled(false);
        
        lblErrorFirstName.setVisible(false);
        lblErrorLastName.setVisible(false);
        lblErrorEmail.setVisible(false);
        lblPasswordError.setVisible(false);
        lblConfirmPasswordError.setVisible(false);     
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSave){
            if(isInputValid()){
                User u = new User(cboTitle.getSelectedItem().toString(),
                                  txtFirstName.getText(), 
                                  txtLastName.getText(),
                                  radFemale.isSelected()?"Female":"Male",
                                  txtEmail.getText(),
                                  String.valueOf(txtPassword.getPassword()));
                if(u.isEmailUnique()){
                    u.saveToDB();
                    resetForm(); 
                }else{
                    JOptionPane.showMessageDialog(this,"This email already has been used to register.");
                    txtEmail.setText("");
                    txtEmail.hasFocus();
                }
               
            }
        }else if(e.getSource() == btnClear){
            resetForm();
        }else if(e.getSource() == btnExit){
            System.exit(0);
        }else if(e.getSource() == chkTerms){
            if(chkTerms.isSelected()){
                btnSave.setEnabled(true);
            }else {
                btnSave.setEnabled(false);
            }
        }
    }
}
