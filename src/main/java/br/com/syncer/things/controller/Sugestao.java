package br.com.syncer.things.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="sugestao")
public class Sugestao {
private String nomeAutor;
public String getNomeAutor() {
	return nomeAutor;
}
public void setNomeAutor(String nomeAutor) {
	this.nomeAutor = nomeAutor;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String enviada() {
	return (nomeAutor == null && texto == null)? "Sugestão não enviada!": "Sugestão enviada com sucesso ";
}

private String texto;
public Sugestao(){
	
}
}
