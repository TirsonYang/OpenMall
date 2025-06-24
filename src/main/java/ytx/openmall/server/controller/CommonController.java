package ytx.openmall.server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ytx.openmall.common.result.Result;
import ytx.openmall.common.util.OssUtils;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    private OssUtils ossUtils;

    @PostMapping("/upload")
    Result upload(MultipartFile file){
        if (file==null){
            log.info("上传文件为空");
        }else {
            log.info("上传文件：{}",file);
        }

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //截取文件名后缀
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接上传名称
        String newFileName = UUID.randomUUID() + extension;
        //上传文件，返回请求路径
        String url;
        try {
            url=ossUtils.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Result.success(url);

    }



}
