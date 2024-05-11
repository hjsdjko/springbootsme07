package com.dao;

import com.entity.AnlifenxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnlifenxiVO;
import com.entity.view.AnlifenxiView;


/**
 * 案例分析
 * 
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface AnlifenxiDao extends BaseMapper<AnlifenxiEntity> {
	
	List<AnlifenxiVO> selectListVO(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
	
	AnlifenxiVO selectVO(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
	
	List<AnlifenxiView> selectListView(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);

	List<AnlifenxiView> selectListView(Pagination page,@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
	
	AnlifenxiView selectView(@Param("ew") Wrapper<AnlifenxiEntity> wrapper);
	

}
