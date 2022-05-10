package com.cxl.controller;

import com.cxl.dto.ResponseBean;
import com.cxl.utils.FileUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequiresAuthentication


@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileUtil fileUtil;

    /**
     * 上传文件
     */
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public ResponseBean<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String result;
        try {
            String path = fileUtil.upload(file);
            if (path != null && path.length() > 0) {
                result = path;
            } else {
                result = "上传失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "服务异常";
        }
        return ResponseBean.success(result);
    }

    /**
     * 文件删除
     */
    @DeleteMapping("/{path}")
    public ResponseEntity<String> deleteByPath(@PathVariable String path) {
        fileUtil.deleteFile(path);
        return ResponseEntity.ok("SUCCESS");
    }

}
