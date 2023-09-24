package com.dlkj.shop.service.Impl;

import com.dlkj.shop.dao.ProviderDao;
import com.dlkj.shop.dao.impl.ProviderDaoImpl;
import com.dlkj.shop.pojo.Provider;
import com.dlkj.shop.service.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {
    ProviderDao providerDao = new ProviderDaoImpl();
    @Override
    public int addProvider(Provider pro) {
        return providerDao.addProvider(pro);
    }

    @Override
    public int delProvider(int id) {
        return providerDao.delProvider(id);
    }

    @Override
    public int modifyProvider(Provider pro) {
        return providerDao.modifyProvider(pro);
    }

    @Override
    public Provider findOneProvider(int id) {
        return providerDao.findOneProvider(id);
    }

    @Override
    public List<Provider> findAllProvider() {
        return providerDao.findAllProvider();
    }
}
