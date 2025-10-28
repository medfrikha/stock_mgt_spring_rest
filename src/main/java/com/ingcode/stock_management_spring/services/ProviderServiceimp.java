package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Provider;
import com.ingcode.stock_management_spring.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceimp implements  ProviderService {
    private ProviderRepository providerRepository;

    public ProviderServiceimp(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> listProviders() {
       return (List<Provider>) this.providerRepository.findAll();
    }

    @Override
    public Provider getProvider(long id) {
        return this.providerRepository.findById(id).get() ;
    }

    @Override
    public Provider saveProvider(Provider provider) {
        return this.providerRepository.save(provider);
    }

    @Override
    public Provider updateProvider(Provider provider) {
        return null;
    }

    @Override
    public Provider deleteProvider(long id) {
        return null ;
    }
}
