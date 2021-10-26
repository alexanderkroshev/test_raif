package socks.demo.sock;


import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;


@Entity
@Data
public class Sock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private int cottonPart;

    private int quantity;


}
