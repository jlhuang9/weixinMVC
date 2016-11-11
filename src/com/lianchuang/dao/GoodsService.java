package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.lianchuang.model.Goods;
import com.lianchuang.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
@Service
public class GoodsService {
    @Resource
    private IGoods igoods;
    public JSONObject findgoodsBySuId(PageBounds pageBounds, String su_id){
        List<Goods> list = igoods.findGoodsBySuId(pageBounds,su_id);
        PageList pageList =null;
        if (list.size() > 0) {
            pageList = (PageList) list;
        }
        return pageUtil.pageFormat(pageList);
    }

    public JSONArray findgoodsallBySuId(int su_id){
        List<Goods> list = igoods.findgoodsallBySuId(su_id);
        return JSONArray.fromObject(list);
    }

    public JSONArray findgoodsByKiId(String ki_id){
        List<Goods> list = igoods.findgoodsByKiId(ki_id);
        return JSONArray.fromObject(list);
    }

    public String addGoods(HttpServletRequest request, Goods goods) {
        try {
            int i = igoods.addGoods(goods);
            if(i==1){
                return ResponseUtil.MESSAGE_ADD_TRUE;
            }
            return  ResponseUtil.MESSAGE_ADD_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_ADD_ERROR;
        }
    }

    public String upGoodsById(Goods goods) {
        try {
            int i = igoods.upGoodsById(goods);
            if(i==1){
                return ResponseUtil.MESSAGE_UP_TRUE;
            }
            return  ResponseUtil.MESSAGE_UP_FALSE;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.MESSAGE_UP_ERROR;
        }
    }

    public String delGoodsByid( String[] id) {
        try {
            int i = igoods.delGoodsByid(id);
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
