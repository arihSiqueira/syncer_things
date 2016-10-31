package br.com.syncer.things.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.syncer.things.model.Musica;

public interface MusicRepository extends CrudRepository<Musica, Long> {
	public Musica findByTituloMusica(String tituloMusica);
	public Musica findByCompositorMusica(String compositorMusica);
	public Musica findByBanda(String banda);
}
