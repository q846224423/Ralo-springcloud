package com.ralo.springcloud.conrtoller;

import com.ralo.springcloud.entity.CommonResult;
import com.ralo.springcloud.entity.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.ralo.springcloud.conrtoller
 * @author: Ralo
 * @DATE: 2020/7/22
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 调用8001服务，完成修改操作
     * */
    @GetMapping("/consumer/payment/insert")
    public CommonResult<PaymentEntity> insert(PaymentEntity paymentEntity){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",paymentEntity,CommonResult.class);
    }

    /**
     * 调用8001服务，完成查询操作
     * */
    @GetMapping("/consumer/payment/getid/{id}")
    public CommonResult<PaymentEntity> getid(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getid/"+id,CommonResult.class);
    }

}
