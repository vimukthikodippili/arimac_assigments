package com.example.test.service.impl;

import com.example.test.dto.ProductDto;
import com.example.test.dto.RequestDto1;
import com.example.test.dto.RequestProductDto;
import com.example.test.dto.paginated.PaginatedProductDto;
import com.example.test.entiity.Products;
import com.example.test.exception.NotFoundException;
import com.example.test.repositry.ProductRepo;
import com.example.test.service.ProductService;
import com.example.test.util.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public String saveProduct(RequestProductDto dto) {
        int totalprice=dto.getPrice()+dto.getTax();
        System.out.println(totalprice);
        ProductDto productDto =new ProductDto(dto.getId(),
                dto.getName(),
                dto.getDate(),
                dto.isPromoted(),
                dto.getTax(),
                totalprice

        );
        if (!productRepo.existsById(productDto.getId())) {
            System.out.println(productDto);
            return productRepo.save(productMapper.toProduct(productDto)).getId();

        } else {
            throw new NotFoundException("Already Exists");
        }
    }

    @Override
    public boolean updateProduct(RequestProductDto dto) {
        Optional<Products> products = productRepo.findById(dto.getId());
        if (products.isPresent()) {

            products.get().setName(dto.getName());
            products.get().setDate(dto.getDate());
            products.get().setPromoted(dto.isPromoted());
            products.get().setTax(dto.getTax());
            products.get().setPrice(dto.getPrice());


            productRepo.save(products.get());
            return true;

        } else {
            throw new NotFoundException("Attendance is not available!!!");

        }
    }

    @Override
    public PaginatedProductDto getAllProduct(int page, int size) {
        return new PaginatedProductDto(
                productMapper.pageToProductDto(
                        productRepo.getAllBy(PageRequest.of(page, size))),

                   productRepo.countAllBy());
    }


}
