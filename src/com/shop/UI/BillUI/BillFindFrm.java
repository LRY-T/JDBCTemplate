package com.shop.UI.BillUI;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.Bill;
import com.shop.service.Impl.BillServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class BillFindFrm extends JFrame {
    private JTable BillTable;//声明表格控件
    private BillServiceImpl service;
    private JScrollPane scrollPane;//声明添加表头的对象
    private JPopupMenu popupMenu;//弹出菜单控件
    private JMenuItem delMenu;
    private JMenuItem modifyMenu;
    private JMenuItem detailMenu;//删除菜单/修改菜单/查看详情菜单
    public BillFindFrm() throws HeadlessException {
        setTitle("查看订单");
        setBounds(0,0,900,900);
        setLocationRelativeTo(null);
        //添加表格控件
        service = new BillServiceImpl();
        BillTable =  new JTable();
        //填充数据
        fillBill();
        scrollPane = new JScrollPane(BillTable);
        this.add(scrollPane);
        BillTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMenu(e);
            }
        });
    }
    //自定义方法-填充订单数据
    public void fillBill(){
        List<Bill> list = service.findAllBill();
        //设置表格的行列
        Object[][] cells = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            Bill bill = list.get(i);
            cells[i][0] = bill.getId();
            cells[i][1] = bill.getBillCode();
            cells[i][2] = bill.getProductName();
            cells[i][3] = bill.getProviderId();
            cells[i][4] = bill.getTotalPrice();
            cells[i][5] = bill.getIsPayment();
            cells[i][6] = bill.getCreationDate();
        }
        String [] header = {"序号","订单编码","供应商","供应商编码","订单金额","是否付款","创建时间"};
        DefaultTableModel model = new DefaultTableModel(cells,header);
        BillTable.setModel(model);
    }
    //自定义方法：添加菜单
    public void addMenu(MouseEvent e){
        popupMenu = new JPopupMenu();
        delMenu = new JMenuItem("删除");
        modifyMenu = new JMenuItem("修改");
        detailMenu = new JMenuItem("查看详情");
        popupMenu.add(delMenu);
        popupMenu.add(modifyMenu);
        popupMenu.add(detailMenu);
        //在指定位置显示菜单
        popupMenu.show(e.getComponent(),e.getX(),e.getY());
        //删除事件
        delMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取选中行
                int index = BillTable.getSelectedRow();
                int id = Integer.parseInt(BillTable.getValueAt(index,0).toString());
                int count = service.delBill(id);
                if (count!=0){
                    JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        //修改开始
        modifyMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openModify();
            }
        });
        //修改结束
        //查看订单详情
        detailMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDetail();
            }
        });
    }
    //自定义方法
    public void openModify(){
        int index= BillTable.getSelectedRow();
        int id = Integer.parseInt(BillTable.getValueAt(index,0).toString());
        ToolUtil.id=id;
        BillModifyFrm frm = new BillModifyFrm();
        frm.billFindFrm=this;
        frm.setVisible(true);
    }
    public void openDetail(){
        int index= BillTable.getSelectedRow();
        int id = Integer.parseInt(BillTable.getValueAt(index,0).toString());
        ToolUtil.id = id;
        BillDetailFrm frm = new BillDetailFrm();
        frm.setVisible(true);
    }
}
