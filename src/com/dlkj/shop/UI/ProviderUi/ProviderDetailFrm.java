package com.dlkj.shop.UI.ProviderUi;

import com.dlkj.shop.UI.Tool.ToolUtil;
import com.dlkj.shop.service.Impl.ProviderServiceImpl;
import com.dlkj.shop.pojo.Provider;

import javax.swing.*;
import java.awt.*;

public class ProviderDetailFrm extends JFrame {
    private JLabel lblProviderCode;
    private JLabel lblProviderName;
    private JLabel lblProviderContact;
    private JLabel lblPhone;
    private JLabel lblAddress;
    private JLabel lblProviderFax;
    private JLabel lblProviderDesc;private JLabel lblProviderCode1;
    private JLabel lblProviderName1;
    private JLabel lblProviderContact1;
    private JLabel lblPhone1;
    private JLabel lblAddress1;
    private JLabel lblProviderFax1;
    private JLabel lblProviderDesc1;
    private ProviderServiceImpl providerService;
    public ProviderDetailFrm() throws HeadlessException {
        setTitle("查看供应商详情");
        setBounds(0,0,1000,1000);
        setLocationRelativeTo(null);
        setLayout(null);
        lblProviderCode = new JLabel("供应商编码");
        lblProviderName = new JLabel("供应商名称");
        lblProviderContact = new JLabel("联系人");
        lblPhone = new JLabel("联系电话");
        lblAddress = new JLabel("地址");
        lblProviderFax = new JLabel("传真");
        lblProviderDesc = new JLabel("描述");

        lblProviderCode1 = new JLabel("供应商编码");
        lblProviderName1 = new JLabel("供应商名称");
        lblProviderContact1 = new JLabel("联系人");
        lblPhone1 = new JLabel("联系电话");
        lblAddress1 = new JLabel("地址");
        lblProviderFax1 = new JLabel("传真");
        lblProviderDesc1 = new JLabel("描述");

        lblProviderCode.setBounds(250,100,130,30);
        lblProviderName.setBounds(250,200,130,30);
        lblProviderContact.setBounds(250,300,130,30);
        lblPhone.setBounds(250,400,130,30);
        lblAddress.setBounds(250,500,130,30);
        lblProviderFax.setBounds(250,600,130,30);
        lblProviderDesc.setBounds(250,700,130,30);

        lblProviderCode1.setBounds(390,100,130,30);
        lblProviderName1.setBounds(390,200,130,30);
        lblProviderContact1.setBounds(390,300,130,30);
        lblPhone1.setBounds(390,400,130,30);
        lblAddress1.setBounds(390,500,130,30);
        lblProviderFax1.setBounds(390,600,130,30);
        lblProviderDesc1.setBounds(390,700,130,30);

        this.add(lblProviderCode);
        this.add(lblProviderName);
        this.add(lblProviderContact);
        this.add(lblPhone);
        this.add(lblAddress);
        this.add(lblProviderFax);
        this.add(lblProviderDesc);

        this.add(lblProviderCode1);
        this.add(lblProviderName1);
        this.add(lblProviderContact1);
        this.add(lblPhone1);
        this.add(lblAddress1);
        this.add(lblProviderFax1);
        this.add(lblProviderDesc1);
        fillData();
    }
    public void fillData(){
        providerService = new ProviderServiceImpl();
        Provider provider = providerService.findOneProvider(ToolUtil.id);
        lblProviderCode1.setText(provider.getProCode());
        lblProviderName1.setText(provider.getProName());
        lblProviderContact1.setText(provider.getProContact());
        lblPhone1.setText(provider.getProPhone());
        lblAddress1.setText(provider.getProAddress());
        lblProviderFax1.setText(provider.getProFax());
        lblProviderDesc1.setText(provider.getProDesc());
    }
}
