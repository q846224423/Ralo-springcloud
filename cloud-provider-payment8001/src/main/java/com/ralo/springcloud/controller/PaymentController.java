package com.ralo.springcloud.controller;

import com.ralo.springcloud.entity.CommonResult;
import com.ralo.springcloud.entity.PaymentEntity;
import com.ralo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.DiscoveredEndpoint;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommonResult insert(@RequestBody PaymentEntity paymentEntity){
         int result = paymentService.insert(paymentEntity);
        log.info("插入结果****"+result);
         if(result>0){
             return new CommonResult(200,"修改成功+serverPort"+serverPort,result);
         }else {
                return new CommonResult(500,"修改失败",null);
         }
    }

    @GetMapping(value = "/payment/getid/{id}")
    public CommonResult getbyid(@PathVariable("id") Long id){
       PaymentEntity paymentEntity=  paymentService.getId(id);
        log.info("查询结果****"+paymentEntity.toString());
        if(paymentEntity != null){
            return new CommonResult(200,"查询成功+serverPort"+serverPort,paymentEntity);
        }else{
            return new CommonResult(500,"未查询到",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("---element: "+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost()+"主机名"+"\t"+instance.getServiceId()+"服务id"+"\t"+instance.getPort()+"端口号"+"\t"+instance.getUri()+"uri地址");
        }
        return this.discoveryClient;
    }
}
