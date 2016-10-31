package br.com.syncer.things.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.primefaces.event.SelectEvent;
@Entity
@Table(name = "music")
public class Musica {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Column(name = "MUSIC_LYRIC")
private String letraMusica;
@Column(name = "MUSIC_COMPOSITOR")
private String compositorMusica;
@Column(name = "MUSIC_BAND")
private String banda;
@Column(name = "MUSIC_DURATION")
private Date date11;
@Column(name = "MUSIC_TITLE")
private String tituloMusica;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

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
public void onDateSelect(SelectEvent event) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }


public Musica(){

	
}
public Musica(Long id, String tituloMusica){
	this.id = id;
	this.tituloMusica = tituloMusica;
	this.id += 1;
}
public Musica(Long id2, String tituloMusica, String letraMusica, String compositorMusica, String banda){
	this.banda = banda;
	this.compositorMusica = compositorMusica;
	this.letraMusica = letraMusica;
	this.tituloMusica = tituloMusica;
	this.id = id2;
	this.id += 1;
}

public Date getDate11() {
	return date11;
}
public void setDate11(Date date11) {
	this.date11 = date11;
}
@Override
public String toString() {
    return tituloMusica;
}

}
