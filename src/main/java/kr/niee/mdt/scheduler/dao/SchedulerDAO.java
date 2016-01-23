package kr.niee.mdt.scheduler.dao;

import java.util.List;
import java.util.Map;

import kr.niee.mdt.scheduler.vo.SchedulerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("schedulerDAO")
public class SchedulerDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	public List<Map<String, Object>> getScheduler(SchedulerVO schedulerVO){
		return template.queryForList("select * from scheduler where writer = ? and (starttime between ? and ?) or (endtime between ? and ?) ", schedulerVO.getWriter(),schedulerVO.getStarttime(), schedulerVO.getEndtime(),schedulerVO.getStarttime(), schedulerVO.getEndtime());
	}
	
	public int insertScheduler(SchedulerVO schedulerVO){
		return template.update("insert into scheduler values(?, ?, ?, ?, ?, ?, ?, ?)",schedulerVO.getId(),schedulerVO.getTitle(),schedulerVO.getContents(), schedulerVO.getType(), schedulerVO.getStarttime(), schedulerVO.getEndtime(),schedulerVO.isAllDay(),schedulerVO.getWriter());
	}

	public int updateScheduler(SchedulerVO schedulerVO){
		return template.update("update scheduler set title = ? , contents = ? , type = ? , starttime = ?, endtime = ?, allDay = ? where id = ? ",schedulerVO.getTitle(),schedulerVO.getContents(),schedulerVO.getType(),schedulerVO.getStarttime(),schedulerVO.getEndtime(),schedulerVO.isAllDay(),schedulerVO.getId());
	}

	public int deleteScheduler(SchedulerVO schedulerVO){
		return template.update("delete from scheduler where id = ? ",schedulerVO.getId());
	}

	public int getMaxId(){
		return template.queryForObject("select NVL(MAX(id),0) from scheduler", Integer.class);
	}
}
