package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussanlifenxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussanlifenxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussanlifenxiView;


/**
 * 案例分析评论表
 *
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface DiscussanlifenxiService extends IService<DiscussanlifenxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussanlifenxiVO> selectListVO(Wrapper<DiscussanlifenxiEntity> wrapper);
   	
   	DiscussanlifenxiVO selectVO(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
   	
   	List<DiscussanlifenxiView> selectListView(Wrapper<DiscussanlifenxiEntity> wrapper);
   	
   	DiscussanlifenxiView selectView(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussanlifenxiEntity> wrapper);
   	

}

