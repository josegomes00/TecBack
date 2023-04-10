package br.com.fujideia.iesp.tecback.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "tb_serie")
public class Serie {

    @Id
    private Integer id;

    private String nome;
    private Integer classificacao;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;


    @OneToMany(mappedBy = "serie")
    private List<Episodios> episodios = new ArrayList<>();
}
