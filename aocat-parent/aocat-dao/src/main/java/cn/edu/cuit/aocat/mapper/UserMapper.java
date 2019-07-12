package cn.edu.cuit.aocat.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.cuit.aocat.entity.User;

public interface UserMapper {

	@Select("select user_id as id,user_name as name,user_pass as pass,user_phone as phone,user_address as address from users where user_name = #{name} and user_pass = #{pass}")
	User findByNameAndPass(@Param("name") String name, @Param("pass") String pass);
	@Select("select user_id as id,user_name as name,user_pass as pass,user_phone as phone,user_address as address from users where user_id=#{id}")
	User findByUserId(int id);
}
