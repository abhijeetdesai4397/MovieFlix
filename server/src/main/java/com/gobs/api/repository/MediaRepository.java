package com.gobs.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gobs.api.bean.Media;

@Repository
public class MediaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Media> getAllMedia()
	{
		TypedQuery<Media> query= entityManager.createNamedQuery("Media.getAllMedia",Media.class);
		return query.getResultList();
	}
	
	public Media getMedia(String mediaId)
	{
		return entityManager.find(Media.class, mediaId);
	}
	
	public Media getMediaByImdbID(String imdbID)
	{
		TypedQuery<Media> query=entityManager.createNamedQuery("Media.checkMedia", Media.class);
		query.setParameter("imdbID", imdbID);
		List<Media> mediaList=query.getResultList();
		if(mediaList.size()>0)
		{
			return mediaList.get(0);
		}
		return null;
	}
	
	public Media createMedia(Media media)
	{
		entityManager.persist(media);
		return media;
	}
	
	public Media updateMedia(Media media)
	{
		entityManager.merge(media);
		return media;
	}
}
