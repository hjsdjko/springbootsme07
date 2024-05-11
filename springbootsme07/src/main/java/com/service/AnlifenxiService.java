package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnlifenxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnlifenxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnlifenxiView;


/**
 * 案例分析
 *
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface AnlifenxiService extends IService<AnlifenxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnlifenxiVO> selectListVO(Wrapper<AnlifenxiEntity> wrapper);
   	
   	AnlifenxiVO selectVO(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
   	
   	List<AnlifenxiView> selectListView(Wrapper<AnlifenxiEntity> wrapper);
   	
   	AnlifenxiView selectView(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnlifenxiEntity> wrapper);
   	

}

