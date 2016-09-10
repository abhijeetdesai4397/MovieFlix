package com.gobs.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gobs.api.bean.Media;
import com.gobs.api.exception.media.InvadidMediaException;
import com.gobs.api.exception.media.MediaAlreadyExistException;
import com.gobs.api.exception.media.MediaNotFoundException;
import com.gobs.api.repository.MediaRepository;

@Service
public class MediaService {

	@Autowired
	private MediaRepository repository;
	
	public List<Media> getAllMedia()
	{
		return repository.getAllMedia();
	}
	
	public Media getMedia(String mediaId)
	{
		Media media=repository.getMedia(mediaId);
		if(media==null)
			throw new MediaNotFoundException("Media with given ID does not exist");
		return media;
	}
	
	@Transactional
	public Media createMedia(Media media)
	{
		Media mediaExist=repository.getMediaByImdbID(media.getImdbID());
		if(mediaExist!=null)
		{
			throw new MediaAlreadyExistException("Media with gievn ImdbId already exist");
		}
		return repository.createMedia(media);
	}
	
	@Transactional
	public Media updateMedia(String mediaId, Media media)
	{
		Media mediaExist=repository.getMedia(mediaId);
		if(mediaExist==null)
			throw new MediaNotFoundException("Media with given ID does not exist");
		if(!mediaExist.getImdbID().equals(media.getImdbID()))
			throw new InvadidMediaException("Media ImdbId does not match");
		return repository.updateMedia(media);
	}
}
