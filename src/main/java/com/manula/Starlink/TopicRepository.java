package com.manula.Starlink;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
    // The usual CRUD Ops are implemented by the Crud Repository interface
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)

}
