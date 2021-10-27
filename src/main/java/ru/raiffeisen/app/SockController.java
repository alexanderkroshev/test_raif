package ru.raiffeisen.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SockController {

    private final SockService sockService;

    @Autowired
    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("/income")
    public void saveIncome(@RequestParam("color") String color,
                           @RequestParam("quantity")  int quantity,
                           @RequestParam("cottonPart")  int cottonPart) {
        save(color, quantity, cottonPart);
    }

    @PostMapping("/outcome")
    public void saveOutcome(@RequestParam("color") String color,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("cottonPart") int cottonPart) {
        int negativeQuantity = quantity * (-1);
        save(color, negativeQuantity, cottonPart);
    }

    private void save(String color, int quantity, int cottonPart) {
        String colorLowerCase = color.toLowerCase();
        Sock sock = new Sock();
        sock.setColor(colorLowerCase);
        sock.setCottonPart(cottonPart);
        sock.setQuantity(quantity);
        sockService.save(sock);
    }

    @GetMapping()
    public Integer getRemainingSocksAmount(@RequestParam("color") String color,
                                           @RequestParam("cottonPart") int cottonPart,
                                           @RequestParam("operation") ComparativeOperator operator) {
                String colorLowerCase = color.toLowerCase();
        return sockService.findSum(colorLowerCase, cottonPart, operator);
    }
}





