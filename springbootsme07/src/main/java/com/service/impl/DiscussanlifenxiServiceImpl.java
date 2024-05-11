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


import com.dao.DiscussanlifenxiDao;
import com.entity.DiscussanlifenxiEntity;
import com.service.DiscussanlifenxiService;
import com.entity.vo.DiscussanlifenxiVO;
import com.entity.view.DiscussanlifenxiView;

@Service("discussanlifenxiService")
public class DiscussanlifenxiServiceImpl extends ServiceImpl<DiscussanlifenxiDao, DiscussanlifenxiEntity> implements DiscussanlifenxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussanlifenxiEntity> page = this.selectPage(
                new Query<DiscussanlifenxiEntity>(params).getPage(),
                new EntityWrapper<DiscussanlifenxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussanlifenxiEntity> wrapper) {
		  Page<DiscussanlifenxiView> page =new Query<DiscussanlifenxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussanlifenxiVO> selectListVO(Wrapper<DiscussanlifenxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussanlifenxiVO selectVO(Wrapper<DiscussanlifenxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussanlifenxiView> selectListView(Wrapper<DiscussanlifenxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussanlifenxiView selectView(Wrapper<DiscussanlifenxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
