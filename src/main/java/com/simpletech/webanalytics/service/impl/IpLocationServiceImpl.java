package com.simpletech.webanalytics.service.impl;

import com.simpletech.webanalytics.dao.IpLocationDao;
import com.simpletech.webanalytics.model.IpLocation;
import com.simpletech.webanalytics.model.base.ModelBase;
import com.simpletech.webanalytics.service.IpLocationService;
import com.simpletech.webanalytics.service.base.BaseServiceImpl;
import com.simpletech.webanalytics.util.Page;
import com.simpletech.webanalytics.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表t_ip_location的Service接实现
 * @author 树朾
 * @date 2015-10-16 10:38:40 中国标准时间
 */
@Service
public class IpLocationServiceImpl extends BaseServiceImpl<IpLocation> implements IpLocationService{

	@Autowired
	IpLocationDao dao;
	
	@Override
	public int insert(IpLocation model){
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(IpLocation model) {
		IpLocation old = findById(getModelID(model));
		if (old == null) {
			throw new ServiceException("请求更新记录不存在或已经被删除！");
		}
		model = checkNullField(old, model);
		return dao.update(model);
	}

	@Override
	public int delete(Object id) {
		return dao.delete(id);
	}

	@Override
	public IpLocation findById(Object id){
		return dao.findById(id);
	}

	@Override
	public List<IpLocation> findAll(){
		return dao.findAll();
	}

	@Override
	public int delete(String id){
		return dao.delete(id);
	}

	@Override
	public List<IpLocation> findByPage(int limit, int start) {
		return dao.findByPage(limit, start);
	}

//	@Override
//	public List<IpLocation> findVisitWhereByPage(String where,int limit, int start) throws Exception{
//		return dao.findVisitWhereByPage(where, limit, start);
//	}

	@Override
	public IpLocation findById(String id) {
		return dao.findById(id);
	}
	
	@Override
	public Page<IpLocation> listByPage(int pageSize, int pageNo){
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<IpLocation> list = dao.findByPage(limit, start);
		
		return new Page<IpLocation>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() {
		return dao.countAll();
	}

//	@Override
//	public List<IpLocation> findAllIp(){
//		return dao.findAllIp();
//	}
}
