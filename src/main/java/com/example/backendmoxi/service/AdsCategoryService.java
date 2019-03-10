package com.example.backendmoxi.service;

import com.example.backendmoxi.model.AdsCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdsCategoryService {
	
	@Select("SELECT * FROM `moxi`.`news_category` where id = #{id};")
	AdsCategory findById(AdsCategory adsCategory);
	
	@Select({
		"<script>",
		"SELECT * FROM `moxi`.`news_category`",
		"WHERE state = 1",
			"<when test='name!=null'>",
				"AND name LIKE CONCAT('%',#{name},'%')",
			"</when>",
			"order by addDate desc limit #{start},#{end}",
		"</script>"
	})
	List<AdsCategory> list(AdsCategory adsCategory);
	
	@Select({
		"<script>",
		"SELECT count(*) FROM `moxi`.`news_category`",
		"WHERE state = 1",
			"<when test='name!=null'>",
				"AND name LIKE CONCAT('%',#{name},'%')",
			"</when>",
		"</script>"
	})
	int count(AdsCategory adsCategory);
	
	@Insert("INSERT INTO `moxi`.`news_category` (`id`, `name`, `description`, `image`, `addDate`, `state`) VALUES (null, #{name}, #{description}, #{image}, now(), 1);")
	int insert(AdsCategory adsCategory);
	
	@Update("UPDATE `moxi`.`news_category`SET `name` = #{name}, `description` = #{description}, `image` = #{image} WHERE `id` = #{id};")
	int update(AdsCategory adsCategory);
	
	@Update("UPDATE `moxi`.`news_category`SET `state` = #{state} WHERE `id` = #{id};")
	int updateState(AdsCategory adsCategory);
}
