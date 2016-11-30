package br.com.syncer.things.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.syncer.things.model.Musica;
import br.com.syncer.things.repository.MusicRepository;

@Service("musicService")
@Transactional
public class MusicServiceImpl implements MusicService{
	@Autowired
	private MusicRepository musicRepository;
	private List<Musica> musicas;
	@Override
	public void transacaoSave(Musica musica){
		musicRepository.save(musica);
	}
	//public List<Musica> mostrarTodas(){
		//return (List<Musica>) getMusicRepository().findAll();
	//}
	public void setMusicRepository(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}
	public MusicRepository getMusicRepository() {
		return musicRepository;
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	@Override
	public List<Musica> mostrarTodas() {
		List<Musica> retorno = new ArrayList<Musica>();
		for(Musica musica: musicRepository.findAll()) {
			retorno.add(musica);
			System.out.println(musica.getBanda());
		}
		return retorno;
	}
	@Override
	public void excluir(Long idMusica) {
		musicRepository.delete(idMusica);
		
	}
	@Override
	public void transacaoUpdate(Long id, String tituloMusica, String compositorMusica, String letraMusica, String banda, Date date11) {
		// TODO Auto-generated method stub
		musicRepository.atualizarMusica(id, tituloMusica, compositorMusica, letraMusica, banda, date11);
	}
	
}
