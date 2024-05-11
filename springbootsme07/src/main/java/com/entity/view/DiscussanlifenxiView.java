package com.entity.view;

import com.entity.DiscussanlifenxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 案例分析评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
@TableName("discussanlifenxi")
public class DiscussanlifenxiView  extends DiscussanlifenxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussanlifenxiView(){
	}
 
 	public DiscussanlifenxiView(DiscussanlifenxiEntity discussanlifenxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussanlifenxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
