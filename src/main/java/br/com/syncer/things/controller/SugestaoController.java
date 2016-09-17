package br.com.syncer.things.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean(name="sugestaoController")
public class SugestaoController {
	@ManagedProperty(value="#{sugestao}")
	Sugestao sugestao;
	public void setSugestao(Sugestao sugestao) {
		this.sugestao = sugestao;
	}
	public String getMessage() {
		return sugestao.enviada();
	}
	
}
