package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    public static int screenCenter(String axis, Dimension size){
        int point;
        switch (axis){
            case "x" -> point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static void showMessage(String str){
        optionPaneTR();
        String msg;
        String title;
        switch (str){
            case "fill" -> {
                title = "Error!";
                msg = "Please, fill all blanks!";
            }
            case "done" -> {
                title = "Message";
                msg = "Processes successful!";
            }
            case "error" -> {
                title = "Error";
                msg = "Transaction failed!";
            }
            default -> {
                title = "Message";
                msg = str;
            }
        }
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Done");
    }
    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure" -> msg = "Are you sure?";
            default -> msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"REMOVE",JOptionPane.YES_NO_OPTION) == 0;
    }
}
