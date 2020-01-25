package com.pyt.handbook.controller;

import static com.pyt.handbook.constant.AppConstants.GSON;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.handbook.modal.SubTopic;
import com.pyt.handbook.modal.Topic;
import com.pyt.handbook.modal.TopicDetails;
import com.pyt.handbook.service.TopicService;
import com.pyt.handbook.vo.TopicVO;

@CrossOrigin
@RestController
@RequestMapping("topic")
public class TopicsController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private TopicService topicService;

	@PostMapping("save")
	public Topic signup(@RequestBody TopicVO topic) {
		Topic response = null;
		try {
			response = topicService.saveTopic(topic);
		} catch (Exception e) {
			logger.error("Error saving topic {}", topic.getTopicId(), e);
		}
		return response;
	}
	
	@PostMapping("subTopic/save")
	public SubTopic saveSubTopic(@RequestBody SubTopic topicDetails) {
		SubTopic details = null;
		try {
			details = topicService.saveSubTopic(topicDetails);
		}catch (Exception e) {
			logger.error("error saving topic details {}", topicDetails.getTopicId() ,e);
		}
		return details;
	}

	@GetMapping("all")
	public List<TopicVO> getAllTopics() {
		List<TopicVO> topics = null;
		try {
			topics = topicService.fetchAllTopics();
		}catch (Exception e) {
			logger.error("error fetching topics",e );
		}
				
		return topics;
	}
	
	@GetMapping("details")
	public TopicDetails getTopicDetails(@Param("topicId") String topicId, @Param("subTopicId") String subTopicId) {
		TopicDetails details = null;
		try {
			details = topicService.getTopicDetails(topicId, subTopicId);
		}catch (Exception e) {
			logger.error("error fetching topic details {}", topicId ,e);
		}
		return details;
	}
	
	@PostMapping("details/save")
	public TopicDetails saveTopicDetails(@RequestBody TopicDetails topicDetails) {
		TopicDetails details = null;
		try {
			details = topicService.saveTopicDetails(topicDetails);
		}catch (Exception e) {
			logger.error("error saving topic details {}", topicDetails.getTopicId() ,e);
		}
		return details;
	}
}
