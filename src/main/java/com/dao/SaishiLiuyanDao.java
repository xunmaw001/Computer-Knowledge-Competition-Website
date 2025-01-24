package com.dao;

import com.entity.SaishiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaishiLiuyanView;

/**
 * 赛事留言 Dao 接口
 *
 * @author 
 */
public interface SaishiLiuyanDao extends BaseMapper<SaishiLiuyanEntity> {

   List<SaishiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
