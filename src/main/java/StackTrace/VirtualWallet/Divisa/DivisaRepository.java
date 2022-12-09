package StackTrace.VirtualWallet.Divisa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisaRepository extends JpaRepository<Divisa,Integer> {
    List<Divisa> findByNombre(String nombre);
}
