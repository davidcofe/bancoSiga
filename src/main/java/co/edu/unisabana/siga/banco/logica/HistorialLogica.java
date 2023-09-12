package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.Cuenta;
import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import co.edu.unisabana.siga.banco.controller.dto.HistorialDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialLogica {

    private HistorialRepository historialRepository;

    public HistorialLogica(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<Historial> verHistorial(int numero_cuenta) {
        return historialRepository.getHistorialByCuenta(numero_cuenta);
    }
}
