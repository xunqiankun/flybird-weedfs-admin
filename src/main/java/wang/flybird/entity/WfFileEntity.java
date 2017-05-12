package wang.flybird.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author flybird
 * @email flybird@flybird.wang
 * @date 2017-05-12 10:45:34
 */
public class WfFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String username;
	//
	private String fid;
	//
	private String fname;
	//
	private Long fsize;
	//
	private Date uptime;
	//
	private String delflag;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 获取：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 设置：
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * 获取：
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * 设置：
	 */
	public void setFsize(Long fsize) {
		this.fsize = fsize;
	}
	/**
	 * 获取：
	 */
	public Long getFsize() {
		return fsize;
	}
	/**
	 * 设置：
	 */
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	/**
	 * 获取：
	 */
	public Date getUptime() {
		return uptime;
	}
	/**
	 * 设置：
	 */
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	/**
	 * 获取：
	 */
	public String getDelflag() {
		return delflag;
	}
}
