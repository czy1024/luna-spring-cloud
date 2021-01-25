package com.luna.payment.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author luna
 * @date 2020-02-18 10:40
 */
@Service
@DefaultProperties(defaultFallback = "paymentInfoTimeoutGlobleHandler")
public class PaymentService {

    /**
     * 线程控制
     * 
     * @param id
     * @return
     */
    public String paymentInfoSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoSuccess，id:" + id;
    }

    /**
     * 超时访问的方法
     * 
     * @param time 超时时长
     * @param id 线程Id
     * @return
     */
    @HystrixCommand(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutGlobal(Long time, Integer id) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_Timeout，id:" + id + "耗时" + time + "秒钟--";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutSingleHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeoutSingle(Long time, Integer id) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_Timeout，id:" + id + "耗时" + time + "秒钟--";
    }

    /**
     * 特殊超时访问的方法 降级处理
     *
     * @param id 线程Id
     * @return
     */
    public String paymentInfoTimeoutSingleHandler(Long time, Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfoTimeoutSingleHandler，id:" + id + "耗时" + time
            + "秒钟-- 😭";
    }

    /**
     * 全局超时访问的方法 降级处理
     *
     * @return
     */
    public String paymentInfoTimeoutGlobleHandler() {
        return "系统错误，请稍后再试 😭";
    }
}
