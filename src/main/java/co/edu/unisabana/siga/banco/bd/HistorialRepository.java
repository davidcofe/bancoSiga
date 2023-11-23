package co.edu.unisabana.siga.banco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {

    @Query (value = "SELECT * FROM historial WHERE numero_cuenta = :numero_cuenta", nativeQuery = true)
    List<Historial> getHistorialByCuenta(@Param("numero_cuenta") int numero_cuenta);
}
