package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.utils.UUIDUtils;
import com.itheima.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceLoader resourceLoader;
    @PostMapping("/upload")
    public String  upload(MultipartFile icon, HttpSession session) throws IOException {
        InputStream is = icon.getInputStream();
        String uuidName = UploadUtils.getUUIDName(icon.getOriginalFilename());
        String randomDir = UploadUtils.getDir();
        File fileDir = new File("/Users/liwentao/Desktop/uploadfiles"+randomDir);
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File file = new File("/Users/liwentao/Desktop/uploadfiles"+randomDir,uuidName);
        icon.transferTo(file);
        String path = randomDir+"/"+uuidName;
        User user = (User) session.getAttribute("user");
        user.setHeadimg(path);
        userService.update(user);
        return "redirect:/user/userUI";
    }

    @GetMapping("/get/{dir1}/{dir2}/{filename:.+}")
    public ResponseEntity get(@PathVariable String dir1,
                              @PathVariable String dir2,
                              @PathVariable String filename){
        Path path = Paths.get("/Users/liwentao/Desktop/uploadfiles/"+dir1+"/"+dir2,filename);
        Resource resource = resourceLoader.getResource("file:" + path.toString());
        return ResponseEntity.ok(resource);

    }

}
