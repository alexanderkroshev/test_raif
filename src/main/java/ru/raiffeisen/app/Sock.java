package ru.raiffeisen.app;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



@Entity
@Data
public class Sock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    @Min(1)
    @Max(100)
    private int cottonPart;

    private int quantity;


}
