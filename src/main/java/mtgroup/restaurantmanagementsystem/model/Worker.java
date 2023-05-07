package mtgroup.restaurantmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Worker extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name;
    private String lastName;
    private String position;
    private String photoUrl;
    private LocalDate dateOfBirth;
    private BigDecimal salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return getId().equals(worker.getId()) && getName().equals(worker.getName()) && getLastName().equals(worker.getLastName()) && getPosition().equals(worker.getPosition()) && getPhotoUrl().equals(worker.getPhotoUrl()) && getDateOfBirth().equals(worker.getDateOfBirth()) && getSalary().equals(worker.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getPosition(), getPhotoUrl(), getDateOfBirth(), getSalary());
    }
}
