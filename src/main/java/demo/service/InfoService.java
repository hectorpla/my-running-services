package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hectorlueng on 4/13/18.
 */
public interface InfoService {
    RunningInformation saveRunningInfo(RunningInformation info);
    Page<RunningInformation> findByUserName(String userName, Pageable pageable);
    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);
    Page<RunningInformation> findAllOrderByHealthWarningLevel(Pageable pageable);

    void deleteByRunningId(String runningId);
}
