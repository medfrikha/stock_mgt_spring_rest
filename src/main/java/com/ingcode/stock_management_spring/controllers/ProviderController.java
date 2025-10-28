package com.ingcode.stock_management_spring.controllers;

import com.ingcode.stock_management_spring.entities.Provider;
import com.ingcode.stock_management_spring.services.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
    @GetMapping("/")
    List<Provider> getAllProviders(){
        return providerService.listProviders();
    }

    @PostMapping("/")
    Provider saveProvider(@RequestBody Provider provider){
        return providerService.saveProvider(provider);
    }
    @GetMapping("/{id}")
    Provider getProvider(@PathVariable long id){
        return providerService.getProvider(id);
    }

}
