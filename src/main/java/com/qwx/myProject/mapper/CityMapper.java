package com.qwx.myProject.mapper;

import com.qwx.myProject.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: qian
 * @Date: 2018/9/14 16:49
 * @Company Bangsun
 * @Description:
 */
@Mapper
public interface CityMapper {
	@Select("Select *from city where id=#{id}")
	City findById (@Param("id") Integer id);
}
