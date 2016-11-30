package br.com.syncer.things.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.syncer.things.model.Musica;

public interface MusicRepository extends CrudRepository<Musica, Long> {
	public Musica findByTituloMusica(String tituloMusica);
	public Musica findByCompositorMusica(String compositorMusica);
	public Musica findByBanda(String banda);
	 @Query("SELECT m FROM Musica m where m.id = ?1")
	public Musica findByMusic_Id(Long id);
	 @Modifying(clearAutomatically = true)
	 @Query("update Musica m set m.tituloMusica = ?2, m.compositorMusica = ?3, m.letraMusica = ?4, m.banda = ?5, m.date11 = ?6 where m.id = ?1")
	public void atualizarMusica(Long musicaId, String tituloMusica, String compositorMusica, String letraMusica, String banda, Date date11);
}
