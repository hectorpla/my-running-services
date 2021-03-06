package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus(value = HttpStatus.CREATED)
    public void uploadInfo(@RequestBody RunningInformation runningInformation) { // annotation!!
        runningInfoService.saveRunningInformation(runningInformation);
    }

    @RequestMapping(value = "/runningInfo/batch", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadInfoList(@RequestBody List<RunningInformation> infoList) {
        runningInfoService.saveBatchInformation(infoList);
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public Page<RunningInformation> findByUserName(@PathVariable String userName,
                                                   @RequestParam(name = "size") int size,
                                                   @RequestParam(name = "page") int page) {
        return runningInfoService.findByUserName(userName, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningId/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> findByRunningId(@PathVariable String runningId,
                                                   @RequestParam(name = "size") int size,
                                                   @RequestParam(name = "page") int page) {
        return runningInfoService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAll(@RequestParam(name = "size") int size,
                                            @RequestParam(name = "page") int page) {
        return runningInfoService.findAllOrderByHealthWarningLevel(new PageRequest(page, size));
    }

    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId) {
        runningInfoService.deleteByRunningId(runningId);
    }


    @RequestMapping(value = "runningInfo/{runningId}", method = RequestMethod.PUT)
    public void updateRunningInfo() {
        // @TODO: not implemented
    }
}
