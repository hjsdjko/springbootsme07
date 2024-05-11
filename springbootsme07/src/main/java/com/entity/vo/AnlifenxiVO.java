package com.entity.vo;

import com.entity.AnlifenxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 案例分析
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public class AnlifenxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 案例名称
	 */
	
	private String anlimingcheng;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 案例详情
	 */
	
	private String anlixiangqing;
		
	/**
	 * 案例分析
	 */
	
	private String anlifenxi;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：案例名称
	 */
	 
	public void setAnlimingcheng(String anlimingcheng) {
		this.anlimingcheng = anlimingcheng;
	}
	
	/**
	 * 获取：案例名称
	 */
	public String getAnlimingcheng() {
		return anlimingcheng;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：案例详情
	 */
	 
	public void setAnlixiangqing(String anlixiangqing) {
		this.anlixiangqing = anlixiangqing;
	}
	
	/**
	 * 获取：案例详情
	 */
	public String getAnlixiangqing() {
		return anlixiangqing;
	}
				
	
	/**
	 * 设置：案例分析
	 */
	 
	public void setAnlifenxi(String anlifenxi) {
		this.anlifenxi = anlifenxi;
	}
	
	/**
	 * 获取：案例分析
	 */
	public String getAnlifenxi() {
		return anlifenxi;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
