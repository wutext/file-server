package com.myself.fileserver.app;

import com.myself.fileserver.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/uploadView")
    public String uploadView() {

        return "/file/uploadView";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        String filePath="src/main/resources/static/upload/"; //保存到当前项目中upload文件夹中
        try {
            /*FileUtil.uploadFile(file.getBytes(), filePath, fileName);*/
        } catch (Exception e) {
            logger.info("error");
        }

        return "/view/index";
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxUpload", method = RequestMethod.POST)
    public String ajaxUpLoad(HttpServletRequest request, MultipartFile file) {
        String contentType = file.getContentType();
        String fileName = System.currentTimeMillis()+"-"+file.getOriginalFilename();

        String filePath="src/main/resources/static/upload/"; //保存到当前项目中upload文件夹中
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            return fileName;
        } catch (Exception e) {
            logger.info("上传错误");
        }
        return "error";
    }
}
