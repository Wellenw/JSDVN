package cn.tedu.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    private String dirPath = "D:/file";


    @PostMapping("upload")
    public String upload(MultipartFile picFile) throws IOException {
        //原始文件名
        String fileName = picFile.getOriginalFilename();
        //获得后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        System.out.println("new name is"+fileName);
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }

        String filePath = dirPath + "/" +fileName;
        picFile.transferTo(new File(filePath));
        return fileName;
    }

    @DeleteMapping("remove")
    public void remove(String name){
        String filePath = dirPath+"/"+name;
        File file = new File (filePath);
        if(file.exists()){
            file.delete();
        }

    }



}
