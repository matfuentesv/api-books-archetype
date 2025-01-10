package cl.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DefaultController {

    @GetMapping("/mensaje")
    public String mensaje() {

        System.out.println("Backend llamado");
        return "{\"mensaje\": \"Integración OK al backend\"}";
    }
}
