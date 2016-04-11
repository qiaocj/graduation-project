package qcj.graduation.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import qcj.graduation.model.User;

/**
 * Created by Administrator on 2016/4/10.
 */
public interface UserMapper {

    @Select("select * from user where user_name = #{userName} AND password = #{password}")
    @Results(value = {
            @Result(property = "userName" ,column = "user_name")
    })
    User getUserDetail(@Param("userName") Long userName,
                       @Param("password") String password);
}
