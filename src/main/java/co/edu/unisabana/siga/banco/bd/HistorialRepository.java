package co.edu.unisabana.siga.banco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {

    @Query (value = "SELECT * FROM historial WHERE numeroCuenta = :numeroCuenta", nativeQuery = true)
    List<Historial> getHistorialByCuenta(@Param("numeroCuenta") int numeroCuenta);
}
