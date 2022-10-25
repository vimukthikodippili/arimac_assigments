package com.example.test.util.mapper;

import com.example.test.dto.ProductDto;
import com.example.test.dto.response.ResponseProductDto;
import com.example.test.entiity.Products;
import javafx.css.Styleable;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Products toProduct(ProductDto productDto);
    List<ResponseProductDto> pageToProductDto(Page<Products> products);






}
