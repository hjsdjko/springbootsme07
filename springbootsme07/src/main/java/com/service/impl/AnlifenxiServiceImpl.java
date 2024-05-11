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


import com.dao.AnlifenxiDao;
import com.entity.AnlifenxiEntity;
import com.service.AnlifenxiService;
import com.entity.vo.AnlifenxiVO;
import com.entity.view.AnlifenxiView;

@Service("anlifenxiService")
public class AnlifenxiServiceImpl extends ServiceImpl<AnlifenxiDao, AnlifenxiEntity> implements AnlifenxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnlifenxiEntity> page = this.selectPage(
                new Query<AnlifenxiEntity>(params).getPage(),
                new EntityWrapper<AnlifenxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnlifenxiEntity> wrapper) {
		  Page<AnlifenxiView> page =new Query<AnlifenxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AnlifenxiVO> selectListVO(Wrapper<AnlifenxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AnlifenxiVO selectVO(Wrapper<AnlifenxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AnlifenxiView> selectListView(Wrapper<AnlifenxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnlifenxiView selectView(Wrapper<AnlifenxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
