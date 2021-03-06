package com.luna.order.service;

import com.luna.order.mapper.OrderMapper;
import com.luna.order.entity.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 12:11:51
 */
public interface OrderService {

    /**
     * 通过主键查询数据
     *
     * @param id 主键
     * @return 对象
     */
    Order getById(Long id);

    /**
     * 通过实体不为空的属性作为筛选条件查询单个
     *
     * @param order 条件
     * @return 对象
     */
    Order getByEntity(Order order);

    /**
     * 通过实体不为空的属性作为筛选条件查询列表
     *
     * @param order 条件
     * @return 对象列表
     */
    List<Order> listByEntity(Order order);

    /**
     * 条件分页查询
     *
     * @param order 查询条件
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo listPageByEntity(int page, int pageSize, Order order);

    /**
     * 条件分页查询
     *
     * @param page 起始标号
     * @param pageSize 查询条目
     * @return 对象列表
     */
    PageInfo listPage(int page, int pageSize);

    /**
     * Id列表查询对象列表
     *
     * @param ids Id列表
     * @return 对象列表
     */
    List<Order> listByIds(List<Long> ids);

    /**
     * 插入
     *
     * @param order 对象
     * @return 影响行数
     */
    int insert(Order order);

    /**
     * 列表插入
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int insertBatch(List<Order> list);

    /**
     * 更新
     *
     * @param order 对象
     * @return 影响行数
     */
    int update(Order order);

    /**
     * 列表更新
     *
     * @param list 列表对象
     * @return 影响行数
     */
    int updateBatch(List<Order> list);

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 条件删除
     *
     * @param order 对象
     * @return 影响行数
     */
    int deleteByEntity(Order order);

    /**
     * 主键列表删除
     *
     * @param list 主键列表
     * @return 影响行数
     */
    int deleteByIds(List<Long> list);

    /**
     * 数据条目
     *
     * @return 影响行数
     */
    int countAll();

    /**
     * 条件查询数目
     *
     * @param order 对象
     * @return 影响行数
     */
    int countByEntity(Order order);
}
