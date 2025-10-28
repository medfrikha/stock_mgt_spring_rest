package com.ingcode.stock_management_spring.repositories;

import com.ingcode.stock_management_spring.entities.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

}
