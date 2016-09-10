package com.gobs.api.bean;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gobs.api.helper.CustomJsonDateDeserializer;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Media.getAllMedia", query="select m from Media m"),
	@NamedQuery(name="Media.checkMedia", query="select m from Media m where m.imdbID=:imdbID")
})
public class Media {

	@Id
	private String id;
	@Column(nullable=false, length=1024)
	private String title;
	@Column(nullable=false)
	private int year;
	@Column(nullable=false)
	private String rated;
	@Column(nullable=false)
	private String released;
	@Column(nullable=false)
	private String runTime;
	@Column(nullable=false)
	private String genre;
	@Column(nullable=false, length=1024)
	private String director;
	@Column(nullable=false, length=1024)
	private String writer;
	@Column(nullable=false, length=1024)
	private String actors;
	@Column(nullable=false, length=1024)
	private String plot;
	@Column(nullable=false)
	private String language;
	@Column(nullable=false)
	private String country;
	@Column(nullable=false, length=1024)
	private String awards;
	@Column(nullable=false, length=1024)
	private String poster;
	@Column(nullable=false)
	private int metaScore;
	@Column(nullable=false)
	private float imdbRating;
	@Column(nullable=false)
	private int imdbVotes;
	@Column(nullable=false,unique=true)
	private String imdbID;
	@Column(nullable=false)
	private String type;
	
	public Media()
	{
		this.id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
