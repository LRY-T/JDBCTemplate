package com.dlkj.shop.dao;
import com.dlkj.shop.pojo.Bill;
import java.util.List;
public interface BillDao {
    public int addBill(Bill bill);//增加方法
    public int delBill(int id);//删除方法
    public int modifyBill(Bill bill);//修改方法
    public Bill findOneBill(int id);//查询一条数据
    public List<Bill> findAllBill();//查询多条数据
}
