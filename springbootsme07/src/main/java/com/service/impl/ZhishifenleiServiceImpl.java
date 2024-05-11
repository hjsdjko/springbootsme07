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


import com.dao.ZhishifenleiDao;
import com.entity.ZhishifenleiEntity;
import com.service.ZhishifenleiService;
import com.entity.vo.ZhishifenleiVO;
import com.entity.view.ZhishifenleiView;

@Service("zhishifenleiService")
public class ZhishifenleiServiceImpl extends ServiceImpl<ZhishifenleiDao, ZhishifenleiEntity> implements ZhishifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhishifenleiEntity> page = this.selectPage(
                new Query<ZhishifenleiEntity>(params).getPage(),
                new EntityWrapper<ZhishifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhishifenleiEntity> wrapper) {
		  Page<ZhishifenleiView> page =new Query<ZhishifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhishifenleiVO> selectListVO(Wrapper<ZhishifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhishifenleiVO selectVO(Wrapper<ZhishifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhishifenleiView> selectListView(Wrapper<ZhishifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhishifenleiView selectView(Wrapper<ZhishifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
