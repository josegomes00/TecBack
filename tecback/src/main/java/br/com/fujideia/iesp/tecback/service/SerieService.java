package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Episodios;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public Serie salvar(Serie serie){

        return repository.save(serie);
    }

    public Serie alterar(Serie serie){
        if(Objects.nonNull(serie.getId())){
            serie=repository.save(serie);
        }else{
            throw new NotFoundException();
        }
        return serie;
    }

    public List<Serie> buscarTodas(){
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

    public Serie consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }


    public Serie addEp(Integer serieId, Episodios episodio){
        Serie serie = consultarPorId(serieId);
        episodio.setSerie(serie);
        serie.getEpisodios().add(episodio);

        return repository.save(serie);

    }

}
