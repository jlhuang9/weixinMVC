package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.lianchuang.model.Goodskind;
import com.lianchuang.util.MessageUtil;
import com.lianchuang.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.HTTP;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
@Service
public class GoodskindService {
    @Resource
    private IGoodskind iGoodskind;
    public JSONObject findGoodskindBySuId(PageBounds pageBounds, String su_id){
        List<Goodskind> list = iGoodskind.findGoodskindBySuId(pageBounds,su_id);
        PageList pageList =null;
        if (list.size() > 0) {
            pageList = (PageList) list;
        }
        return pageUtil.pageFormat(pageList);
    }
    public JSONObject findGoodskindallBySuId(String su_id){
        JSONObject jb = new JSONObject();
        jb.put("status","1");
        jb.put("rows",JSONArray.fromObject(iGoodskind.findGoodskindallBySuId(su_id)));
        return jb;
    }
    public List<Goodskind> findGoodskindlistBySuId(String su_id){

        return iGoodskind.findGoodskindallBySuId(su_id);
    }


    public String addGoodsKind(HttpServletRequest request,Goodskind goodskind) {
        try {
            JSONObject jb = JSONObject.fromObject(request.getSession().getAttribute("user"));
            goodskind.setSu_id(jb.getInt("id"));
            int i = iGoodskind.addGoodsKind(goodskind);
            if(i==1){
                return ResponseUtil.MESSAGE_ADD_TRUE;
            }
            return  ResponseUtil.MESSAGE_ADD_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_ADD_ERROR;
        }
    }

    public String upGoodsKindById(Goodskind goodskind) {
        try {
            int i = iGoodskind.upGoodsKindById(goodskind);
            if(i==1){
                return ResponseUtil.MESSAGE_UP_TRUE;
            }
            return  ResponseUtil.MESSAGE_UP_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_UP_ERROR;
        }
    }

    public String delGoodsKindByid( String[] id) {
        try {
            int i = iGoodskind.delGoodsKindByid(id);
            if(i!=0){
                return ResponseUtil.MESSAGE_DEL_TRUE;
            }
            return  ResponseUtil.MESSAGE_DEL_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_DEL_ERROR;
        }
    }


}
