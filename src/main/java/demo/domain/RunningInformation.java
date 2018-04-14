package demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hectorlueng on 4/13/18.
 */

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    @GeneratedValue
    private String id;

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private String userName;
    private String address;


}
