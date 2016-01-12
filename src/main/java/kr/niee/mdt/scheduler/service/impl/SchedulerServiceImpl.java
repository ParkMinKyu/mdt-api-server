package kr.niee.mdt.scheduler.service.impl;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.scheduler.dao.SchedulerDAO;
import kr.niee.mdt.scheduler.service.SchedulerService;
import kr.niee.mdt.scheduler.vo.SchedulerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("schedulerService")
@Transactional
public class SchedulerServiceImpl implements SchedulerService{

	@Autowired
	private SchedulerDAO SchedulerDAO;
	
	@Override
	public List<Map<String, Object>> getScheduler(SchedulerVO schedulerVO) {
		// TODO Auto-generated method stub
		return SchedulerDAO.getScheduler(schedulerVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insertScheduler(SchedulerVO schedulerVO) throws Exception {
		// TODO Auto-generated method stub
		int maxId = SchedulerDAO.getMaxId();
		schedulerVO.setId(maxId + 1);
		return SchedulerDAO.insertScheduler(schedulerVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateScheduler(SchedulerVO schedulerVO) throws Exception {
		// TODO Auto-generated method stub
		return SchedulerDAO.updateScheduler(schedulerVO);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int deleteScheduler(SchedulerVO schedulerVO) throws Exception {
		// TODO Auto-generated method stub
		return SchedulerDAO.deleteScheduler(schedulerVO);
	}

}
