package br.com.syncer.things.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="musicaController")
@SessionScoped
public class MusicaController {
@ManagedProperty(value="#{musica}")
Musica musica;
}
