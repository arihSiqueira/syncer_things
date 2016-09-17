package br.com.syncer.things.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="musicaController", eager = true)
@ApplicationScoped
public class MusicaController {

private Musica musica;
public Musica getMusica() {
	return musica;
}
public void setMusica(Musica musica) {
	this.musica = musica;
}
private List<Musica> musicas;
public List<Musica> getMusicas() {
	return musicas;
}
public void setMusicas(List<Musica> musicas) {
	this.musicas = musicas;
}
public void addMusica(){
	System.out.println(musica.getId());
	System.out.println(musica.getTituloMusica());
	musicas.add(musica);
	musica = null;
}
@PostConstruct
public void init(){
	musicas = new ArrayList<Musica>();
	musica = new Musica();
	musica.setTituloMusica("Sayonara");
	musica.setCompositorMusica("Alexander");
	musica.setLetraMusica("kkk");
		musica.setBanda("alison");
	musicas.add(new Musica(0,"The Phantom of the Opera"));
	musicas.add(new Musica(1,"Hello"));
	//musicas.add(new Musica());
	musicas.add(musica);
	musica = null;
}

}
