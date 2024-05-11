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

import com.entity.KepuzhishiEntity;
import com.entity.view.KepuzhishiView;

import com.service.KepuzhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 科普知识
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-25 15:16:17
 */
@RestController
@RequestMapping("/kepuzhishi")
public class KepuzhishiController {
    @Autowired
    private KepuzhishiService kepuzhishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi,
		HttpServletRequest request){
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
		PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi, 
		HttpServletRequest request){
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
		PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KepuzhishiEntity kepuzhishi){
       	EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kepuzhishi, "kepuzhishi")); 
        return R.ok().put("data", kepuzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KepuzhishiEntity kepuzhishi){
        EntityWrapper< KepuzhishiEntity> ew = new EntityWrapper< KepuzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kepuzhishi, "kepuzhishi")); 
		KepuzhishiView kepuzhishiView =  kepuzhishiService.selectView(ew);
		return R.ok("查询科普知识成功").put("data", kepuzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KepuzhishiEntity kepuzhishi = kepuzhishiService.selectById(id);
		kepuzhishi.setClicknum(kepuzhishi.getClicknum()+1);
		kepuzhishi.setClicktime(new Date());
		kepuzhishiService.updateById(kepuzhishi);
        return R.ok().put("data", kepuzhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KepuzhishiEntity kepuzhishi = kepuzhishiService.selectById(id);
		kepuzhishi.setClicknum(kepuzhishi.getClicknum()+1);
		kepuzhishi.setClicktime(new Date());
		kepuzhishiService.updateById(kepuzhishi);
        return R.ok().put("data", kepuzhishi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        KepuzhishiEntity kepuzhishi = kepuzhishiService.selectById(id);
        if(type.equals("1")) {
        	kepuzhishi.setThumbsupnum(kepuzhishi.getThumbsupnum()+1);
        } else {
        	kepuzhishi.setCrazilynum(kepuzhishi.getCrazilynum()+1);
        }
        kepuzhishiService.updateById(kepuzhishi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
    	kepuzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kepuzhishi);
        kepuzhishiService.insert(kepuzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
    	kepuzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kepuzhishi);
        kepuzhishiService.insert(kepuzhishi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KepuzhishiEntity kepuzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kepuzhishi);
        kepuzhishiService.updateById(kepuzhishi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kepuzhishiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<KepuzhishiEntity> wrapper = new EntityWrapper<KepuzhishiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kepuzhishiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi, HttpServletRequest request,String pre){
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,KepuzhishiEntity kepuzhishi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "zhishifenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "kepuzhishi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<KepuzhishiEntity> kepuzhishiList = new ArrayList<KepuzhishiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                kepuzhishiList.addAll(kepuzhishiService.selectList(new EntityWrapper<KepuzhishiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<KepuzhishiEntity> ew = new EntityWrapper<KepuzhishiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = kepuzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kepuzhishi), params), params));
        List<KepuzhishiEntity> pageList = (List<KepuzhishiEntity>)page.getList();
        if(kepuzhishiList.size()<limit) {
            int toAddNum = (limit-kepuzhishiList.size())<=pageList.size()?(limit-kepuzhishiList.size()):pageList.size();
            for(KepuzhishiEntity o1 : pageList) {
                boolean addFlag = true;
                for(KepuzhishiEntity o2 : kepuzhishiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    kepuzhishiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(kepuzhishiList.size()>limit) {
            kepuzhishiList = kepuzhishiList.subList(0, limit);
        }
        page.setList(kepuzhishiList);
        return R.ok().put("data", page);
    }





}
