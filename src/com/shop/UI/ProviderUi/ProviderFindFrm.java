package com.shop.UI.ProviderUi;

import com.shop.UI.Tool.ToolUtil;
import com.shop.pojo.Provider;
import com.shop.service.Impl.ProviderServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProviderFindFrm extends JFrame {
    private JTable ProviderTable;
    private ProviderServiceImpl service;
    private JScrollPane scrollPane;
    private JPopupMenu popupMenu;
    private JMenuItem delMenu,modifyMenu,detailMenu;

    public ProviderFindFrm() throws HeadlessException {
        setTitle("查看供应商");
        setBounds(0,0,1100,1100);
        setLocationRelativeTo(null);
        //添加表格控件
        service = new ProviderServiceImpl();
        ProviderTable =  new JTable();
        //填充数据
        fillProvider();
        scrollPane = new JScrollPane(ProviderTable);
        this.add(scrollPane);
        ProviderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMenu(e);
            }
        });
    }
    //自定义方法-填充供应商数据
    public void fillProvider(){
        List<Provider> list = service.findAllProvider();
        //设置表格的行列
        Object[][] cells = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            Provider provider = list.get(i);
            cells[i][0] = provider.getId();
            cells[i][1] = provider.getProCode();
            cells[i][2] = provider.getProName();
            cells[i][3] = provider.getProContact();
            cells[i][4] = provider.getProPhone();
            cells[i][5] = provider.getProFax();
            cells[i][6] = provider.getCreationDate();
        }
        String [] header = {"序号","供应商编码","供应商名称","联系人","联系电话","传真","创建时间"};
        DefaultTableModel model = new DefaultTableModel(cells,header);
        ProviderTable.setModel(model);
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
        delMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = ProviderTable.getSelectedRow();
                int id = Integer.parseInt(ProviderTable.getValueAt(index,0).toString());
                int count = service.delProvider(id);
                if (count!=0){
                    JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        modifyMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openModify();
            }
        });
        detailMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDetail();
            }
        });
    }
    public void openModify(){
        int index= ProviderTable.getSelectedRow();
        int id = Integer.parseInt(ProviderTable.getValueAt(index,0).toString());
        ToolUtil.id = id;
        ProviderModifyFrm frm = new ProviderModifyFrm();
        frm.providerfindfrm = this;
        frm.setVisible(true);
    }
    public void openDetail(){
        int index = ProviderTable.getSelectedRow();
        int id = Integer.parseInt(ProviderTable.getValueAt(index,0).toString());
        ToolUtil.id = id;
        ProviderDetailFrm frm = new ProviderDetailFrm();
        frm.setVisible(true);
    }
}
