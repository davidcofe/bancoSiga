package co.edu.unisabana.siga.banco.controller;

import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.logica.HistorialLogica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistorialController {

    private HistorialLogica logica;

    public HistorialController(HistorialLogica logica) {
        this.logica = logica;
    }

    @GetMapping(path = "/historial/{cuenta}")
    public List<Historial> verHistorial(@PathVariable int cuenta) {
        try {
            return logica.verHistorial(cuenta);
        } catch (IllegalArgumentException e) {
            return (List<Historial>) e;
        }
    }
}
