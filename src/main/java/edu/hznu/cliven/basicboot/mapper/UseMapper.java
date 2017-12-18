package edu.hznu.cliven.basicboot.mapper;


import edu.hznu.cliven.basicboot.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UseMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Integer id);

    @Select("SELECT * FROM user WHERE username=#{username}")
    User getByUsername(String username);

    @Insert("INSERT INTO user(username,password) VALUES(#{username}, #{password})")
    void insert(User user);

    @Update("UPDATE user SET username=#{username},password=#{password} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}
