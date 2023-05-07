package mtgroup.restaurantmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Builder
public record WorkerDto(Long id, String name, String lastName, LocalDate dateOfBirth, String position, BigDecimal salary, String photoUrl) {
    public WorkerDto {
        Objects.requireNonNull(name,"You have to have first name");
        Objects.requireNonNull(lastName,"You have to have lastname");
    }
}
