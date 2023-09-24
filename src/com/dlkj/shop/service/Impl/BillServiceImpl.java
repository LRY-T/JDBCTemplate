package com.dlkj.shop.service.Impl;

import com.dlkj.shop.dao.BillDao;
import com.dlkj.shop.dao.impl.BillDaoImpl;
import com.dlkj.shop.pojo.Bill;
import com.dlkj.shop.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {
    BillDao billDao = new BillDaoImpl();
    @Override
    public int addBill(Bill bill) {
        return billDao.addBill(bill);
    }

    @Override
    public int delBill(int id) {
        return billDao.delBill(id);
    }

    @Override
    public int modifyBill(Bill bill) {
        return billDao.modifyBill(bill);
    }

    @Override
    public Bill findOneBill(int id) {
        return billDao.findOneBill(id);
    }

    @Override
    public List<Bill> findAllBill() {
        return billDao.findAllBill();
    }
}
