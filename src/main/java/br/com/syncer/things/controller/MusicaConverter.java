package br.com.syncer.things.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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

@ManagedBean
@RequestScoped
public class MusicaConverter implements Converter{

	
	@ManagedProperty(value="#{musicService}")
	private MusicService musicService;


    public MusicService getMusicService() {
		return musicService;
	}

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Convert here Operation object to String value for use in HTML.
        if (!(value instanceof Musica) || ((Musica) value).getId() == null) {
            return null;
        }

        return String.valueOf(((Musica) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Convert here String submitted value to Operation object.
        if (value == null || !value.matches("\\d+")) {
            return null;
        }

        Musica musica = musicService.getMusicRepository().findByMusic_Id(Long.valueOf(value));
        System.out.println(musica.getTituloMusica());
        System.out.println(musica.getId());
        if (musica == null) {
            throw new ConverterException(new FacesMessage("Unknown operation ID: " + value));
        }

        return musica;
    }
    
}
