package com.develowick.semaine1.service.impl;

import com.develowick.semaine1.model.Topic;
import com.develowick.semaine1.repository.TopicRepository;
import com.develowick.semaine1.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    List<Topic> topics = Arrays.asList(
//            new Topic("1", "math1", "basic math"),
//                new Topic("2", "phisics1", "basic phisics"),
//                new Topic("3", "bio1", "basic biology")
//        );

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(String id, Topic topic) {
        // do something to update the topic
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }


}
