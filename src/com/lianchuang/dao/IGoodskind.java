package com.lianchuang.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.lianchuang.model.Goodskind;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/3.
 */
@Repository
public interface IGoodskind {
    List<Goodskind> findGoodskindBySuId(PageBounds pageBounds, String su_id);

    int addGoodsKind(Goodskind goodskind);

    int upGoodsKindById(Goodskind goodskind);

    int delGoodsKindByid( String[] id);

    List<Goodskind> findGoodskindallBySuId(String su_id);
}
