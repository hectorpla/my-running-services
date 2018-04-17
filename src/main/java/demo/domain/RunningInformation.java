package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

/**
 * Created by hectorlueng on 4/13/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    private void initHealthStatus() {
        heartRate = 60 + (int)(140 * Math.random() + 1);
        if (heartRate <= 75) {
            healthWarningLevel = "LOW";
        } else if (heartRate <= 120) {
            healthWarningLevel = "NORMAL";
        } else {
            healthWarningLevel = "HIGH";
        }
    }

    // critical: default construction
    public RunningInformation() {
        initHealthStatus();
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("latitude") double lat,
                              @JsonProperty("longitude") double lon,
                              @JsonProperty("runningDistance") double dist,
                              @JsonProperty("totalRunningTime") double time,
                              @JsonProperty("userName") String userName,
                              @JsonProperty("runningId") String runningId,
                              @JsonProperty("address") String address) {
        latitude = lat;
        longitude = lon;
        runningDistance = dist;
        totalRunningTime = time;
        this.userName = userName;
        this.runningId = runningId;
        this.address = address;

        initHealthStatus();
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("runningDistance") double dist,
                              @JsonProperty("totalRunningTime") double time,
                              @JsonProperty("userName") String userName,
                              @JsonProperty("runningId") String runningId,
                              @JsonProperty("address") String address) {

        runningDistance = dist;
        totalRunningTime = time;
        this.userName = userName;
        this.runningId = runningId;
        this.address = address;

        initHealthStatus();
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("totalRunningTime") double time,
                              @JsonProperty("userName") String userName,
                              @JsonProperty("runningId") String runningId,
                              @JsonProperty("address") String address) {

        totalRunningTime = time;
        this.userName = userName;
        this.runningId = runningId;
        this.address = address;

        initHealthStatus();
    }
}
