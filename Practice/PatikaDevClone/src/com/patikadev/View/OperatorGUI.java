package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Path;
import com.patikadev.Model.User;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;


public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JLabel lbl_welcome;
    private JPanel pnl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_username;
    private JPasswordField passfld_user_password;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JButton btn_user_remove;
    private JTextField fld_user_id;
    private JTextField fld_search_user_name;
    private JTextField fld_search_user_username;
    private JComboBox cmb_search_user_type;
    private JButton btn_search_user;
    private JPanel pnl_path_list;
    private JScrollPane scrl_path_list;
    private JTable tbl_path_list;
    private JPanel pnl_path_add;
    private JTextField fld_path_name;
    private JButton btn_path_add;
    private JTabbedPane pnl_course_form;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_language;
    private JComboBox cmb_course_path;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private DefaultTableModel mdl_path_list;
    private Object[] row_path_list;
    private JPopupMenu pathMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;


    public OperatorGUI(Operator operator){

        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome "+ operator.getName());
        // UserList Started
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Name","Username","Password","Membership Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);

        row_user_list = new Object[col_user_list.length];
        loadUserModel();
        loadEducatorCmb();

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
        tbl_user_list.getColumnModel().getColumn(0).setMaxWidth(25);
        tbl_user_list.getSelectionModel().addListSelectionListener(e ->{
            try {
                String selected_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                fld_user_id.setText(selected_user_id);
            } catch (Exception exception){

            }

        });
        tbl_user_list.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),1).toString();
                String user_username = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),2).toString();
                String user_password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),4).toString();
                if(User.update(user_id,user_name,user_username,user_password,user_type)){
                    Helper.showMessage("done");
                }else {
                    Helper.showMessage("error");
                }
                loadUserModel();
                loadEducatorCmb();
                loadCourseModel();
            }
        });
        // UserList Ended
        // PathList Started
        pathMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Update");
        JMenuItem removeMenu = new JMenuItem("Remove");
        pathMenu.add(updateMenu);
        pathMenu.add(removeMenu);
        updateMenu.addActionListener(e -> {
            int selected_id = Integer.parseInt(tbl_path_list.getValueAt(tbl_path_list.getSelectedRow(), 0).toString());
            UpdatePathGUI updatePathGUI = new UpdatePathGUI(Path.getFetch(selected_id));
            updatePathGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPathModel();
                    loadPathCmb();
                    loadCourseModel();
                }
            });
        });
        removeMenu.addActionListener(e -> {
            if(Helper.confirm("sure")){
                int selected_id = Integer.parseInt(tbl_path_list.getValueAt(tbl_path_list.getSelectedRow(), 0).toString());
                if(Path.remove(selected_id)){
                    Helper.showMessage("done");
                    loadPathModel();
                    loadPathCmb();
                    loadCourseModel();

                }else {
                    Helper.showMessage("error");
                }
            }
        });
        mdl_path_list = new DefaultTableModel();
        Object[] col_path_list = {"ID","NAME"};
        mdl_path_list.setColumnIdentifiers(col_path_list);
        row_path_list = new Object[col_path_list.length];
        loadPathModel();
        loadPathCmb();
        tbl_path_list.setModel(mdl_path_list);
        tbl_path_list.setComponentPopupMenu(pathMenu);
        tbl_path_list.getTableHeader().setReorderingAllowed(false);
        tbl_path_list.getColumnModel().getColumn(0).setMaxWidth(25);
        tbl_path_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_path_list.rowAtPoint(point);
                tbl_path_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        // PathList Ended
        // CourseList Started
        mdl_course_list = new DefaultTableModel();
        Object[] col_course_list= {"ID", "Course Name", "Language", "Path", "Educator"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(25);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadPathCmb();
        loadEducatorCmb();


        // CourseList Ended
        btn_user_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_username) || Helper.isFieldEmpty(passfld_user_password) ){
                Helper.showMessage("fill");
            } else{
                String name = fld_user_name.getText();
                String username = fld_user_username.getText();
                String password = passfld_user_password.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if(User.add(name,username,password,type)) {
                    Helper.showMessage("done");
                    loadUserModel();
                    loadEducatorCmb();
                    fld_user_name.setText(null);
                    fld_user_username.setText(null);
                    passfld_user_password.setText(null);
                }
            }
        });
        btn_user_remove.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_id)){
                Helper.showMessage("fill");
            } else {
                if(Helper.confirm("sure")){
                    int user_id = Integer.parseInt(fld_user_id.getText());
                    if (User.remove(user_id)){
                        Helper.showMessage("done");
                        loadUserModel();
                        loadEducatorCmb();
                        loadCourseModel();
                        fld_user_id.setText(null);
                    }else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_search_user.addActionListener(e -> {
            String name = fld_search_user_name.getText();
            String username = fld_search_user_username.getText();
            String type = Objects.requireNonNull(cmb_search_user_type.getSelectedItem()).toString();
            ArrayList<User> searchingUser = User.searchUserList(User.searchQuery(name,username,type));
            loadUserModel(searchingUser);
        });
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();

        });
        btn_path_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_path_name)){
                Helper.showMessage("fill");
            } else {
                if(Path.add(fld_path_name.getText())){
                    Helper.showMessage("done");
                    loadPathModel();
                    loadPathCmb();
                    fld_path_name.setText(null);
                }else{
                    Helper.showMessage("error");
                }
            }
        });
        btn_course_add.addActionListener(e -> {
            Item pathItem =(Item) cmb_course_path.getSelectedItem();
            Item userItem = (Item) cmb_course_user.getSelectedItem();
            if(Helper.isFieldEmpty(fld_course_name) || Helper.isFieldEmpty(fld_course_language)){
                Helper.showMessage("fill");
            } else {
                if(Course.add(userItem.getKey(), pathItem.getKey(),fld_course_name.getText(),fld_course_language.getText())){
                    Helper.showMessage("done");
                    loadCourseModel();
                    fld_course_name.setText(null);
                    fld_course_language.setText(null);
                }else {
                    Helper.showMessage("error");
                }
            }
        });
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Course obj : Course.getList()){
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLanguage();
            row_course_list[i++] = obj.getPath().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPathModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_path_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Path obj : Path.getList()){
            i = 0;
            row_path_list[i++] = obj.getId();
            row_path_list[i++] = obj.getName();
            mdl_path_list.addRow(row_path_list);
        }
    }

    public void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : list) {
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }
    public void loadUserModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : User.getList()) {
            i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }
    public void loadPathCmb(){
        cmb_course_path.removeAllItems();
        for(Path obj : Path.getList()){
            cmb_course_path.addItem(new Item(obj.getId(), obj.getName()));
        }
    }

    public void loadEducatorCmb(){
        cmb_course_user.removeAllItems();
        for(User obj : User.getListOnlyEducator()){
            cmb_course_user.addItem(new Item(obj.getId(), obj.getName()));
        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op = new Operator();
        op.setId(1);
        op.setName("Mehmet Ali Değirmenci");
        op.setPassword("1234");
        op.setType("Operator");
        op.setUsername("malidegirmenci");


        OperatorGUI ogGUI = new OperatorGUI(op);
    }


}
