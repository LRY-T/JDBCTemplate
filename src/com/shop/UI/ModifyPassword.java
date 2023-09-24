package com.shop.UI;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.User;
import com.shop.service.Impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifyPassword extends JFrame {
    private JLabel lblOldPassword;
    private JLabel lblNewPassword;
    private JLabel lblSurePassword;
    private JTextField txtOldPassword;
    private JTextField txtNewPassword;
    private JTextField txtSurePassword;
    private JButton btnOK;
    private JButton btnNO;
    private UserServiceImpl service = new UserServiceImpl();
    public ModifyPassword() throws HeadlessException {
        setTitle("修改密码");
        setBounds(0,0,500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        lblOldPassword = new JLabel("旧密码：");
        lblNewPassword = new JLabel("新密码：");
        lblSurePassword = new JLabel("确认密码：");
        lblOldPassword.setBounds(120,20,80,30);
        lblNewPassword.setBounds(120,120,80,30);
        lblSurePassword.setBounds(120,220,80,30);
        this.add(lblOldPassword);
        this.add(lblNewPassword);
        this.add(lblSurePassword);

        txtOldPassword = new JTextField();
        txtNewPassword = new JTextField();
        txtSurePassword = new JTextField();
        txtOldPassword.setBounds(210,20,130,30);
        txtNewPassword.setBounds(210,120,130,30);
        txtSurePassword.setBounds(210,220,130,30);
        this.add(txtOldPassword);
        this.add(txtNewPassword);
        this.add(txtSurePassword);

        btnOK = new JButton("保存");
        btnNO = new JButton("取消");
        btnOK.setBounds(150,300,80,60);
        btnNO.setBounds(310,300,80,60);
        this.add(btnOK);
        this.add(btnNO);
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                savePassword();
            }
        });
        btnNO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });
    }
    public void savePassword(){
        User user = new User();
        user.setUserPassword(txtNewPassword.getText());
        user.setId(ToolUtil.user.getId());
        int UserPassword = Integer.parseInt(ToolUtil.user.getUserPassword());
        int count = service.modifyUserPw(user);
        if (count!=0){
            int OldPassword = Integer.parseInt(txtOldPassword.getText());
            if (OldPassword == UserPassword){
                int NewPassword = Integer.parseInt(txtNewPassword.getText());
                int SurePassword = Integer.parseInt(txtSurePassword.getText());
            if (NewPassword == SurePassword) {
                JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                }
            else
                JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.INFORMATION_MESSAGE);
    }
    public void close(){
        this.dispose();
    }
}
