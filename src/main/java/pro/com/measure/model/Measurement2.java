package pro.com.measure.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Measurement2 {

    @Id
    private String id;
    private String personName;
    private int experimentId;
    private String ExperimentName;
    private LocalDateTime dateTime;
    private float pick;
    private String desc;

    public Measurement2() {
    }

    public Measurement2(String id, String personName, int experimentId, String experimentName, LocalDateTime dateTime, float pick, String desc) {
        this.id = id;
        this.personName = personName;
        this.experimentId = experimentId;
        ExperimentName = experimentName;
        this.dateTime = dateTime;
        this.pick = pick;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(int experimentId) {
        this.experimentId = experimentId;
    }

    public String getExperimentName() {
        return ExperimentName;
    }

    public void setExperimentName(String experimentName) {
        ExperimentName = experimentName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public float getPick() {
        return pick;
    }

    public void setPick(float pick) {
        this.pick = pick;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement2 that = (Measurement2) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Measurement2{" +
                "id='" + id + '\'' +
                ", personName='" + personName + '\'' +
                ", experimentId=" + experimentId +
                ", ExperimentName='" + ExperimentName + '\'' +
                ", dateTime=" + dateTime +
                ", pick=" + pick +
                ", desc='" + desc + '\'' +
                '}';
    }
}
