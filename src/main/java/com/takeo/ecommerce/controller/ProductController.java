package com.takeo.ecommerce.controller;


import com.takeo.ecommerce.entity.Product;

import com.takeo.ecommerce.service.impl.CategoryService;
import com.takeo.ecommerce.service.impl.ProductServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/search")
    public String searchProducts(@RequestParam("search") String search, HttpSession session, Model model) {
        List<Product> list = productService.searchProducts(search);
        if (list != null) {
            model.addAttribute("products", list);
            return "Search-Products-Display";
        }
        session.setAttribute("msg", "product not found");

        return "/";

    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/")
    public String main() {

        return "index2";
    }

    @GetMapping("/products")
    public String findAllProducts(@NotNull Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "Products";
    }

    @GetMapping("/UserProducts")
    public String findProductsForUser(@NotNull Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "Dashbord";
    }

    @GetMapping("/New-UserProducts")
    public String findProductsForNewUser(@NotNull Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "NewUser-Product-Display";
    }

    @GetMapping("/product/{id}")
    public String findProduct(@PathVariable Long id, @NotNull Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "list-Products";
    }

    @GetMapping("remove-product/{id}")
    public String deleteProduct(@PathVariable Long id, @NotNull Model model) {
        productService.deleteProduct(id);
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }




    @PostMapping("/save-product")
    public String addProduct(@ModelAttribute("product") @Valid Product product,
                             BindingResult bindingResult,
                             @RequestParam("image") @NotNull MultipartFile image,
                             Model model) {
             /* if(bindingResult.hasErrors()){
              model.addAttribute("product",product);
              return "redirect:/add-product";
                 }*/

        // Save the product to the database
        Product save = productService.createProduct(product);
        product.setImage(image.getOriginalFilename());
        if (save != null) {
            try {
                // Define the directory to save the uploaded image
                String uploadDir = "static/uploadImage";
                String absolutePath = new ClassPathResource(uploadDir).getFile().getAbsolutePath();

                // Create the directory if it doesn't exist
                File directory = new File(absolutePath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Generate a unique file name
                String fileName = image.getOriginalFilename();

                // Save the image file to disk
                Path path = Paths.get(absolutePath + File.separator + fileName);
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                // Update the product's image URL
                product.setImage(fileName);
                productService.updateProduct(product);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        model.addAttribute("msg", "Product added successfully!");

        return "redirect:/products";
    }

    @GetMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Long id, @NotNull Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "update-product";
    }
    @GetMapping("/add-product")
    public String addProduct(Product product, @NotNull Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "addProduct";
    }
    @PostMapping("/save-update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam("image")//@valid
    @NotNull MultipartFile image, Product product,
                                @NotNull BindingResult result, Model model) {
               /* if (result.hasErrors()) {
                 return "update-product";
                       }*/

        Product save = productService.updateProduct(product);
        product.setImage(image.getOriginalFilename());
        if (save != null) {
            try {
                // Define the directory to save the uploaded image
                String uploadDir = "static/uploadImage";
                String absolutePath = new ClassPathResource(uploadDir).getFile().getAbsolutePath();

                // Create the directory if it doesn't exist
                File directory = new File(absolutePath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Generate a unique file name
                String fileName = image.getOriginalFilename();

                // Save the image file to disk
                Path path = Paths.get(absolutePath + File.separator + fileName);
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                // Update the product's image URL
                product.setImage(fileName);
                productService.updateProduct(product);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        model.addAttribute("products", productService.findAllProducts());
        return "redirect:/products";
    }

    /*@GetMapping("/Buy/{productId}")
    public String buyProductById(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.findProductById(productId);
        if (product != null) {
            BigDecimal price=product.getPrice();
            model.addAttribute("products",price);
            return "redirect:/order";}
          return "redirect:/products";
        }*/
    @GetMapping("/update-image/{id}")
    public String updateImage(@PathVariable Long id, @NotNull Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "update-product";
    }
    }




