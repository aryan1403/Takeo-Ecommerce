/*package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.entity.Images;
import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.repository.uploadRepository;
import com.takeo.ecommerce.service.impl.ProductServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class ImageController {
    @Autowired
    private ProductServiceImpl productService;

    //@Autowired
    //private uploadRepository uploadRepo;

   /* @GetMapping("/imageview")
    public String index(Model m) {

        List<Images> list = uploadRepo.findAll();

        m.addAttribute("list", list);

        return "image";
    }

   /* @PostMapping("/imageUpload")
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

       // Autowire the product repository


      // @PostMapping("/products/{id}/upload")
       //public String uploadProductImage(@PathVariable("id") Long id, @RequestParam("file") @NotNull MultipartFile file) throws IOException //throws IOException
    {
           // Retrieve the product from the database
           Product product =productService.findProductById(id);//.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            String randomNumber = String.format("%04d", new Random().nextInt(10000));
            String fileName = randomNumber + "_" + file.getOriginalFilename();
           // Save the uploaded image to the local folder
             Path imagePath = Paths.get("uploads", fileName);
           Files.copy(file.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

           // Set the image file name or path in the product entity
           product.setImage(fileName);

           // Save the updated product to the database
           productService.createProduct(product);

           return "redirect:/products" + id; // Redirect to the product details page or any other appropriate page
       }
   }
*/

