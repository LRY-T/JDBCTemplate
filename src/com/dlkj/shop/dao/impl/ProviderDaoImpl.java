package com.dlkj.shop.dao.impl;
import com.dlkj.shop.pojo.Provider;
import com.dlkj.shop.dao.ProviderDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProviderDaoImpl extends BaseDao implements ProviderDao {
    @Override
    public int addProvider(Provider pro) {
        String sql="insert into smbms_provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate) values(?,?,?,?,?,?,?,?,now())";
        Object[] params = {pro.getProCode(),pro.getProName(),pro.getProDesc(),pro.getProContact(),pro.getProPhone(),pro.getProAddress(),pro.getProFax(),pro.getCreatedBy()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int delProvider(int id) {
        String sql="delete from smbms_provider where id=?";
        Object[] params = {id};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int modifyProvider(Provider pro) {
        String sql="update smbms_provider set proName=?,proDesc=?,proContact=?,ProPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=now() where id=?";
        Object[] params = {pro.getProName(),pro.getProDesc(),pro.getProContact(),pro.getProPhone(),pro.getProAddress(),pro.getProFax(),pro.getModifyBy(),pro.getId()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Provider findOneProvider(int id) {
        String sql = "select * from smbms_provider where id=?";
        Object[] params = {id};
        res=super.executeQuery(sql,params);
        Provider provider = null;
        try {
            if (res.next()){
                provider = new Provider();
                provider.setId(res.getInt("id"));
                provider.setProCode(res.getString("proCode"));
                provider.setProName(res.getString("proName"));
                provider.setProDesc(res.getString("proDesc"));
                provider.setProContact(res.getString("proContact"));
                provider.setProPhone(res.getString("proPhone"));
                provider.setProAddress(res.getString("proAddress"));
                provider.setProFax(res.getString("proFax"));
                provider.setCreatedBy(res.getInt("createdBy"));
                provider.setCreationDate(res.getString("creationDate"));
            }
            return provider;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
    }

    @Override
    public List<Provider> findAllProvider() {
        List<Provider> plist = new ArrayList<>();
        String sql = "select * from smbms_provider";
        Object[] params = null;
        res = super.executeQuery(sql,params);
        Provider pro = null;
        try {
            while (res.next()){
                pro = new Provider();
                pro.setId(res.getInt("id"));
                pro.setProCode(res.getString("proCode"));
                pro.setProName(res.getString("proName"));
                pro.setProDesc(res.getString("proDesc"));
                pro.setProContact(res.getString("proContact"));
                pro.setProPhone(res.getString("proPhone"));
                pro.setProAddress(res.getString("proAddress"));
                pro.setProFax(res.getString("proFax"));
                pro.setCreatedBy(res.getInt("createdBy"));
                pro.setCreationDate(res.getString("creationDate"));
                plist.add(pro);
            }
            return plist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
    }
}
