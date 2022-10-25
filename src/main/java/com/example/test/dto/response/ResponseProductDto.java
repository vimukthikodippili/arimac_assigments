package com.example.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {
    private String name;
    private Date date;
    private int price;
}
