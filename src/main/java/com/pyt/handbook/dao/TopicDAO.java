package com.pyt.handbook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.pyt.handbook.modal.SubTopic;
import com.pyt.handbook.modal.Topic;
import com.pyt.handbook.modal.TopicDetails;

@Component
public class TopicDAO {
	@Autowired
	private MongoTemplate mongoTemplate;

	public Topic saveTopic(Topic topic) {
		Topic existingTopic = getTopic(topic.getName());
		if(existingTopic!=null) {
			topic.setId(existingTopic.getId());
		}
		return mongoTemplate.save(topic);
	}
	public SubTopic saveSubTopic(SubTopic subtopic) {
		Topic existingTopic = getSubTopic(subtopic.getTopicId(), subtopic.getName());
		if(existingTopic!=null) {
			subtopic.setId(existingTopic.getId());
		}
		return mongoTemplate.save(subtopic);
	}
	
	public Topic getTopic(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, Topic.class);
	}
	
	public Topic getSubTopic(String topicId, String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("topicId").is(topicId));
		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, Topic.class);
	}
	
	public List<Topic> fetchAllTopics() {
		return mongoTemplate.findAll(Topic.class);
	}
	
	public List<SubTopic> getSubTopics(String topicId){
		Query query = new Query();
		query.addCriteria(Criteria.where("topicId").is(topicId));
		return mongoTemplate.find(query, SubTopic.class);
	}
	
	public TopicDetails saveTopicDetails(TopicDetails topicDetails) {
		TopicDetails existingTopicDetails = getTopicDetails(topicDetails.getTopicId(), topicDetails.getSubTopicId());
		if(existingTopicDetails!=null) {
			topicDetails.setId(existingTopicDetails.getId());
		}
		return mongoTemplate.save(topicDetails);
	}
	
	public TopicDetails getTopicDetails(String topicId, String subTopicId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("topicId").is(topicId));
		query.addCriteria(Criteria.where("subTopicId").is(subTopicId));
		return mongoTemplate.findOne(query, TopicDetails.class);
	}
	
}
