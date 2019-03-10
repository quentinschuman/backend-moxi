package com.example.backendmoxi.service;

import com.example.backendmoxi.model.Ads;
import com.example.backendmoxi.util.Constant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: backend-moxi
 * User: quent
 * Date: 2018/6/24
 * Time: 10:22
 */
@Mapper
public interface AdsService {

    @Select("SELECT * FROM `moxi`.`news` WHERE id = #{id};")
    Ads findById(Ads ads);

    @Select({
            "<script>",
            "SELECT N.*,C.NAME AS CATEGORYNAME,C.IMAGE AS CATEGORYIMAGE FROM MOXI.NEWS N ",
            "LEFT JOIN MOXI.NEWS_CATEGORY C ON N.CATEGORY = C.ID ",
            "WHERE N.STATE = 1 ",
            "<when test='title!=null'>",
            "AND N.TITLE LIKE CONCAT('%',#{title},'%')",
            "</when>",
            "<when test='category!=0'>",
            "AND category = #{category}",
            "</when>",
            "<when test='commendState!=0'>",
            "AND commendState = #{commendState}",
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByAddDateAsc+"\"'>",
            "order by "+Constant.OrderByAddDateAsc+",addDate desc",
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByAddDateDesc+"\"'>",
            "order by "+Constant.OrderByAddDateDesc,
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByBrowsesDesc+"\"'>",
            "order by "+Constant.OrderByBrowsesDesc+",addDate desc",
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByCommentsDesc+"\"'>",
            "order by "+Constant.OrderByCommentsDesc+",addDate desc",
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByLikesDesc+"\"'>",
            "order by "+Constant.OrderByLikesDesc+",addDate desc",
            "</when>",
            "<when test='orderBy==\""+Constant.OrderByScoreDesc+"\"'>",
            "order by "+ Constant.OrderByScoreDesc+",addDate desc",
            "</when>",
            "limit #{start},#{end}",
            "</script>"
    })
    List<Ads> list(Ads ads);

    @Select({
            "<script>",
            "SELECT COUNT(*) FROM MOXI.NEWS N ",
            "LEFT JOIN MOXI.NEWS_CATEGORY C ON N.CATEGORY = C.ID ",
            "WHERE N.STATE = 1 ",
            "<when test='title!=null'>",
            "AND N.TITLE LIKE CONCAT('%',#{title},'%')",
            "</when>",
            "<when test='category!=0'>",
            "AND category = #{category}",
            "</when>",
            "<when test='commendState!=0'>",
            "AND commendState = #{commendState}",
            "</when>",
            "</script>"
    })
    int count(Ads ads);

    @Insert("INSERT INTO `moxi`.`news` (`id`,`title`,`description`,`category`,`image`,`content`,`addDate`,`updateDate`,`commendState`,`state`,`browses`,`likes`,`comments`,`score`) VALUES (null,#{title},#{description},#{category},#{image},#{content},now(),now(),1,1,0,0,0,0);")
    int insert(Ads ads);

    @Update("UPDATE `moxi`.`news` SET `title` = #{title}, `description` = #{description}, `category` = #{category}, `image` = #{image}, `content` = #{content}, `updateDate` = now()  WHERE `id` = #{id};")
    int update(Ads ads);

    @Update("UPDATE `moxi`.`news` SET `state` = #{state}, `commendState` = #{commendState}, `browses` = #{browses}, `likes` = #{likes}, `comments` = #{comments}, `score` = #{score} WHERE `id` = #{id};")
    int updateState(Ads ads);
}
