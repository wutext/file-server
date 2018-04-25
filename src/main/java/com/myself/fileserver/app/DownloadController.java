package com.myself.fileserver.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/download")
public class DownloadController {
    

    @RequestMapping("/downloadView")
    public String fileUpload() {

        return "/view/downloadView";
    }
}
