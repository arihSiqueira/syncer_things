package br.com.syncer.things.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@SessionScoped
@ManagedBean(name="musica")
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
private Date date11;

public void onDateSelect(SelectEvent event) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
}
 
public void click() {
    RequestContext requestContext = RequestContext.getCurrentInstance();
     
    requestContext.update("form:display");
    requestContext.execute("PF('dlg').show()");
}
String letraMusica;
String compositorMusica;
String banda;
public Musica(){
	
}
public Date getDate11() {
	return date11;
}
public void setDate11(Date date11) {
	this.date11 = date11;
}

}
