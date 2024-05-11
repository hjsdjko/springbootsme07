package com.dao;

import com.entity.DiscusskepuzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskepuzhishiVO;
import com.entity.view.DiscusskepuzhishiView;


/**
 * 科普知识评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
public interface DiscusskepuzhishiDao extends BaseMapper<DiscusskepuzhishiEntity> {
	
	List<DiscusskepuzhishiVO> selectListVO(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
	
	DiscusskepuzhishiVO selectVO(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
	
	List<DiscusskepuzhishiView> selectListView(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);

	List<DiscusskepuzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
	
	DiscusskepuzhishiView selectView(@Param("ew") Wrapper<DiscusskepuzhishiEntity> wrapper);
	

}
