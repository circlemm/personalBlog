package com.dkt.blogboot.mapper;
import com.dkt.blogboot.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    ArticleTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);

    int deleteByAid(@Param("aid")Integer aid);

    List<ArticleTag> selectByTid(@Param("tid")Integer tid);


}