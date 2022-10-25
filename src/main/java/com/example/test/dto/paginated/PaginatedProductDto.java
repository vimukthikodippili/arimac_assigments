package com.example.test.dto.paginated;

import com.example.test.dto.response.ResponseProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedProductDto {
    private List<ResponseProductDto> list;
    private long count;
}
