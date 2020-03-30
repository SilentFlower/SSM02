package xyz.silentflower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.silentflower.dao.ProductDao;
import xyz.silentflower.domain.Product;
import xyz.silentflower.service.ProductService;

import java.util.List;
import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2020/3/20 00:00:28
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Product product) {
        product.setId(UUID.randomUUID().toString().replace("-",""));
        productDao.save(product);
    }


}
