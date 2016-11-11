package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2016/11/3.
 */
public class pageUtil {
    public static JSONObject pageFormat(PageList pageList){
        JSONObject jb = new JSONObject();
        if(pageList!=null&&!"".equals(pageList)){
            jb.put("result",1);
            jb.put("row", JSONArray.fromObject(pageList).toString());
            jb.put("page",pageList.getPaginator().getPage());
            jb.put("totalPages",pageList.getPaginator().getTotalPages());
            jb.put("totalCount",pageList.getPaginator().getTotalCount());
        }else{
            jb.put("result",2);
        }
        return jb;
    }
}
