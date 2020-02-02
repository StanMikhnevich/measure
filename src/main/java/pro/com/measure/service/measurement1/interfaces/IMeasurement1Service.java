package pro.com.measure.service.measurement1.interfaces;

import pro.com.measure.model.Measurement1;

import java.time.LocalDateTime;
import java.util.List;

public interface IMeasurement1Service {
    Measurement1 create(Measurement1 measure);

    Measurement1 get(String id);

    Measurement1 delete(String id);

    Measurement1 update(Measurement1 measure);

    List<Measurement1> getAll();

    List<Measurement1> getAllForTheCurrentHour();

    List<Measurement1> getAllForTheHour(LocalDateTime hour);
}
