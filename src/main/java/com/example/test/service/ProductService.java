package com.example.test.service;

import com.example.test.dto.RequestDto1;
import com.example.test.dto.RequestProductDto;
import com.example.test.dto.paginated.PaginatedProductDto;

public interface ProductService {
    String saveProduct(RequestProductDto dto);

    boolean updateProduct(RequestProductDto dto);

    PaginatedProductDto getAllProduct(int page, int size);
}
