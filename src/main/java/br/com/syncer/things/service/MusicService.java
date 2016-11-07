package br.com.syncer.things.service;

import java.util.List;

import br.com.syncer.things.model.Musica;
import br.com.syncer.things.repository.MusicRepository;

public interface MusicService {
	public void transacaoSave(Musica musica);
	public List<Musica> mostrarTodas();
	public void excluir(Long idMusica);
	public void setMusicRepository(MusicRepository musicRepository);
	public MusicRepository getMusicRepository();

}
