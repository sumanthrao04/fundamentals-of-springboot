
// spring data Jpa hands on by using mysql
//no controller layer
package com.sumanth.fundamentals_of_springboot.repository;

import com.sumanth.fundamentals_of_springboot.project1.entity.Product;
import com.sumanth.fundamentals_of_springboot.project1.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("Product 1");
        product.setActive(true);
        product.setDescription("first product");
        product.setImageUrl("product1.png");
        product.setPrice(new BigDecimal(1000));
        product.setStockUnit("2000 unit");

        //save product
       Product savedObject=  repository.save(product);

        //display product
        System.out.println("Id of the product 1 : " + savedObject.getId());
        System.out.println(savedObject.toString());
        System.out.println("Save method Execution");
    }

    @Test
    void updateUsingSaveMethod(){

        // find or retrieve an entity by id
        Long id =1L;
        Product product =repository.findById(id).get();

        //update entity information
        product.setName("updated product 1");
        product.setDescription("Update product 1 description ");

        //save updated entity
        repository.save(product);

    }

    @Test
    void findByIDMethod(){
        Long Id = 1L;
      Product product =  repository.findById(Id).get();
        System.out.println(" The product is : " + product.toString());


    }

    @Test
    void saveAllMethod(){

        // create product
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setActive(true);
        product2.setDescription("Second product");
        product2.setImageUrl("product2.png");
        product2.setPrice(new BigDecimal(2000));
        product2.setStockUnit("100 unit");


        // create product
        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setActive(true);
        product3.setDescription("third product");
        product3.setImageUrl("product3.png");
        product3.setPrice(new BigDecimal(300));
        product3.setStockUnit("3000 unit");

        repository.saveAll(List.of(product2,product3));
    }

    @Test
    void findAll(){

      List<Product> allProduct= repository.findAll();

      allProduct.forEach((product -> System.out.println(product.getName())));
    }

    @Test
    void deleteById(){
        Long id = 2L;

        repository.deleteById(id);
        System.out.println(" The id got deleted" +id);

    }

    @Test
    void deleteMethod(){
       Long id = 3L;
       Product product = repository.findById(id).get();
       repository.delete(product);

    }

    @Test
    void deleteALlMethod(){
        //delete all rows
      //  repository.deleteAll();

        //delete the rows based on the specified by ID
        Product product1 = repository.findById(6L).get();
        Product product2 = repository.findById(7L).get();

        repository.deleteAll(List.of(product1,product2));
    }

    @Test
    void count(){

      Long noOFCount=  repository.count();
        System.out.println("The total Count : -> " + noOFCount);

    }

    @Test
    void exixtsByIdMethod(){

        boolean isProductThere = repository.existsById(8L);
        System.out.println(" The Product checking with ID : " +isProductThere);
    }


}