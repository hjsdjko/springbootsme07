package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 案例分析
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
@TableName("anlifenxi")
public class AnlifenxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AnlifenxiEntity() {
		
	}
	
	public AnlifenxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 案例编号
	 */
					
	private String anlibianhao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：案例编号
	 */
	public void setAnlibianhao(String anlibianhao) {
		this.anlibianhao = anlibianhao;
	}
	/**
	 * 获取：案例编号
	 */
	public String getAnlibianhao() {
		return anlibianhao;
	}
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
