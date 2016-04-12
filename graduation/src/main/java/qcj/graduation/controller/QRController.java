package qcj.graduation.controller;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import qcj.graduation.service.QRservice;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Qiao on 2016/4/12.
 */
@RestController
@RequestMapping("/qr")
public class QRController {
    @Autowired
    private QRservice qRservice;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String createQR(@RequestBody Map<String,Object> map) throws IOException, WriterException {
        String code = map.get("code").toString();
        String path = qRservice.createQR(code);
        return  path;
    }
}
