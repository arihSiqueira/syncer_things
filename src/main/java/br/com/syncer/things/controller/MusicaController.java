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
import org.primefaces.context.RequestContext;
import br.com.syncer.things.model.Musica;
import br.com.syncer.things.service.MusicService;
@ManagedBean(name="musicaController", eager = true)
@SessionScoped
public class MusicaController implements Serializable{
	private Long id;
	private String letraMusica;
	private String compositorMusica;
	private String banda;
	private String tituloMusica;
	@ManagedProperty(value="#{musicService}")
	private MusicService musicService;
	private Musica musica;
	private static final long serialVersionUID = 1L;
	private List<Musica> musicas = new ArrayList<Musica>();
	private Date date11;
	public void removerMusica(){
		Long idMusica = getId();
		System.out.println("did it get here");
		musicService.excluir(idMusica);
		musicas = musicService.mostrarTodas();
	}
	public void alterarMusica(){
		
	}
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
		System.out.println(musicService);
		System.out.println(musicService.getMusicRepository().findByMusic_Id((long) 2));
		if(musicaSave.getTituloMusica().equals("StrangerThings")){
			FacesContext.getCurrentInstance().getExternalContext().redirect("secretPage.xhtml");
		}
		else
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("lista.xhtml");
		}
		musicService.transacaoSave(musicaSave);
		musicas.add(musicaSave);
		musica = null;
	}
	@PostConstruct
	public void init(){
		musicas = musicService.mostrarTodas();
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
