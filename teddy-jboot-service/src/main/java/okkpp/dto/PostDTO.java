package okkpp.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.Long authorId;
	
	private java.lang.Long channelId;
	
	private java.lang.String title;
	
	private java.lang.String summary;
	
	private java.lang.String tags;
	
	private java.lang.Integer views;
	
	private java.lang.Integer featured;
	
	private java.lang.Integer weight;
	
	private java.util.Date created;
	
	private java.lang.Integer enable;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setAuthorId(java.lang.Long authorId) {
		this.authorId = authorId;
	}
	
	public java.lang.Long getAuthorId() {
		return this.authorId;
	}

	public void setChannelId(java.lang.Long channelId) {
		this.channelId = channelId;
	}
	
	public java.lang.Long getChannelId() {
		return this.channelId;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}

	public void setSummary(java.lang.String summary) {
		this.summary = summary;
	}
	
	public java.lang.String getSummary() {
		return this.summary;
	}

	public void setTags(java.lang.String tags) {
		this.tags = tags;
	}
	
	public java.lang.String getTags() {
		return this.tags;
	}

	public void setViews(java.lang.Integer views) {
		this.views = views;
	}
	
	public java.lang.Integer getViews() {
		return this.views;
	}

	public void setFeatured(java.lang.Integer featured) {
		this.featured = featured;
	}
	
	public java.lang.Integer getFeatured() {
		return this.featured;
	}

	public void setWeight(java.lang.Integer weight) {
		this.weight = weight;
	}
	
	public java.lang.Integer getWeight() {
		return this.weight;
	}

	public void setCreated(java.util.Date created) {
		this.created = created;
	}
	
	public java.util.Date getCreated() {
		return this.created;
	}

	public void setEnable(java.lang.Integer enable) {
		this.enable = enable;
	}
	
	public java.lang.Integer getEnable() {
		return this.enable;
	}

}
