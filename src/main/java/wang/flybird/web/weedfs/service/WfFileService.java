package wang.flybird.web.weedfs.service;

import wang.flybird.entity.WfFileEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author flybird
 * @email flybird@flybird.wang
 * @date 2017-05-12 10:45:34
 */
public interface WfFileService {
	
	WfFileEntity queryObject(String id);
	
	List<WfFileEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WfFileEntity wfFile);
	
	void update(WfFileEntity wfFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
