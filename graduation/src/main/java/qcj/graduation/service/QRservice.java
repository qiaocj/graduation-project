package qcj.graduation.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by Qiao on 2016/4/12.
 */
@Service
public class QRservice {

    public String createQR(String code) throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String format = "jpg";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, width, height, hints);
        File outputFile = new File("src/main/webapp/QRimages/" + code + ".jpg");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        String path = code + ".jpg";
        return path;
    }
}
