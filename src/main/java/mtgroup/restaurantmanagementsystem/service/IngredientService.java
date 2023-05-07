package mtgroup.restaurantmanagementsystem.service;

import mtgroup.restaurantmanagementsystem.dto.IngredientDto;
import mtgroup.restaurantmanagementsystem.model.Ingredient;
import mtgroup.restaurantmanagementsystem.repository.IngredientRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }


    public Optional<Ingredient> getIngredientsById(Long id) {
        return Optional.ofNullable(ingredientRepository.getIngredientsById()
                .orElseThrow(() -> new RuntimeException("Ingredients not found")));
    }

    public Ingredient addNewIngredient(IngredientDto ingredientDto){
        Ingredient ingredient = Ingredient.builder()
                .id(ingredientDto.id())
                .name(ingredientDto.name())
                .amount(ingredientDto.amount())
                .price(ingredientDto.price())
                .build();
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id,IngredientDto ingredientDto){
        Ingredient ingredient = ingredientRepository.getIngredientsById().get();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setAmount(ingredientDto.getAmount());
        ingredient.setPrice(ingredientDto.getPrice());
        return ingredientRepository.save(ingredient);
    }
    public void deleteIngredient(Long id){
        ingredientRepository.deleteById(id);
    }

}
