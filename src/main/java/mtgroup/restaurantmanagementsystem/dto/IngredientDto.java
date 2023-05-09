package mtgroup.restaurantmanagementsystem.dto;

import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record IngredientDto(Long id, String name, BigDecimal price, Double amount) {

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getAmount() {
        return amount;
    }
}
