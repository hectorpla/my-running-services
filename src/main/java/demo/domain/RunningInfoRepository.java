package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by hectorlueng on 4/13/18.
 */
public interface RunningInfoRepository extends JpaRepository<RunningInformation, Long> {
    Page<RunningInformation> findByUserName(@Param("userName") String userName, Pageable pageable);
    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId, Pageable pageable);
    Page<RunningInformation> findAllByOrderByHealthWarningLevelDesc(Pageable pageable);

    void deleteByRunningId(@Param("userName") String runningId);

}
