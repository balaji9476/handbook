package com.pyt.handbook.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TopicVO {
	private String topicId;
	private String name;
	private List<SubTopicVO> subTopics;
	private Boolean active;

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubTopicVO> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(List<SubTopicVO> subTopics) {
		this.subTopics = subTopics;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
