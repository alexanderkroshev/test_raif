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

//    @GetMapping()
//    public List findByColorAndCottonPart(@RequestParam("color") String color
//                                        //@RequestParam("operation") String operation,
//                                        //@RequestParam("cottonPart") Integer cottonPart
//    ) {
//        return  sockService.findByCriteria(color);
////        if (operation.equals("moreThan"))
////            return sockService.findSocksByColorAndCottonPartMoreThan(color, cottonPart);
////        else if (operation.equals("lessThan"))
////            return sockService.findSocksByColorAndCottonPartLessThan(color, cottonPart);
////        else //if (operation.equals("equal"))
////            return sockService.findSocksByColorAndCottonPartEqual(color, cottonPart);
////        else
////            return
//    }


}
