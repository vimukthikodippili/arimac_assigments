package com.example.test.repositry;

import com.example.test.entiity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ProductRepo extends JpaRepository<Products, String> {

Page<Products>  getAllBy(Pageable pageable);
long countAllBy();
}
