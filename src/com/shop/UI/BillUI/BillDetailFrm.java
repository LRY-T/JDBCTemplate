package com.shop.UI.BillUI;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.Bill;
import com.shop.service.Impl.BillServiceImpl;

import javax.swing.*;
import java.awt.*;

public class BillDetailFrm extends JFrame {
    private JLabel lblBillCode;
    private JLabel lblProductName;
    private JLabel lblProductUnit;
    private JLabel lblProductCount;
    private JLabel lblTotalPrice;
    private JLabel lblProvider;
    private JLabel lblIsPayment;
    private JLabel lblBillCode1;
    private JLabel lblProductName1;
    private JLabel lblProductUnit1;
    private JLabel lblProductCount1;
    private JLabel lblTotalPrice1;
    private JLabel lblProvider1;
    private JLabel lblIsPayment1;
    private BillServiceImpl billService;

    public BillDetailFrm() throws HeadlessException {
        setTitle("查看订单详情");
        setBounds(0,0,1000,1000);
        setLocationRelativeTo(null);
        setLayout(null);
        //添加控件
        lblBillCode = new JLabel("订单编码");
        lblBillCode.setBounds(250,100,130,30);
        this.add(lblBillCode);
        lblProductName = new JLabel("商品名称");
        lblProductName.setBounds(250,200,130,30);
        this.add(lblProductName);
        lblProductUnit = new JLabel("商品单位");
        lblProductUnit.setBounds(250,300,130,30);
        this.add(lblProductUnit);
        lblProductCount = new JLabel("商品数量");
        lblProductCount.setBounds(250,400,130,30);
        this.add(lblProductCount);
        lblTotalPrice = new JLabel("总金额");
        lblTotalPrice.setBounds(250,500,130,30);
        this.add(lblTotalPrice);
        lblProvider = new JLabel("供应商");
        lblProvider.setBounds(250,600,130,30);
        this.add(lblProvider);
        lblIsPayment = new JLabel("是否付款");
        lblIsPayment.setBounds(250,700,130,30);
        this.add(lblIsPayment);

        lblBillCode1 = new JLabel("订单编码");
        lblBillCode1.setBounds(390,100,130,30);
        this.add(lblBillCode1);
        lblProductName1 = new JLabel("商品名称");
        lblProductName1.setBounds(390,200,130,30);
        this.add(lblProductName1);
        lblProductUnit1 = new JLabel("商品单位");
        lblProductUnit1.setBounds(390,300,130,30);
        this.add(lblProductUnit1);
        lblProductCount1 = new JLabel("商品数量");
        lblProductCount1.setBounds(390,400,130,30);
        this.add(lblProductCount1);
        lblTotalPrice1 = new JLabel("总金额");
        lblTotalPrice1.setBounds(390,500,130,30);
        this.add(lblTotalPrice1);
        lblProvider1 = new JLabel("供应商");
        lblProvider1.setBounds(390,600,130,30);
        this.add(lblProvider1);
        lblIsPayment1 = new JLabel("是否付款");
        lblIsPayment1.setBounds(390,700,130,30);
        this.add(lblIsPayment1);
        fillData();
    }
    //自定义方法
    public void fillData(){
        billService = new BillServiceImpl();
        Bill bill = billService.findOneBill(ToolUtil.id);
        lblBillCode1.setText(bill.getBillCode());
        lblProductName1.setText(bill.getProductName());
        lblProductUnit1.setText(bill.getProductUnit());
        lblProductCount1.setText(String.valueOf(bill.getProductCount()));
        lblTotalPrice1.setText(String.valueOf(bill.getTotalPrice()));
        lblProvider1.setText(String.valueOf(bill.getProviderId()));
        String ispay = bill.getIsPayment()==1?"未付款":"已付款";
        lblIsPayment1.setText(ispay);
    }
}
