package com.dao;

import com.entity.DiscussanlifenxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussanlifenxiVO;
import com.entity.view.DiscussanlifenxiView;


/**
 * 案例分析评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface DiscussanlifenxiDao extends BaseMapper<DiscussanlifenxiEntity> {
	
	List<DiscussanlifenxiVO> selectListVO(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
	
	DiscussanlifenxiVO selectVO(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
	
	List<DiscussanlifenxiView> selectListView(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);

	List<DiscussanlifenxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
	
	DiscussanlifenxiView selectView(@Param("ew") Wrapper<DiscussanlifenxiEntity> wrapper);
	

}
