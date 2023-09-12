package co.edu.unisabana.siga.banco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente WHERE codigo = :codigo", nativeQuery = true)
    List<Cliente> getAccountById(@Param("codigo")int codigo);

}
