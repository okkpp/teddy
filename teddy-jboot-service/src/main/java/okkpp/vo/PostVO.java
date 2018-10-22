package okkpp.vo;

import java.io.Serializable;

public class PostVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long authorId;
	
	private java.lang.Long channelId;
	
	private java.lang.String title;
	
	private java.lang.String summary;
	
	private java.lang.String tags;
	
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

}
