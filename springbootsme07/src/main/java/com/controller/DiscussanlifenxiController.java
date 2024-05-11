package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussanlifenxiEntity;
import com.entity.view.DiscussanlifenxiView;

import com.service.DiscussanlifenxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 案例分析评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
@RestController
@RequestMapping("/discussanlifenxi")
public class DiscussanlifenxiController {
    @Autowired
    private DiscussanlifenxiService discussanlifenxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussanlifenxiEntity discussanlifenxi,
		HttpServletRequest request){
        EntityWrapper<DiscussanlifenxiEntity> ew = new EntityWrapper<DiscussanlifenxiEntity>();
		PageUtils page = discussanlifenxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussanlifenxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussanlifenxiEntity discussanlifenxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussanlifenxiEntity> ew = new EntityWrapper<DiscussanlifenxiEntity>();
		PageUtils page = discussanlifenxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussanlifenxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussanlifenxiEntity discussanlifenxi){
       	EntityWrapper<DiscussanlifenxiEntity> ew = new EntityWrapper<DiscussanlifenxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussanlifenxi, "discussanlifenxi")); 
        return R.ok().put("data", discussanlifenxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussanlifenxiEntity discussanlifenxi){
        EntityWrapper< DiscussanlifenxiEntity> ew = new EntityWrapper< DiscussanlifenxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussanlifenxi, "discussanlifenxi")); 
		DiscussanlifenxiView discussanlifenxiView =  discussanlifenxiService.selectView(ew);
		return R.ok("查询案例分析评论表成功").put("data", discussanlifenxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussanlifenxiEntity discussanlifenxi = discussanlifenxiService.selectById(id);
        return R.ok().put("data", discussanlifenxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussanlifenxiEntity discussanlifenxi = discussanlifenxiService.selectById(id);
        return R.ok().put("data", discussanlifenxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussanlifenxiEntity discussanlifenxi, HttpServletRequest request){
    	discussanlifenxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussanlifenxi);
        discussanlifenxiService.insert(discussanlifenxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussanlifenxiEntity discussanlifenxi, HttpServletRequest request){
    	discussanlifenxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussanlifenxi);
        discussanlifenxiService.insert(discussanlifenxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussanlifenxiEntity discussanlifenxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussanlifenxi);
        discussanlifenxiService.updateById(discussanlifenxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussanlifenxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussanlifenxiEntity> wrapper = new EntityWrapper<DiscussanlifenxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussanlifenxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
