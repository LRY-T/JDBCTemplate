package com.shop.UI.ProviderUi;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.Provider;
import com.shop.service.Impl.ProviderServiceImpl;
import com.shop.service.ProviderService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProviderModifyFrm extends JFrame {
    private JLabel lblProviderCode;
    private JLabel lblProviderName;
    private JLabel lblProviderContact;
    private JLabel lblPhone;
    private JLabel lblAddress;
    private JLabel lblProviderFax;
    private JLabel lblProviderDesc;
    private JTextField txtProviderCode;
    private JTextField txtProviderName;
    private JTextField txtProviderContact;
    private JTextField txtPhone;
    private JTextField txtAddress;
    private JTextField txtProviderFax;
    private JTextField txtProviderDesc;
    private JButton btnOK;
    private JButton btnNO;
    private ProviderService providerService = new ProviderServiceImpl();
    public ProviderFindFrm providerfindfrm;
    public ProviderModifyFrm() throws HeadlessException {
        setTitle("修改供应商");
        setBounds(0,0,1000,1000);
        setLocationRelativeTo(null);
        setLayout(null);
        //添加控件
        lblProviderCode = new JLabel("供应商编码");
        lblProviderName = new JLabel("供应商名称");
        lblProviderContact = new JLabel("联系人");
        lblPhone = new JLabel("联系电话");
        lblAddress = new JLabel("地址");
        lblProviderFax = new JLabel("传真");
        lblProviderDesc = new JLabel("描述");
        txtProviderCode = new JTextField();
        txtProviderDesc = new JTextField();
        txtAddress = new JTextField();
        txtPhone = new JTextField();
        txtProviderFax = new JTextField();
        txtProviderContact = new JTextField();
        txtProviderName = new JTextField();
        btnOK = new JButton("保存");
        btnNO = new JButton("取消");
        lblProviderCode.setBounds(250,100,130,30);
        lblProviderName.setBounds(250,200,130,30);
        lblProviderContact.setBounds(250,300,130,30);
        lblPhone.setBounds(250,400,130,30);
        lblAddress.setBounds(250,500,130,30);
        lblProviderFax.setBounds(250,600,130,30);
        lblProviderDesc.setBounds(250,700,130,30);
        txtProviderCode.setBounds(350,100,250,30);
        txtProviderCode.setEditable(false);
        txtProviderName.setBounds(350,200,250,30);
        txtProviderContact.setBounds(350,300,250,30);
        txtPhone.setBounds(350,400,250,30);
        txtAddress.setBounds(350,500,250,30);
        txtProviderFax.setBounds(350,600,250,30);
        txtProviderDesc.setBounds(350,700,250,30);
        btnOK.setBounds(300,800,100,50);
        btnNO.setBounds(600,800,100,50);
        this.add(lblProviderCode);
        this.add(lblProviderName);
        this.add(lblProviderContact);
        this.add(lblPhone);
        this.add(lblAddress);
        this.add(lblProviderFax);
        this.add(lblProviderDesc);
        this.add(txtProviderCode);
        this.add(txtProviderName);
        this.add(txtProviderContact);
        this.add(txtPhone);
        this.add(txtAddress);
        this.add(txtProviderFax);
        this.add(txtProviderDesc);
        this.add(btnOK);
        this.add(btnNO);
        fillData();
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveProvider();
            }
        });
        btnNO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });
    }
    public void fillData(){
        Provider provider = providerService.findOneProvider(ToolUtil.id);
        txtProviderCode.setText(provider.getProCode());
        txtProviderName.setText(provider.getProName());
        txtProviderContact.setText(provider.getProContact());
        txtPhone.setText(provider.getProPhone());
        txtAddress.setText(provider.getProAddress());
        txtProviderFax.setText(provider.getProFax());
        txtProviderDesc.setText(provider.getProDesc());
    }
    public void saveProvider(){
        Provider provider = new Provider();
        provider.setProCode(txtProviderCode.getText());
        provider.setProName(txtProviderName.getText());
        provider.setProContact(txtProviderContact.getText());
        provider.setProPhone(txtPhone.getText());
        provider.setProAddress(txtAddress.getText());
        provider.setProFax(txtProviderFax.getText());
        provider.setProDesc(txtProviderDesc.getText());
        provider.setModifyBy(ToolUtil.user.getId());
        provider.setId(ToolUtil.id);
        int count = providerService.modifyProvider(provider);
        if (count!=0){
            JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
            providerfindfrm.fillProvider();
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.INFORMATION_MESSAGE);
        fillData();
    }
    public void close(){
        this.dispose();
    }
}
