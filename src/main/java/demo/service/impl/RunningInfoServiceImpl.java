package demo.service.impl;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hectorlueng on 4/15/18.
 */

@Service
public class RunningInfoServiceImpl implements RunningInfoService {

    private RunningInfoRepository runningInfoRepository;

    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository repo) {
        runningInfoRepository = repo;
    }

    @Override
    public RunningInformation saveRunningInformation(RunningInformation info) {
        return runningInfoRepository.save(info);
    }

    @Override
    public Page<RunningInformation> findByUserName(String userName, Pageable pageable) {
        return runningInfoRepository.findByUserName(userName, pageable);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningInfoRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findAllOrderByHealthWarningLevel(Pageable pageable) {
        return runningInfoRepository.findAllByOrderByHealthWarningLevelDesc(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInfoRepository.deleteByRunningId(runningId);
    }
}
