package com.example.demo.data.dto;



import com.example.demo.data.entity.Product;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//@RedisHash(value = "product", timeToLive = 60)
public class ProductDto {

    //@Size(min = 8, max = 8) // abcdefg
    @NotNull
    private String productId;

    @NotNull
    @Id
    private String productName;

    @NotNull
    @Min(value = 500) // 500원에서
    @Max(value = 3000000) //3000000
    private int productPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 9999)
    private int productStock;

    public Product toEntity(){
        return Product.builder()
                .id(productId)
                .name(productName)
                .price(productPrice)
                .stock(productStock)
                .build();
    }

}