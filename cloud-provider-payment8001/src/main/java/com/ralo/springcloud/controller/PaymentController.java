package com.ralo.springcloud.controller;

import com.ralo.springcloud.entity.CommonResult;
import com.ralo.springcloud.entity.PaymentEntity;
import com.ralo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: com.ralo.springcloud.controller
 * @author: Ralo
 * @DATE: 2020/7/21
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/insert")
    public CommonResult insert(@RequestBody PaymentEntity paymentEntity){
         int result = paymentService.insert(paymentEntity);
        log.info("插入结果****"+result);
         if(result>0){
             return new CommonResult(200,"修改成功",result);
         }else {
                return new CommonResult(500,"修改失败",null);
         }
    }

    @GetMapping(value = "/payment/getid/{id}")
    public CommonResult getbyid(@PathVariable("id") Long id){
       PaymentEntity paymentEntity=  paymentService.getId(id);
        log.info("插入结果****"+paymentEntity.toString());
        if(paymentEntity != null){
            return new CommonResult(200,"查询成功",paymentEntity);
        }else{
            return new CommonResult(500,"未查询到",null);
        }
    }

}
