package pro.com.measure.service.measurement1.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.com.measure.model.Measurement1;
import pro.com.measure.repository.Measure1Repository;
import pro.com.measure.service.measurement1.interfaces.IMeasurement1Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class Measurement1ServiceImpl implements IMeasurement1Service {

    private List<Measurement1> measures = new ArrayList<>();

    @Autowired
    Measure1Repository repository;

    @PostConstruct
    void init(){
      /*  repository.deleteAll();
        measures.add(new Measurement1(LocalDateTime.now().minusSeconds(1), 12.2f));
        measures.add(new Measurement1(LocalDateTime.now(), 12.1f));
        measures.add(new Measurement1(LocalDateTime.now().plusSeconds(1), 12.2f));
        measures.add(new Measurement1(LocalDateTime.now().plusSeconds(2), 12.2f));
       repository.saveAll(measures);

      */
    }


    @Override
    public Measurement1 create(Measurement1 measure) {

        System.out.println("Saved");

        return repository.save(measure);
    }

    @Override
    public Measurement1 get(String id) {
        return null;
    }

    @Override
    public Measurement1 delete(String id) {
        return null;
    }

    @Override
    public Measurement1 update(Measurement1 measure) {
        return null;
    }

    @Override
    public List<Measurement1> getAll() {
        return repository.findAll();
    }
}
