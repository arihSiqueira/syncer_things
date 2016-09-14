package br.com.syncer.things.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="musica")
@SessionScoped
public class Musica {
String tituloMusica;
public String getTituloMusica() {
	return tituloMusica;
}
public void setTituloMusica(String tituloMusica) {
	this.tituloMusica = tituloMusica;
}
public String getLetraMusica() {
	return letraMusica;
}
public void setLetraMusica(String letraMusica) {
	this.letraMusica = letraMusica;
}
public String getCompositorMusica() {
	return compositorMusica;
}
public void setCompositorMusica(String compositorMusica) {
	this.compositorMusica = compositorMusica;
}
public String getBanda() {
	return banda;
}
public void setBanda(String banda) {
	this.banda = banda;
}
String letraMusica;
String compositorMusica;
String banda;
public Musica(){
	
}

}
