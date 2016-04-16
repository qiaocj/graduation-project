package qcj.graduation.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import qcj.graduation.model.SignIn;

import java.util.List;

/**
 * Created by Administrator on 2016/4/10.
 */
public interface SignInMapper {
    @Select("SELECT * FROM sign_in where code = #{code}")
    @Results(value = {
            @Result(property = "classCode", column = "class_code")
    })
    SignIn isSucess(@Param("code") Long code);

    @Select("SELECT DISTINCT class_code FROM sign_in ")
    List<Long> getClassCode();

    @Select("SELECT DISTINCT code FROM sign_in ")
    List<Long> getStudentCodes();
}
