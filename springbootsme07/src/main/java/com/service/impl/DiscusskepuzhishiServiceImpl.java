package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusskepuzhishiDao;
import com.entity.DiscusskepuzhishiEntity;
import com.service.DiscusskepuzhishiService;
import com.entity.vo.DiscusskepuzhishiVO;
import com.entity.view.DiscusskepuzhishiView;

@Service("discusskepuzhishiService")
public class DiscusskepuzhishiServiceImpl extends ServiceImpl<DiscusskepuzhishiDao, DiscusskepuzhishiEntity> implements DiscusskepuzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskepuzhishiEntity> page = this.selectPage(
                new Query<DiscusskepuzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscusskepuzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskepuzhishiEntity> wrapper) {
		  Page<DiscusskepuzhishiView> page =new Query<DiscusskepuzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskepuzhishiVO> selectListVO(Wrapper<DiscusskepuzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskepuzhishiVO selectVO(Wrapper<DiscusskepuzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskepuzhishiView> selectListView(Wrapper<DiscusskepuzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskepuzhishiView selectView(Wrapper<DiscusskepuzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
