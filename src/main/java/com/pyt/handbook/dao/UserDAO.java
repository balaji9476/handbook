package com.pyt.handbook.dao;

import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.pyt.handbook.modal.User;

@Component
public class UserDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public User saveUser(User user) {
		return mongoTemplate.save(user);
	}
	
	public void updateUserByEmployeeId(String empId, Map<String, Object> keyvalues ) {
		Query query = new Query();
		query.addCriteria(Criteria.where("empId").is(empId));
		Update update = new Update();
		Set<String> enu = keyvalues.keySet();
		for (String key : enu) {
			Object value = keyvalues.get(key);
			if (key != null && value != null) {
				update.set(key, value);
			}
		}
		mongoTemplate.updateFirst(query, update, User.class);
	}
	
	public User getUserEmployeeId(String empId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("empId").is(empId));
		return mongoTemplate.findOne(query, User.class);
	}
}
