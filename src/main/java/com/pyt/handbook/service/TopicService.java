package com.pyt.handbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.handbook.dao.TopicDAO;
import com.pyt.handbook.modal.SubTopic;
import com.pyt.handbook.modal.Topic;
import com.pyt.handbook.modal.TopicDetails;
import com.pyt.handbook.vo.SubTopicVO;
import com.pyt.handbook.vo.TopicVO;

@Service
public class TopicService {
	@Autowired
	private TopicDAO topicDAO;

	public Topic saveTopic(TopicVO topicvo) {
		Topic topic = new Topic();
		topic.setActive(topicvo.getActive());
		topic.setName(topicvo.getName());
		return topicDAO.saveTopic(topic);
	}
	
	public SubTopic saveSubTopic(SubTopic subtopic) {
		return topicDAO.saveSubTopic(subtopic);
	}
	
	public List<TopicVO> fetchAllTopics() {
		List<Topic> topics = topicDAO.fetchAllTopics();
		List<TopicVO> topicVOList = new ArrayList<TopicVO>();
		for(Topic topic: topics) {
			TopicVO topicVO = new TopicVO();
			topicVO.setName(topic.getName());
			topicVO.setTopicId(topic.getId());
			
			List<SubTopicVO> subTopicVOList = new ArrayList<SubTopicVO>();
			List<SubTopic> subTopics = topicDAO.getSubTopics(topic.getId());
			for(SubTopic subTopic: subTopics) {
				SubTopicVO subTopicVO = new SubTopicVO();
				subTopicVO.setName(subTopic.getName());
				subTopicVO.setSubTopicId(subTopic.getId());
				
				subTopicVOList.add(subTopicVO);
			}
			topicVO.setSubTopics(subTopicVOList);
			
			topicVOList.add(topicVO);
		}
		
		return topicVOList;
	}
	
	public TopicDetails getTopicDetails(String topicId, String subTopicId) {
		return topicDAO.getTopicDetails(topicId, subTopicId);
	}
	
	public TopicDetails saveTopicDetails(TopicDetails topicDetails) {
		return topicDAO.saveTopicDetails(topicDetails);
	}
}
