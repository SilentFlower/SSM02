package xyz.silentflower.service;

import org.springframework.stereotype.Service;
import xyz.silentflower.domain.Product;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/19 23:53:21
 * @description
 */

public interface ProductService {
    public List<Product> findAll() throws Exception;


    public void save(Product product);
}
