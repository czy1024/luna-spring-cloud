package com.luna.order.controller;

import com.github.pagehelper.PageInfo;
import com.luna.commons.dto.ResultDTO;
import com.luna.commons.dto.constant.ResultCode;
import com.luna.order.entity.Order;
import com.luna.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-02-05 00:12:20
 */
@Api(tags = "订单(Order)")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "根据id查询订单")
    @GetMapping("/get/{id}")
    public ResultDTO<Order> getById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, order);
    }

    @ApiOperation(value = "查询全部订单")
    @GetMapping("/get")
    public ResultDTO<Order> getByEntity(Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.getByEntity(order));
    }

    @ApiOperation(value = "条件查询订单")
    @GetMapping("/list")
    public ResultDTO<List<Order>> list(Order order) {
        List<Order> orderList = orderService.listByEntity(order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderList);
    }

    @ApiOperation(value = "分页条件查询订单")
    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Order order) {
        PageInfo pageInfo = orderService.listPageByEntity(page, size, order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "分页查询订单")
    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = orderService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @ApiOperation(value = "插入订单")
    @PostMapping("/insert")
    public ResultDTO<Order> insert(@RequestBody Order order) {
        orderService.insert(order);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, order);
    }

    @ApiOperation(value = "批量插入订单")
    @PostMapping("/insertBatch")
    public ResultDTO<List<Order>> insert(@RequestBody List<Order> list) {
        orderService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @ApiOperation(value = "更新订单")
    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.update(order) == 1);
    }

    @ApiOperation(value = "批量更新订单")
    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Order> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.updateBatch(list) == list.size());
    }

    @ApiOperation(value = "主键删除 订单")
    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.deleteById(id) == 1);
    }

    @ApiOperation(value = "条件删除订单")
    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.deleteByEntity(order) == 1);
    }

    @ApiOperation(value = "批量删除订单")
    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = orderService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @ApiOperation(value = "记录订单个数")
    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, orderService.countAll());
    }

    @ApiOperation(value = "条件记录订单个数")
    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Order order) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            orderService.countByEntity(order));
    }
}
