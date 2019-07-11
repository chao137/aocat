package cn.edu.cuit.aocat.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select count(*) from users where user_name = #{name} and user_pass = #{pass}")
	int findByNameAndPass(@Param("name") String name, @Param("pass") String pass);
}
