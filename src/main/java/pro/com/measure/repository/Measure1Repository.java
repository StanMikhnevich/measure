package pro.com.measure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pro.com.measure.model.Measurement1;

@Repository
public interface Measure1Repository
        extends MongoRepository<Measurement1, String> {
}
