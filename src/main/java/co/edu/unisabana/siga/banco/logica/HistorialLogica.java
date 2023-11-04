package co.edu.unisabana.siga.banco.logica;

import co.edu.unisabana.siga.banco.bd.Historial;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistorialLogica {

    private HistorialRepository historialRepository;

    public HistorialLogica(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<Historial> verHistorial(int numeroCuenta) {
        return historialRepository.getHistorialByCuenta(numeroCuenta);
    }
}
