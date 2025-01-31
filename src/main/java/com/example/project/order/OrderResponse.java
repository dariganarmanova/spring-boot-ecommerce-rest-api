package com.example.project.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String name; 
    private Integer user_id;
    private String username; 
    private Integer quantity;
    private Long Price;
}
