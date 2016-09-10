package com.gobs.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gobs.api.bean.Media;
import com.gobs.api.service.MediaService;

@RestController
@RequestMapping(value="/movies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MediaResource {

	@Autowired
	private MediaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Media> getAllMedia()
	{
		return service.getAllMedia();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{mediaId}")
	public Media getMedia(@PathVariable("mediaId") String mediaId)
	{
		return service.getMedia(mediaId);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Media createMedia(@RequestBody Media media)
	{
		return service.createMedia(media);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{mediaId}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Media updateMedia(@PathVariable("mediaId") String mediaId, @RequestBody Media media)
	{
		return service.updateMedia(mediaId,media);
	}
}
