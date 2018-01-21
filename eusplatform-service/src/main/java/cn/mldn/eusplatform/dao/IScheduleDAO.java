package cn.mldn.eusplatform.dao;

import java.sql.SQLException;

import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.util.dao.IBaseDAO;

public interface IScheduleDAO extends IBaseDAO<Long,Schedule> {

	/**
	 * 修改Schedule中的audit数据和anote数据
	 * @return 成功返回true，否则返回false
	 * @throws SQLException SQL
	 */
	public boolean editByAnote(Schedule vo)throws SQLException;
	
}
