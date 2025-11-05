package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Provider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProviderService {

    List<Provider> listProviders();
    Provider getProvider(long id);
    Provider saveProvider(Provider provider);
    Provider updateProvider(long id,Provider provider);
    ResponseEntity<?> deleteProvider(long id);
}
