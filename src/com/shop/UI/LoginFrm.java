package com.shop.UI;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.User;
import com.shop.service.Impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrm extends JFrame {
    private Label lblName;//用户名文本标签
    private Label lblPassword;//密码文本标签
    private JTextField txtName;//用户名文本框
    private JPasswordField pwdPassword;//密码文本框;
    private JButton btnOK;//登录按钮
    private JButton btnCancel;//取消按钮
    public static void main(String[] args) {
        LoginFrm fre = new LoginFrm();
        fre.setVisible(true);
    }
    public LoginFrm() throws HeadlessException {
        setTitle("登录窗体");//设置窗体标题
        setBounds(100,100,500,400);
        setLocationRelativeTo(null);//设置窗体居中
        setResizable(false);//禁止窗体改变大小
        setLayout(null);//设置窗体布局
        //添加控件
        lblName = new Label("用户名：");
        lblPassword = new Label("密 码：");
        lblName.setBounds(150,55,45,30);
        lblPassword.setBounds(150,105,40,30);
        this.add(lblName);
        this.add(lblPassword);
        //文本框控件
        txtName = new JTextField();
        txtName.setBounds(210,60,120,20);
        pwdPassword = new JPasswordField();
        pwdPassword.setBounds(210,110,120,20);
        this.add(txtName);
        this.add(pwdPassword);
        //按钮控件
        btnOK = new JButton("确认");
        btnCancel = new JButton("取消");
        btnOK.setBounds(120,200,70,50);
        btnCancel.setBounds(300,200,70,50);
        this.add(btnOK);
        this.add(btnCancel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //添加鼠标单击事件
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //获取控件的值
                String name = txtName.getText();
                String password = String.valueOf(pwdPassword.getPassword());
                UserServiceImpl userService = new UserServiceImpl();
                User user = userService.login(name,password);
                if (user!=null){
                    JOptionPane.showMessageDialog(null,"登录成功","提示",JOptionPane.INFORMATION_MESSAGE);
                    //存放登录成功的用户对象
                    ToolUtil.user = user;
                    MainFrm mainFrm = new MainFrm();
                    mainFrm.setVisible(true);
                    close();
                }
                else {
                    JOptionPane.showMessageDialog(null,"用户名或密码错误","提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    //关闭登录窗口
    public void close(){
        this.dispose();
    }
}