package socks.demo.sock;

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
    public void saveIncome(@ModelAttribute Sock sock) {
        sockService.save(sock);
    }

    @PostMapping("/outcome")
    public void saveIncome(@RequestParam("color") String color,
                           @RequestParam("quantity") int quantity,
                           @RequestParam("cottonPart") int cottonPart) {
        Sock sock = new Sock();
        sock.setColor(color);
        sock.setCottonPart(cottonPart);
        sock.setQuantity(quantity * (-1));
        sockService.save(sock);
    }

    @GetMapping()
    public Integer getTotalResidue(@RequestParam("color") String color,
                                   @RequestParam("cottonPart") int cottonPart,
                                   @RequestParam("operation") ComparativeOperator operator) {
        return sockService.findSum(color, cottonPart, operator);
    }
}





