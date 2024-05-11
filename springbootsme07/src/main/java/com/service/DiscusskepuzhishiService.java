package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskepuzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskepuzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskepuzhishiView;


/**
 * 科普知识评论表
 *
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface DiscusskepuzhishiService extends IService<DiscusskepuzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskepuzhishiVO> selectListVO(Wrapper<DiscusskepuzhishiEntity> wrapper);
   	
   	DiscusskepuzhishiVO selectVO(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
   	
   	List<DiscusskepuzhishiView> selectListView(Wrapper<DiscusskepuzhishiEntity> wrapper);
   	
   	DiscusskepuzhishiView selectView(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskepuzhishiEntity> wrapper);
   	

}

