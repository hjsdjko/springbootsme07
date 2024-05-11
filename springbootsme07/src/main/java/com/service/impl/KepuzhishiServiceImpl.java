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


import com.dao.KepuzhishiDao;
import com.entity.KepuzhishiEntity;
import com.service.KepuzhishiService;
import com.entity.vo.KepuzhishiVO;
import com.entity.view.KepuzhishiView;

@Service("kepuzhishiService")
public class KepuzhishiServiceImpl extends ServiceImpl<KepuzhishiDao, KepuzhishiEntity> implements KepuzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KepuzhishiEntity> page = this.selectPage(
                new Query<KepuzhishiEntity>(params).getPage(),
                new EntityWrapper<KepuzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KepuzhishiEntity> wrapper) {
		  Page<KepuzhishiView> page =new Query<KepuzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KepuzhishiVO> selectListVO(Wrapper<KepuzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KepuzhishiVO selectVO(Wrapper<KepuzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KepuzhishiView> selectListView(Wrapper<KepuzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KepuzhishiView selectView(Wrapper<KepuzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
