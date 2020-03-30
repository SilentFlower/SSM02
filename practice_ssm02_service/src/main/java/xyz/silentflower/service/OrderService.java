package xyz.silentflower.service;

import org.springframework.core.annotation.Order;
import xyz.silentflower.domain.Orders;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/21 10:05:39
 * @description
 */
public interface OrderService {

    public List<Orders> findAll(int page,int size);

    public Orders findById(String id);
}
