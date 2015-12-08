package com.simpletech.webanalytics.dao.base;

import com.simpletech.webanalytics.model.base.ModelBase;
import com.simpletech.webanalytics.util.AfReflecter;

import java.util.Date;


/**
 * 通用Dao实现基类
 * @param <T>
 * @author 树朾
 * @date 2015-06-29 18:20:50 中国标准时间 
 */
public class BaseDaoImpl<T> extends BaseDaoMybatisMYSQLImpl<T> implements BaseDao<T>{

	public BaseDaoImpl() {
		order = "ORDER BY create_time DESC";
	}
	
	@Override
	public int insert(T t) {
		ModelBase.fillNullID(t);
		AfReflecter.setMemberNoException(t, "createTime", new Date());
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.insert(t);
	}
	
	@Override
	public int update(T t) {
		AfReflecter.setMemberNoException(t, "updateTime", new Date());
		return super.update(t);
	}

}
