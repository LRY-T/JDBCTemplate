package com.shop.dao.impl;
import com.shop.dao.BillDao;
import com.shop.pojo.Bill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BillDaoImpl extends BaseDao implements BillDao {
    @Override
    public int addBill(Bill bill) {
        String sql="insert into smbms_bill(billCode,productDesc,productUnit,productCount,totalPrice,providerId,isPayment,createdBy,creationDate) values(?,?,?,?,?,?,?,?,now())";
        Object[] params = {bill.getBillCode(),bill.getProductDesc(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getProviderId(),bill.getIsPayment(),bill.getCreatedBy()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int delBill(int id) {
        String sql="delete from smbms_bill where id=?";
        Object[] params = {id};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int modifyBill(Bill bill) {
        String sql="update smbms_bill set productName=?,productUnit=?,productCount=?,totalPrice=?,providerId=?,isPayment=?,modifyBy=?,modifyDate=now() where id=?";
        Object[] params = {bill.getProductName(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getProviderId(),bill.getIsPayment(),bill.getModifyBy(),bill.getId()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Bill findOneBill(int id) {
        String sql = "select * from smbms_bill where id=?";
        Object[] params = {id};
        res=super.executeQuery(sql,params);
        Bill bill = null;
        try {
            if (res.next()){
                bill = new Bill();
                bill.setId(res.getInt("Id"));
                bill.setBillCode(res.getString("BillCode"));
                bill.setProductName(res.getString("ProductName"));
                bill.setProductDesc(res.getString("ProductDesc"));
                bill.setProductUnit(res.getString("ProductUnit"));
                bill.setProductCount(res.getDouble("ProductCount"));
                bill.setTotalPrice(res.getDouble("TotalPrice"));
                bill.setIsPayment(res.getInt("IsPayment"));
                bill.setCreatedBy(res.getInt("CreatedBy"));
                bill.setCreationDate(res.getString("CreationDate"));
                bill.setProviderId(res.getInt("ProviderId"));
            }
            return bill;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
    }

    @Override
    public List<Bill> findAllBill() {
        List<Bill> blist = new ArrayList<>();
        String sql = "select * from smbms_bill";
        Object[] params = null;
        res = super.executeQuery(sql,params);
        Bill bill = null;
        try {
            while (res.next()){
                bill = new Bill();
                bill.setId(res.getInt("Id"));
                bill.setBillCode(res.getString("BillCode"));
                bill.setProductName(res.getString("ProductName"));
                bill.setProductDesc(res.getString("ProductDesc"));
                bill.setProductUnit(res.getString("ProductUnit"));
                bill.setProductCount(res.getDouble("ProductCount"));
                bill.setTotalPrice(res.getDouble("TotalPrice"));
                bill.setIsPayment(res.getInt("IsPayment"));
                bill.setCreatedBy(res.getInt("CreatedBy"));
                bill.setCreationDate(res.getString("CreationDate"));
                bill.setProviderId(res.getInt("ProviderId"));
                blist.add(bill);
            }
            return blist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
    }
}
