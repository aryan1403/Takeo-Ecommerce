/*package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.entity.Images;
import com.takeo.ecommerce.entity.Product;
import com.takeo.ecommerce.entity.Product1;
import com.takeo.ecommerce.repository.ProductRepository;
import com.takeo.ecommerce.repository.ProductRepository1;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class PicController {

    @Autowired
    private ProductRepository1 productRepository;

    @GetMapping("/pic")
    public String getProductForm() {
        return "picsave";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") @Valid Product1 product,
                             BindingResult bindingResult,
                             @RequestParam("image")  MultipartFile image,
                             Model model) {

        Product1 check = productRepository.save(product);

        product.setImage(image.getOriginalFilename()); // Save the image file name
        if (check != null) {
            try {
                // Define the directory to save the uploaded image
                String uploadDir = "static/uploadImage";
                String absolutePath = new ClassPathResource(uploadDir).getFile().getAbsolutePath();

                // Create the directory if it doesn't exist
                File directory = new File(absolutePath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the image file to disk
                Path path = Paths.get(absolutePath + File.separator + image.getOriginalFilename());
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("message", "Product added successfully!");
        return "picsave";
    }

    @GetMapping("/productView")
    public String product1(@NotNull Model m) {

        List<Product1> ll = productRepository.findAll();

        m.addAttribute("list", ll);
        return "picsave";

    }
}*/
