package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Provider;
import com.ingcode.stock_management_spring.exceptions.ResourceNotFoundException;
import com.ingcode.stock_management_spring.repositories.ProviderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImp implements  ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderServiceImp(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> listProviders() {
        return (List<Provider>) this.providerRepository.findAll();
    }

    @Override
    public Provider getProvider(long id) {
        return this.providerRepository.findById(id).get();
    }

    @Override
    public Provider saveProvider(Provider provider) {
        return this.providerRepository.save(provider);
    }

    @Override
    public Provider updateProvider(long id,Provider provider) {
        Provider existingProvider = this.providerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Provider not found with id: " + id));
        existingProvider.setName(provider.getName());
        existingProvider.setEmail(provider.getEmail());
        existingProvider.setAddress(provider.getAddress());
        existingProvider.setPhone(provider.getPhone());

        return this.providerRepository.save(existingProvider);
    }

    @Override
    public ResponseEntity<?> deleteProvider(long id) {
        Provider provider = this.providerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider not found with id: " + id));
        this.providerRepository.delete(provider);
        return ResponseEntity.ok().build();
    }

}