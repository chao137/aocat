package cn.edu.cuit.aocat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.edu.cuit.aocat.entity.User;

public interface UserMapper {

	@Select("select * from users where user_name = #{name} and user_pass = #{pass}")
	User findByNameAndPass(@Param("name") String name, @Param("pass") String pass);

	@Insert("insert into users(user_id,user_name,user_pass,user_address,user_phone) values(default,#{name},#{pass},#{address},#{phone})")
	void insertUser(User user);
}
