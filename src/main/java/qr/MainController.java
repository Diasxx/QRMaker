package qr;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Base64;

@Controller
public class MainController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

    @GetMapping(value = "/")
    public String home(Model model){

        String url = "https://t.me/Diasxsh";
        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = GenerateQRCode.getQRCodeImage(url,250,250);

            // Generate and Save Qr Code Image in static/image folder
            //GenerateQRCode.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("url",url);
        //model.addAttribute("github",github);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }

    @PostMapping(value = "/makeQr")
    public String getQRCode(@RequestParam(name = "url") String url, Model model){

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = GenerateQRCode.getQRCodeImage(url,250,250);

            // Generate and Save Qr Code Image in static/image folder
            //GenerateQRCode.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("url",url);
        //model.addAttribute("github",github);
        model.addAttribute("qrcode",qrcode);

        return "qrcode";
    }
}
