package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hectorlueng on 4/15/18.
 */

@RestController
public class RunningInfoRestController {

    private RunningInfoService runningInfoService;

    @Autowired
    RunningInfoRestController(RunningInfoService infoService) {
        runningInfoService = infoService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    public void uploadInfo(RunningInformation runningInformation) {
        runningInfoService.saveRunningInfo(runningInformation);
    }

    @RequestMapping(value = "/runningInfo/{userName}", method = RequestMethod.GET)
    public Page<RunningInformation> findByUserName(@PathVariable String userName,
                                                   @RequestParam(name = "size") int size,
                                                   @RequestParam(name = "page") int page) {
        return runningInfoService.findByUserName(userName, new PageRequest(size, page));
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> findByRunningId(@PathVariable String runningId,
                                                   @RequestParam(name = "size") int size,
                                                   @RequestParam(name = "page") int page) {
        return runningInfoService.findByRunningId(runningId, new PageRequest(size, page));
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAll(@RequestParam(name = "size") int size,
                                            @RequestParam(name = "page") int page) {
        return runningInfoService.findAllOrderByHealthWarningLevel(new PageRequest(size,page));
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId) {
        runningInfoService.deleteByRunningId(runningId);
    }
}
