package io.kodlama.Northwind.business.abstracts;

import io.kodlama.Northwind.core.utilities.results.DataResult;
import io.kodlama.Northwind.core.utilities.results.Result;
import io.kodlama.Northwind.entities.concretes.Product;
import io.kodlama.Northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    DataResult<List<Product>> getAllSortedASC(); //Sıralama
    DataResult<List<Product>> getAllSortedDESC();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getByDto();


}
