package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

/**
 * Created by hectorlueng on 4/13/18.
 */

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    @GeneratedValue
    private long id;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private String runningId;
    private String userName;
    private String address;

    private int heartRate = 0;
    private String healthWarningLevel;


    public RunningInformation() {
        heartRate = 60 + (int)(140 * Math.random() + 1);
        if (heartRate <= 75) {
            healthWarningLevel = "LOW";
        } else if (heartRate <= 120) {
            healthWarningLevel = "NORMAL";
        } else {
            healthWarningLevel = "HIGH";
        }
    }
}
