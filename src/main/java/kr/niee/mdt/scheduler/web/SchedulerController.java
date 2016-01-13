package kr.niee.mdt.scheduler.web;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import kr.niee.mdt.scheduler.service.SchedulerService;
import kr.niee.mdt.scheduler.vo.SchedulerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="scheduler")
@RequestMapping("/scheduler")
public class SchedulerController{
	
	
	@Autowired
	private SchedulerService schedulerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> scheduler(@RequestParam long starttime, @RequestParam long endtime){
		SchedulerVO schedulerVO = new SchedulerVO();
		schedulerVO.setStarttime(new Timestamp(starttime));
		schedulerVO.setEndtime(new Timestamp(endtime));
		
		return new ResponseEntity<>(schedulerService.getScheduler(schedulerVO),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> insertScheduler(@RequestBody @Valid SchedulerVO schedulerVO) throws Exception{
		int cnt = schedulerService.insertScheduler(schedulerVO);
		if(cnt == 0 ) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(schedulerVO,HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PATCH , consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> updateScheduler(@RequestBody @Valid SchedulerVO schedulerVO) throws Exception{
		int cnt = schedulerService.updateScheduler(schedulerVO);
		if(cnt == 0 ) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(schedulerVO,HttpStatus.ACCEPTED);
	}

	@RequestMapping(method=RequestMethod.DELETE, consumes={MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> deleteScheduler(@RequestBody @Valid SchedulerVO schedulerVO) throws Exception{
		return new ResponseEntity<>(schedulerService.deleteScheduler(schedulerVO),HttpStatus.NO_CONTENT);
	}
}
