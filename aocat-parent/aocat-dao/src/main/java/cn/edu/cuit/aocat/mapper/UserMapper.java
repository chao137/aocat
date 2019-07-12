package cn.edu.cuit.aocat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.cuit.aocat.entity.User;

public interface UserMapper {

	@Select("select user_id as id,user_name as name,user_pass as pass,user_phone as phone,user_address as address from users where user_name = #{name} and user_pass = #{pass}")
	User findByNameAndPass(@Param("name") String name, @Param("pass") String pass);
	@Select("select user_id as id,user_name as name,user_pass as pass,user_phone as phone,user_address as address from users where user_id=#{id}")
	User findByUserId(int id);

	@Insert("insert into users(user_id,user_name,user_pass,user_address,user_phone) values(default,#{name},#{pass},#{address},#{phone})")
	void insertUser(User user);
	@Select("select count(*) from users where user_name = #{name}")
	int findByName(String name);
	@Update("update users set user_name=#{name},user_address=#{address},user_phone=#{phone} where user_id=#{id}")
	void updateUserInfo(User user);
}
