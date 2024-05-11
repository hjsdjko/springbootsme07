package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KepuzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KepuzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KepuzhishiView;


/**
 * 科普知识
 *
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface KepuzhishiService extends IService<KepuzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KepuzhishiVO> selectListVO(Wrapper<KepuzhishiEntity> wrapper);
   	
   	KepuzhishiVO selectVO(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
   	
   	List<KepuzhishiView> selectListView(Wrapper<KepuzhishiEntity> wrapper);
   	
   	KepuzhishiView selectView(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KepuzhishiEntity> wrapper);
   	

}

