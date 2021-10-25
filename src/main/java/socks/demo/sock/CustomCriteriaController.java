package socks.demo.sock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomCriteriaController {

    private final CustomCriteria customCriteria;

    @Autowired
    public CustomCriteriaController(CustomCriteria customCriteria) {
        this.customCriteria = customCriteria;
    }

    @GetMapping("test")
    public List<Sock> findByColorAndCottonPart(@RequestParam("color") String color,
                                               @RequestParam("cottonPart") int cottonPart) {
        return customCriteria.amountOfSocksByCriteria(color, cottonPart);
    }
}

//@RequestParam("operation") String operation,
//@RequestParam("cottonPart") Integer cottonPart