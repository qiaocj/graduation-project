package qcj.graduation.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/11.
 */
@Data
public class Student implements Serializable {

    private Long id;

    private Long code;

    private String name;

    private Long classCode;

    private String cellphone;

    private String photo;

    private Date time;

}
