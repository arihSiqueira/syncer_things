package br.com.syncer.things.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="musicaController", eager = true)
@SessionScoped
public class MusicaController implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String tituloMusica;
public String getTituloMusica() {
	return tituloMusica;
}
public void setTituloMusica(String tituloMusica) {
	this.tituloMusica = tituloMusica;
}
public int getIdMusica() {
	return idMusica;
}
public void setIdMusica(int idMusica) {
	this.idMusica = idMusica;
}
private int idMusica;
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
	String tituloMusica = getTituloMusica();
	int id = getIdMusica();
	if (tituloMusica == null)
		tituloMusica = "No";
	id = 0;
	musicas.add(new Musica(id,tituloMusica));
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
	musicas.add(musica);
	musica = null;
}

}
