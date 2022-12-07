package StackTrace.VirtualWallet.Divisa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisaRepository extends JpaRepository<Divisa,Integer> {
    
}
