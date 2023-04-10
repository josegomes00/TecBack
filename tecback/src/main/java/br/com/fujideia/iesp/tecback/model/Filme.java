package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_filme")
public class Filme{

    @Id
    private Integer id;

    private String titulo;
    private LocalDate estreia;
    private String tempoDuracao;
    private Integer classificacao;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

}
