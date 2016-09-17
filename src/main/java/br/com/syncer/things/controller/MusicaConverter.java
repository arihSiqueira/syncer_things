package br.com.syncer.things.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("musicaConverter")
public class MusicaConverter implements Converter{
	 public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	                MusicaController musicaController = (MusicaController) fc.getExternalContext().getApplicationMap().get("musicaController");
	                return musicaController.getMusicas().get(Integer.parseInt(value));
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid music."));
	            }
	        }
	        else {
	            return null;
	        }
	    }
	 
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((Musica) object).getId());
	        }
	        else {
	            return "null object";
	        }
	    }   
}
