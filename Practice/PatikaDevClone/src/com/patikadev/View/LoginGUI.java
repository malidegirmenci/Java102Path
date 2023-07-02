package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wrapperTop;
    private JPanel wrapperBot;
    private JLabel lbl_patika_ico;
    private JTextField fld_username;
    private JButton btn_login;
    private JPasswordField fld_password;

    public LoginGUI(){
        add(wrapper);
        setSize(400,500);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_password)){
                Helper.showMessage("fill");
            }else{
                User u = User.getFetch(fld_username.getText(), fld_password.getText());
                if(u == null){
                    Helper.showMessage("Invalid username / password!");
                }else{
                    switch (u.getType()) {
                        case "operator" -> {
                            OperatorGUI operatorGUI = new OperatorGUI((Operator) u);
                        }
                        case "educator" -> {
                            EducatorGUI educatorGUI = new EducatorGUI();
                        }
                        case "student" -> {
                            StudentGUI studentGUI = new StudentGUI();
                        }
                    }
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login = new LoginGUI();
    }
}
