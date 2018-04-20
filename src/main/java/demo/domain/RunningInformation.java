package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by hectorlueng on 4/13/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    // not used yet
    enum HEALTH_WARNING_LEVEL {
        HIGH, NORMAL, LOW
    }


    @Id
    @GeneratedValue
    private long id;

    private String runningId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private int heartRate;
    private String healthWarningLevel;

    private void initHealthStatus() {
        // hard code, use @TODO enum instead
        // , which gives the elegant solution to sort by warning level
        // but the record in db is human readable
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



//    @JsonCreator
//    public RunningInformation(@JsonProperty("latitude") double lat,
//                              @JsonProperty("longitude") double lon,
//                              @JsonProperty("runningDistance") double dist,
//                              @JsonProperty("totalRunningTime") double time,
//                              @JsonProperty("userName") String userName,
//                              @JsonProperty("runningId") String runningId,
//                              @JsonProperty("address") String address) {
//        latitude = lat;
//        longitude = lon;
//        runningDistance = dist;
//        totalRunningTime = time;
//        this.userName = userName;
//        this.runningId = runningId;
//        this.address = address;
//
//        initHealthStatus();
//    }
//
//    @JsonCreator
//    public RunningInformation(@JsonProperty("runningDistance") double dist,
//                              @JsonProperty("totalRunningTime") double time,
//                              @JsonProperty("userName") String userName,
//                              @JsonProperty("runningId") String runningId,
//                              @JsonProperty("address") String address) {
//
//        runningDistance = dist;
//        totalRunningTime = time;
//        this.userName = userName;
//        this.runningId = runningId;
//        this.address = address;
//
//        initHealthStatus();
//    }
//
//    @JsonCreator
//    public RunningInformation(@JsonProperty("totalRunningTime") double time,
//                              @JsonProperty("userName") String userName,
//                              @JsonProperty("runningId") String runningId,
//                              @JsonProperty("address") String address) {
//
//        totalRunningTime = time;
//        this.userName = userName;
//        this.runningId = runningId;
//        this.address = address;
//
//        initHealthStatus();
//    }

    public String getUserName() {
        return userInfo == null ? null : userInfo.getUsername();
    }

    public String getUserAddress() {
        return userInfo == null ? null : userInfo.getAddress();
    }
}
