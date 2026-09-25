package com.aprendiz.proyecto.repository;

import com.aprendiz.proyecto.model.AprendizDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprendizMongoRepository extends MongoRepository<AprendizDocument, String> {
}
