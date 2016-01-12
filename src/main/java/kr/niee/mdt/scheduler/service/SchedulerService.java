package kr.niee.mdt.scheduler.service;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.scheduler.vo.SchedulerVO;

public interface SchedulerService {
	public List<Map<String, Object>> getScheduler(SchedulerVO schedulerVO);
	public int insertScheduler(SchedulerVO schedulerVO) throws Exception;
	public int updateScheduler(SchedulerVO schedulerVO) throws Exception;
	public int deleteScheduler(SchedulerVO schedulerVO) throws Exception;
}