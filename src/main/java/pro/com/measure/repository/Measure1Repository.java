package pro.com.measure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pro.com.measure.model.Measurement1;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Measure1Repository
        extends MongoRepository<Measurement1, String> {

    List<Measurement1> findAllByDateTimeAfter(LocalDateTime time);
    List<Measurement1> findAllByDateTimeBetween(LocalDateTime start, LocalDateTime finish);
}
