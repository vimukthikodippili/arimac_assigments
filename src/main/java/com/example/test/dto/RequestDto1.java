package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto1 {
    private String name;
    private Date date;
    private boolean promoted;
    private int tax;
    private int price;
}
