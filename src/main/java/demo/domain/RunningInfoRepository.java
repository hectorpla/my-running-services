package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hectorlueng on 4/13/18.
 */
public interface RunningInfoRepository extends JpaRepository<RunningInformation, Long> {
    RunningInformation saveRunningInfo(RunningInformation info);
    Page<RunningInformation> findByUserName(String userName, Pageable pageable);
    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);
    Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(Pageable pageable);

    void deleteByRunningId(String runningId);

}
