package com.shop.service;

import com.shop.pojo.Provider;

import java.util.List;

public interface ProviderService {
    public int addProvider(Provider pro);//增加方法
    public int delProvider(int id);//删除方法
    public int modifyProvider(Provider pro);//修改方法
    public Provider findOneProvider(int id);//查询单条数据
    public List<Provider> findAllProvider();//查询多条数据
}
