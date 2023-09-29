package co.edu.unisabana.siga.banco.unit;

import co.edu.unisabana.siga.banco.bd.CuentaRepository;
import co.edu.unisabana.siga.banco.bd.HistorialRepository;
import co.edu.unisabana.siga.banco.logica.TransaccionLogica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransaccionLogicaTest {

    @Mock
    CuentaRepository cuentaRepository;
    @Mock
    HistorialRepository historialRepository;

    @InjectMocks
    TransaccionLogica transaccionLogica;


}