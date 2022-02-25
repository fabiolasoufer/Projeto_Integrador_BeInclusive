package org.beinclusive.beinclusive.repository;

import java.util.List;
import org.beinclusive.beinclusive.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	public List<Tema> findAllByAcessoAzulContainingIgnoreCase(String acessoAzul);
	public List<Tema> findAllByAcessoVerdeContainingIgnoreCase(String acessoVerde);
	public List<Tema> findAllByAcessoAmareloContainingIgnoreCase(String acessoAmarelo);

}
