package br.com.syncer.things.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class SelectOneView {
    private String option;   
    private Musica musica; 
    private List<Musica> musicas;
     
    @ManagedProperty("#{musicaController}")
    private MusicaController musicaController;
     
    @PostConstruct
    public void init() {
        musicas = musicaController.getMusicas();
       
    }
 
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public Musica getMusica() {
        return musica;
    }
 
    public void setMusica(Musica musica) {
        this.musica = musica;
    }
 
    public List<Musica> getMusicas() {
        return musicas;
    }
 
    public void setMusicaController(MusicaController musicaController) {
        this.musicaController = musicaController;
    }
}
