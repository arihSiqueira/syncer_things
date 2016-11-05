package br.com.syncer.things.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.syncer.things.model.Musica;
import br.com.syncer.things.service.MusicService;

@FacesConverter("musicaConverter")
@RequestScoped
public class MusicaConverter implements Converter, Serializable{

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{musicService}")
	private MusicService musicService;
	@Override
	 public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	        	Long id = Long.parseLong(value);
	            try {
	            	return musicService.getMusicRepository().findByMusic_Id(id);
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid music."));
	            }
	        }
	        else {
	        	System.out.println("There you are");
	            return null;
	        }
	    }
	 @Override
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((Musica) object).getId());
	        }
	        else {
	            return "null object";
	        }
	    }
		public MusicService getMusicService() {
			return musicService;
		}
		public void setMusicService(MusicService musicService) {
			this.musicService = musicService;
		}
}
