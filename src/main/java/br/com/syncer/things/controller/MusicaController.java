package br.com.syncer.things.controller;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.syncer.things.model.Musica;
import br.com.syncer.things.service.MusicService;
@ManagedBean(name="musicaController")
@SessionScoped
public class MusicaController implements Serializable{
	private String letraMusica;
	private String compositorMusica;
	private String banda;
	private String tituloMusica;
	@ManagedProperty(value="#{musicService}")
	private MusicService musicService;
	private Musica musica;
	private static final long serialVersionUID = 1L;
	private List<Musica> musicas;
	private Date date11;

	public void addMusica() throws IOException{
		Musica musicaSave = new Musica();
		String tituloMusica = getTituloMusica();
		musicaSave.setTituloMusica(tituloMusica);
		String letraMusica = getLetraMusica();
		musicaSave.setLetraMusica(letraMusica);
		String compositorMusica = getCompositorMusica();
		musicaSave.setCompositorMusica(compositorMusica);
		String banda = getBanda();
		musicaSave.setBanda(banda);
		Date date11 = getDate11();
		musicaSave.setDate11(date11);
	
		if(musicaSave.getTituloMusica().equals("StrangerThings")){
			FacesContext.getCurrentInstance().getExternalContext().redirect("secretPage.xhtml");
		}
		else
		{
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("lista.xhtml");

		}
		//System.out.println(musicService);
		//System.out.println(musicaSave.getBanda());
		musicService.transacaoSave(musicaSave);
		
		musicas.add(musicaSave);
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
		musicas.add(new Musica((long) 0,"The Phantom of the Opera"));
		musicas.add(new Musica((long) 1,"Hello"));
		musicas.add(musica);
		musica = null;
	}
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
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
	public String getTituloMusica() {
		return tituloMusica;
	}
	public void setTituloMusica(String tituloMusica) {
		this.tituloMusica = tituloMusica;
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	public MusicService getMusicService() {
		return musicService;
	}
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	public Date getDate11() {
		return date11;
	}
	public void setDate11(Date date11) {
		this.date11 = date11;
	}
}
