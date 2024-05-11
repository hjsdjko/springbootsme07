package com.entity.view;

import com.entity.DiscusskepuzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 科普知识评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
@TableName("discusskepuzhishi")
public class DiscusskepuzhishiView  extends DiscusskepuzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskepuzhishiView(){
	}
 
 	public DiscusskepuzhishiView(DiscusskepuzhishiEntity discusskepuzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, discusskepuzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
