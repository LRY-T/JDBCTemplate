package com.shop.service.Impl;

import com.shop.dao.ProviderDao;
import com.shop.dao.impl.ProviderDaoImpl;
import com.shop.pojo.Provider;
import com.shop.service.ProviderService;

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
