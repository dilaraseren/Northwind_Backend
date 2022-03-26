package io.kodlama.Northwind.api.controllers;
import io.kodlama.Northwind.business.abstracts.ProductService;
import io.kodlama.Northwind.core.utilities.results.DataResult;
import io.kodlama.Northwind.core.utilities.results.Result;
import io.kodlama.Northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    private ProductService productService;

    @GetMapping("getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId
                (productName, categoryId);
    }

    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(String productName){
        return this.productService.getByProductNameContains((productName));
    }

    @GetMapping("getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("getAsc")
    public DataResult<List<Product>> getAllSortedASC (){
        return this.productService.getAllSortedASC();
    }

    @GetMapping("getDesc")
    public DataResult<List<Product>> getAllSortedDESC (){
        return this.productService.getAllSortedDESC();
    }
}
