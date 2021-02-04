package com.luna.order.service.impl;

import com.luna.order.mapper.OrderMapper;
import com.luna.order.service.OrderService;
import com.luna.order.entity.Order;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 00:12:20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource(type = OrderMapper.class)
    private OrderMapper orderMapper;

    @Override
    public Order getById(Long id) {
        return orderMapper.getById(id);
    }

    @Override
    public Order getByEntity(Order order) {
        return orderMapper.getByEntity(order);
    }

    @Override
    public List<Order> listByEntity(Order order) {
        return orderMapper.listByEntity(order);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Order order) {
        PageHelper.startPage(page, pageSize);
        List<Order> list = orderMapper.listByEntity(order);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Order> list = orderMapper.listByEntity(new Order());
        return new PageInfo(list);
    }

    @Override
    public List<Order> listByIds(List<Long> ids) {
        return orderMapper.listByIds(ids);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int insertBatch(List<Order> list) {
        return orderMapper.insertBatch(list);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public int updateBatch(List<Order> list) {
        return orderMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Order order) {
        return orderMapper.deleteByEntity(order);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return orderMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return orderMapper.countAll();
    }

    @Override
    public int countByEntity(Order order) {
        return orderMapper.countByEntity(order);
    }

}