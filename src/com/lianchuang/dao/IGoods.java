package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lianchuang.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
@Repository
public interface IGoods {
    List<Goods> findGoodsBySuId(PageBounds pageBounds, String su_id);

    int addGoods(Goods goods);

    int upGoodsById(Goods goods);

    int delGoodsByid( String[] id);

    List<Goods> findgoodsByKiId(String ki_id);

    List<Goods> findgoodsallBySuId(int su_id);
}
