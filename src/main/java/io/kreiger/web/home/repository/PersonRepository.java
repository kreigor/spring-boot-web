package io.kreiger.web.home.repository;

import io.kreiger.web.home.document.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByid(ObjectId id);
}
