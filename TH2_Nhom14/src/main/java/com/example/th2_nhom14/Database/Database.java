package com.example.th2_nhom14.Database;


import com.example.th2_nhom14.model.Product;
import com.example.th2_nhom14.repositories.ProductRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // chạy đầu tiên

public class Database {
    private static final Logger logger=  LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepositories repositories){
        return args -> {
            Product productA =new Product("abc","cdv",5);
            Product productB =new Product("cdf","102",7);
        logger.info("insert data"+repositories.save(productA));
            logger.info("insert data"+ repositories.save(productB));
        };
    }

}
