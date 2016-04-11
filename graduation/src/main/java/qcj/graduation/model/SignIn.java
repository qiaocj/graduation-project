package qcj.graduation.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/10.
 */
@Data
public class SignIn implements Serializable {
    private Long id;
    private Long code;
    private Long classCode;
}
