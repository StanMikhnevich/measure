package pro.com.measure.service.measurement1.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.com.measure.model.Measurement1;
import pro.com.measure.repository.Measure1Repository;
import pro.com.measure.service.measurement1.interfaces.IMeasurement1Service;

import javax.annotation.PostConstruct;
import java.lang.management.ThreadInfo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Measurement1ServiceImpl implements IMeasurement1Service {

    private List<Measurement1> measures = new ArrayList<>();

    @Autowired
    Measure1Repository repository;

    private int year;
    private int month;
    private int day;
    private int hour;


    @PostConstruct
    void init(){
        this.initialize();
    }

    private void initialize(){
        this.setYear(LocalDate.now().getYear());
        this.setMonth(LocalDate.now().getMonthValue());
        this.setDay(LocalDate.now().getDayOfMonth());
        this.setHour(LocalDateTime.now().getHour());
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

    @Override
    public List<Measurement1> getAllForTheCurrentHour() {
        this.initialize();
        LocalDateTime from = LocalDateTime.now().withMinute(0).withSecond(0);
        return this.repository.findAllByDateTimeAfter(from);
    }

    @Override
    public List<Measurement1> getAllForTheHour(LocalDateTime time) {
        LocalDateTime start = time;
        LocalDateTime finish = time.withHour(this.getHour() +1);
        System.out.println(start);
        System.out.println(finish);
        return repository.findAllByDateTimeBetween(start, finish);
    }

    public List<Measurement1> getAllForPreviousHour(){
        this.setHour(this.getHour() - 1);
        LocalDateTime time = LocalDateTime.of(this.getYear(),
                this.getMonth(),
                this.getDay(),
                this.getHour(),
                0,
                0);
        System.out.println(this.getHour());
        return this.getAllForTheHour(time);
    }

    public List<Measurement1> getAllForNextHour(){
        this.setHour(this.getHour() + 1);
        LocalDateTime time = LocalDateTime.of(this.getYear(),
                this.getMonth(),
                this.getDay(),
                this.getHour(),
                0,
                0);
        return this.getAllForTheHour(time);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
