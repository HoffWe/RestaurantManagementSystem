package mtgroup.restaurantmanagementsystem.controller;

import mtgroup.restaurantmanagementsystem.dto.IngredientDto;
import mtgroup.restaurantmanagementsystem.mapper.IngredientDtoMapper;
import mtgroup.restaurantmanagementsystem.model.Ingredient;
import mtgroup.restaurantmanagementsystem.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/ingredient")
public class IngredientController {


    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public ResponseEntity<IngredientDto> getAllIngredients(){
        final Optional<Ingredient> optionalIngredient = ingredientService.getAllIngredients();
        return optionalIngredient.map(ingredient -> ResponseEntity.ok(IngredientDtoMapper.mapIngredientToDto(ingredient)))
                .orElseGet(()->ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientDto> getIngredientsById(Long id){
        final Optional<Ingredient> optionalIngredient = ingredientService.getIngredientsById(id);
        return optionalIngredient.map(ingredient -> ResponseEntity.ok(IngredientDtoMapper.mapIngredientToDto(ingredient)))
                .orElseGet(()->ResponseEntity.of(Optional.empty()));
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient addNewIngredient(@RequestBody IngredientDto ingredientDto){
        return ingredientService.addNewIngredient(ingredientDto);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingredient updateIngredient(@PathVariable Long id,@RequestBody IngredientDto ingredientDto){
        return ingredientService.updateIngredient(id,ingredientDto);
    }

    @DeleteMapping
    public void deleteIngredient(@RequestParam Long id){
        ingredientService.deleteIngredient(id);
    }
}
