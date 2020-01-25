package com.pyt.handbook.modal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topic_details")
public class TopicDetails {
	@Id
	private String id;
	private String title;
	private String content;
	private boolean published;
	private String topicId;
	private String subTopicId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getSubTopicId() {
		return subTopicId;
	}

	public void setSubTopicId(String subTopicId) {
		this.subTopicId = subTopicId;
	}

}
