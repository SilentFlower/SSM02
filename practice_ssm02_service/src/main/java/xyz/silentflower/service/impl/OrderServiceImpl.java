package xyz.silentflower.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.silentflower.dao.OrderDao;
import xyz.silentflower.domain.Orders;
import xyz.silentflower.service.OrderService;

import java.util.List;

/**
 * @author SiletFlower
 * @date 2020/3/21 10:05:52
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
   @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }


}
