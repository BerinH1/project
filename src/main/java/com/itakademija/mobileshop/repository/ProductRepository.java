package com.itakademija.mobileshop.repository;

import com.itakademija.mobileshop.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByName(String name);

}
