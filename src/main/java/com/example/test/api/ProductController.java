package com.example.test.api;

import com.example.test.dto.RequestDto1;
import com.example.test.dto.RequestProductDto;
import com.example.test.dto.paginated.PaginatedProductDto;
import com.example.test.service.ProductService;
import com.example.test.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("api/vi/product")
public class ProductController {
@Autowired
    private ProductService productService;

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody RequestProductDto dto){
        String id=productService.saveProduct(dto);

        return new ResponseEntity(new StandardResponse(201,"success",id), HttpStatus.CREATED);

    }
    @PutMapping
    public ResponseEntity<StandardResponse> updateProduct(@RequestBody RequestProductDto dto){
        boolean id =productService.updateProduct(dto);

        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"success",id),HttpStatus.CREATED);


    }
    @GetMapping(path = {"main/visco/get-all-customer-review-and-product-name"},
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllProduct(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size)
    {
        PaginatedProductDto paginatedProductDto=productService.getAllProduct(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success!!!", paginatedProductDto),
                HttpStatus.OK);
    }


}
