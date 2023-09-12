package co.edu.unisabana.siga.banco.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query (value = "SELECT * FROM cuenta WHERE id_usuario = :id_usuario", nativeQuery = true)
    List<Cuenta> getAccountById(@Param ("id_usuario")int id_usuario);
    @Query (value = "SELECT sum(saldo) FROM cuenta WHERE id_usuario = :id_usuario", nativeQuery = true)
    BigDecimal getTotalBalance(@Param("id_usuario") int id_usuario);

    @Query (value = "SELECT sum(saldo) FROM cuenta WHERE id_usuario = :id_usuario AND tipo_cuenta = 1", nativeQuery = true)
    BigDecimal getBalanceAhorros(@Param("id_usuario") int id_usuario);

    @Query (value = "SELECT sum(saldo) FROM cuenta WHERE id_usuario = :id_usuario AND tipo_cuenta = 0", nativeQuery = true)
    BigDecimal getBalanceCorriente(@Param("id_usuario") int id_usuario);

    @Query (value = "SELECT sum(saldo) FROM cuenta WHERE id_usuario = :id_usuario AND tipo_cuenta = 2", nativeQuery = true)
    BigDecimal getBalanceCredito(@Param("id_usuario") int id_usuario);

    @Query (value = "SELECT saldo FROM cuenta WHERE numero_cuenta = :numero_cuenta", nativeQuery = true)
    double getBalanceCuenta(@Param("numero_cuenta") int numero_cuenta);

    @Modifying
    @Query (value = "UPDATE cuenta SET saldo = :new_balance WHERE numero_cuenta = :id_usuario", nativeQuery = true)
    @Transactional
    void cambiarBalanceCuentaById(@Param("new_balance") double new_balance, @Param("id_usuario") int id_usuario);


}

