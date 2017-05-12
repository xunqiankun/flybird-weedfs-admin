package wang.flybird.web.weedfs.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wang.flybird.entity.WfFileEntity;
import wang.flybird.utils.PageUtils;
import wang.flybird.utils.Query;
import wang.flybird.utils.R;
import wang.flybird.web.weedfs.service.WfFileService;


/**
 * 
 * 
 * @author flybird
 * @email flybird@flybird.wang
 * @date 2017-05-12 10:45:34
 */
@RestController
@RequestMapping("wffile")
public class WfFileController {
	@Autowired
	private WfFileService wfFileService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("wffile:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WfFileEntity> wfFileList = wfFileService.queryList(query);
		int total = wfFileService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wfFileList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("wffile:info")
	public R info(@PathVariable("id") String id){
		WfFileEntity wfFile = wfFileService.queryObject(id);
		
		return R.ok().put("wfFile", wfFile);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("wffile:save")
	public R save(@RequestBody WfFileEntity wfFile){
		wfFileService.save(wfFile);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("wffile:update")
	public R update(@RequestBody WfFileEntity wfFile){
		wfFileService.update(wfFile);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("wffile:delete")
	public R delete(@RequestBody String[] ids){
		wfFileService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
