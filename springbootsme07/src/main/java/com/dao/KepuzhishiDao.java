package com.dao;

import com.entity.KepuzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KepuzhishiVO;
import com.entity.view.KepuzhishiView;


/**
 * 科普知识
 * 
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface KepuzhishiDao extends BaseMapper<KepuzhishiEntity> {
	
	List<KepuzhishiVO> selectListVO(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
	
	KepuzhishiVO selectVO(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
	
	List<KepuzhishiView> selectListView(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);

	List<KepuzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
	
	KepuzhishiView selectView(@Param("ew") Wrapper<KepuzhishiEntity> wrapper);
	

}
