package com.andreh.apirequest.mappers;


import com.andreh.apirequest.models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("Select id,name,email from users WHERE id = #{id}")
    User getUserById(@Param("id") Long id);

    @Select("Select * from users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUser(User user);
}
