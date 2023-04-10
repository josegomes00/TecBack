package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Episodios;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.EpisodiosRepository;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EpisodiosService {

    @Autowired
    private EpisodiosRepository repository;

    @Autowired
    private SerieRepository serieRepository;

    public Episodios salvar(Episodios episodios){

        return repository.save(episodios);
    }

    public Episodios alterar(Episodios episodio){
        if(Objects.nonNull(episodio.getId())){
            episodio=repository.save(episodio);
        }else{
            throw new NotFoundException();
        }
        return episodio;
    }

    public List<Episodios> buscarTodas(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            log.info("Erro ao tentar excluir: {}", e);
            return false;
        }
        return true;
    }

    public Episodios consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public Episodios adicionarEpisodioEmSerie(Integer serieId, Episodios episodio) {
        Serie serie = serieRepository.findById(serieId)
                .orElseThrow(() -> new EntityNotFoundException("Série não encontrada com id: " + serieId));
        episodio.setSerie(serie);
        return repository.save(episodio);

    }

}
