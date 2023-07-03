package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.entity.Images;
import com.takeo.ecommerce.repository.uploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private uploadRepository uploadRepo;

    @GetMapping("/imageview")
    public String index(Model m) {

        List<Images> list = uploadRepo.findAll();

        m.addAttribute("list", list);

        return "image";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam MultipartFile img, HttpSession session) {

        Images im = new Images();

        im.setImageName(img.getOriginalFilename());


        Images uploadImg = uploadRepo.save(im);

        if (uploadImg != null) {
            try {

                File saveFile = new ClassPathResource("static/uploadImage").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                //System.out.println(path);
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("msg", "Image Upload Sucessfully");

        return "redirect:/imageview";
    }

}
