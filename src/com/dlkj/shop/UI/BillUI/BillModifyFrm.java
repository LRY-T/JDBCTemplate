package com.dlkj.shop.UI.BillUI;

import com.dlkj.shop.UI.Tool.ToolUtil;
import com.dlkj.shop.pojo.Provider;
import com.dlkj.shop.service.BillService;
import com.dlkj.shop.service.Impl.BillServiceImpl;
import com.dlkj.shop.pojo.Bill;
import com.dlkj.shop.service.Impl.ProviderServiceImpl;
import com.dlkj.shop.service.ProviderService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BillModifyFrm extends JFrame {
    private JLabel lblBillCode;
    private JLabel lblProductName;
    private JLabel lblProductUnit;
    private JLabel lblProductCount;
    private JLabel lblTotalPrice;
    private JLabel lblProvider;
    private JLabel lblIsPayment;
    private JTextField txtBillCode;
    private JTextField txtProductName;
    private JTextField txtProductUnit;
    private JTextField txtProductCount;
    private JTextField txtTotalPrice;
    private JComboBox cboProvider;
    private JRadioButton rdoOK;
    private JRadioButton rdoNo;
    private JButton btnOK;
    private JButton btnNO;
    //业务层对象
    private BillService billService = new BillServiceImpl();
    private ProviderService providerService = new ProviderServiceImpl();
    private List<Provider> list;
    //声明窗体订单
    public BillFindFrm billFindFrm;
    public BillModifyFrm() throws HeadlessException {
        setTitle("修改订单");
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

        txtBillCode = new JTextField();
        txtBillCode.setBounds(350,100,250,30);
        txtBillCode.setEditable(false);//设置文本框不可编辑
        this.add(txtBillCode);
        txtProductName = new JTextField();
        txtProductName.setBounds(350,200,250,30);
        this.add(txtProductName);
        txtProductUnit = new JTextField();
        txtProductUnit.setBounds(350,300,250,30);
        this.add(txtProductUnit);
        txtProductCount = new JTextField();
        txtProductCount.setBounds(350,400,250,30);
        this.add(txtProductCount);
        txtTotalPrice = new JTextField();
        txtTotalPrice.setBounds(350,500,250,30);
        this.add(txtTotalPrice);

        cboProvider = new JComboBox<>();
        cboProvider.setBounds(350,600,250,30);
        this.add(cboProvider);

        rdoOK = new JRadioButton("已付款");
        rdoOK.setBounds(350,700,100,50);
        this.add(rdoOK);
        rdoNo = new JRadioButton("未付款");
        rdoNo.setBounds(500,700,100,50);
        this.add(rdoNo);
        btnOK = new JButton("保存");
        btnNO = new JButton("取消");
        btnOK.setBounds(300,800,100,50);
        btnNO.setBounds(600,800,100,50);
        this.add(btnNO);
        this.add(btnOK);
        ButtonGroup group = new ButtonGroup();
        group.add(rdoNo);
        group.add(rdoOK);
        fillData();
        //绑定事件
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveBill();
            }
        });
        btnNO.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });
    }
    //自定义方法开始
    public void fillData(){
        Bill bill = billService.findOneBill(ToolUtil.id);
        txtBillCode.setText(bill.getBillCode());
        txtProductName.setText(bill.getProductName());
        txtProductUnit.setText(bill.getProductUnit());
        txtProductCount.setText(String.valueOf(bill.getProductCount()));
        txtTotalPrice.setText(String.valueOf(bill.getTotalPrice()));
        list = providerService.findAllProvider();
        for (int i = 0; i < list.size(); i++) {
            Provider provider = list.get(i);
            cboProvider.addItem(provider.getProName());
            if (provider.getId() == bill.getProviderId()){
                cboProvider.setSelectedIndex(i);
            }
        }
        if (bill.getIsPayment() == 1){
            rdoOK.setSelected(true);
        }
        else
            rdoNo.setSelected(true);
    }
    //自定义方法结束
    //自定义方法开始
    public void saveBill(){
        Bill bill = new Bill();
        bill.setBillCode(txtBillCode.getText());
        bill.setProductName(txtProductName.getText());
        bill.setProductUnit(txtProductUnit.getText());
        bill.setProductCount(Double.parseDouble(txtProductCount.getText()));
        bill.setTotalPrice(Double.parseDouble(txtTotalPrice.getText()));
        Provider provider = list.get(cboProvider.getSelectedIndex());
        bill.setProviderId(provider.getId());
        int ispay = rdoOK.isSelected()?1:2;
        bill.setIsPayment(ispay);
        bill.setModifyBy(ToolUtil.user.getId());
        bill.setId(ToolUtil.id);
        int count = billService.modifyBill(bill);
        if (count!=0){
            JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
            billFindFrm.fillBill();
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.INFORMATION_MESSAGE);
        fillData();
    }
    public void close(){
        this.dispose();
    }
    //自定义方法结束
}
