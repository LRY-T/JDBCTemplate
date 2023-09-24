package com.dlkj.shop.UI;

import com.dlkj.shop.UI.BillUI.BillAddFrm;
import com.dlkj.shop.UI.BillUI.BillFindFrm;
import com.dlkj.shop.UI.ProviderUi.ProviderAddFrm;
import com.dlkj.shop.UI.ProviderUi.ProviderFindFrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {
    public MainFrm() throws HeadlessException {
        setTitle("超市订单管理系统");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,600,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //添加菜单
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("订单管理");
        JMenu menu1 = new JMenu("供应商管理");
        JMenuItem menu2 = new JMenuItem("修改密码");
        JMenuItem menu3 = new JMenuItem("退出");
        JMenuItem selectItem,updateItem;//订单管理项目
        JMenuItem findItem,addItem;//供应商管理项目
        selectItem = new JMenuItem("查看订单");
        updateItem = new JMenuItem("增加订单");
        findItem = new JMenuItem("查看供应商");
        addItem = new JMenuItem("增加供应商");
        menuBar.add(menu);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menu.add(selectItem);
        menu.add(updateItem);
        menu1.add(findItem);
        menu1.add(addItem);
        setJMenuBar(menuBar);
        //为查看设置事件
        selectItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillFindFrm findFrm = new BillFindFrm();
                findFrm.setVisible(true);
            }
        });
        findItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProviderFindFrm findFrm = new ProviderFindFrm();
                findFrm.setVisible(true);
            }
        });
        updateItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillAddFrm addFrm = new BillAddFrm();
                addFrm.setVisible(true);
            }
        });
        addItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProviderAddFrm frm = new ProviderAddFrm();
                frm.setVisible(true);
            }
        });
        menu2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyPassword modifyPassword = new ModifyPassword();
                modifyPassword.setVisible(true);
            }
        });
        menu3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                LoginFrm frm = new LoginFrm();
                frm.setVisible(true);
            }
        });
    }
    public void close(){
        this.dispose();
    }
}
