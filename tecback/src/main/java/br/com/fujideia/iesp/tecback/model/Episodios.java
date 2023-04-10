package br.com.fujideia.iesp.tecback.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_episodios")
public class Episodios {

    @Id
    private Integer id;

    private String titulo;
    private String tempoDuracao;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
}
