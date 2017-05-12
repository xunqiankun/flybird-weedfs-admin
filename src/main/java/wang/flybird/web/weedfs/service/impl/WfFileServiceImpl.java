package wang.flybird.web.weedfs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wang.flybird.dao.WfFileDao;
import wang.flybird.entity.WfFileEntity;
import wang.flybird.web.weedfs.service.WfFileService;



@Service("wfFileService")
public class WfFileServiceImpl implements WfFileService {
	@Autowired
	private WfFileDao wfFileDao;
	
	@Override
	public WfFileEntity queryObject(String id){
		return wfFileDao.queryObject(id);
	}
	
	@Override
	public List<WfFileEntity> queryList(Map<String, Object> map){
		return wfFileDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wfFileDao.queryTotal(map);
	}
	
	@Override
	public void save(WfFileEntity wfFile){
		wfFileDao.save(wfFile);
	}
	
	@Override
	public void update(WfFileEntity wfFile){
		wfFileDao.update(wfFile);
	}
	
	@Override
	public void delete(String id){
		wfFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		wfFileDao.deleteBatch(ids);
	}
	
}
