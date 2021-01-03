package com.manula.Starlink;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//A business service. Keeps it in memory. Other classes can use the service of this
@Service //marks as a service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic("Spring","framework","description"),
        new Topic("python","python framework"," python description"),
        new Topic("java","java framework"," java description")
    ));

        public List<Topic> getAllTopics(){
            //return topics;

            //CRUD ops
            List<Topic> topics = new ArrayList<>();
            topicRepository.findAll()
                    .forEach(topics::add);
            return topics;
        }

        public Topic getTopic(String id){
           // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            return topicRepository.findById(id).orElse(null);
            }


        public void addTopic(Topic topic){

            //topics.add(topic);
            topicRepository.save(topic);
        }


        public void updateTopic(String id, Topic topic){
//            for (int i=0; i<topics.size(); i++){
//                Topic t = topics.get(i);
//                if (t.getId().equals(id)){
//                    topics.set(i,topic);
//                    return;
//                }
//            }
            topicRepository.save(topic);
        }

        public void deleteTopic(String id){
        //topics.removeIf(t -> t.getId().equals(id));

            topicRepository.deleteById(id);
    }
}
