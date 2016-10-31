package br.com.syncer.things.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.syncer.things.model.Musica;
import br.com.syncer.things.repository.MusicRepository;

@Service("musicService")
@Transactional
public class MusicServiceImpl implements MusicService{
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public void transacaoSave(Musica musica){
		System.out.println("tn");
		musicRepository.save(musica);
	}
	public MusicRepository getMusicRepository() {
		return musicRepository;
	}
	public void setMusicRepository(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}

}
