package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Episodios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodiosRepository extends JpaRepository<Episodios, Integer> {
}
