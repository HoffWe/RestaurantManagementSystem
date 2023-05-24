package mtgroup.restaurantmanagementsystem.controller;

import mtgroup.restaurantmanagementsystem.dto.IngredientDto;
import mtgroup.restaurantmanagementsystem.mapper.IngredientDtoMapper;
import mtgroup.restaurantmanagementsystem.model.Ingredient;
import mtgroup.restaurantmanagementsystem.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/ingredient/")
public class IngredientController {


    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients(){
        return ingredientService.getAllIngredients().stream()
                .map(IngredientDtoMapper::mapIngredientToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<IngredientDto> getIngredientsById(@PathVariable Long id){
        final Optional<Ingredient> optionalIngredient = ingredientService.getIngredientsById(id);
        return optionalIngredient.map(ingredient -> ResponseEntity.ok(IngredientDtoMapper.mapIngredientToDto(ingredient)))
                .orElseGet(()->ResponseEntity.of(Optional.empty()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient addNewIngredient(@RequestBody IngredientDto ingredientDto){
        return ingredientService.addNewIngredient(ingredientDto);
    }

    @PatchMapping("edit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ingredient updateIngredient(@PathVariable Long id,@RequestBody IngredientDto ingredientDto){
        return ingredientService.updateIngredient(id,ingredientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
    }
}
