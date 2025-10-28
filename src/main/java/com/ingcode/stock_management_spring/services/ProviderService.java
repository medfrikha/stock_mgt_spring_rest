package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> listProviders();
    Provider getProvider(long id);
    Provider saveProvider(Provider provider);
    Provider updateProvider(Provider provider);
    Provider deleteProvider(long id);
}
