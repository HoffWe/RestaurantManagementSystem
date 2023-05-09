package mtgroup.restaurantmanagementsystem.mapper;

import mtgroup.restaurantmanagementsystem.dto.IngredientDto;
import mtgroup.restaurantmanagementsystem.model.Ingredient;

import java.util.Optional;

public class IngredientDtoMapper {

    public static IngredientDto mapIngredientToDto(Ingredient ingredient){
        return IngredientDto.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .price(ingredient.getPrice())
                .amount(ingredient.getAmount())
                .build();
    }
}
