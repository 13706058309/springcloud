package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonMessage;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonMessage create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果"+result);
        if(result>0){
            return new CommonMessage(200,"插入成功"+port,result);
        }else{
            return new CommonMessage(444,"插入失败"+port,null);
        }
    }

    @GetMapping(value="/payment/getByID/{id}")
    public CommonMessage getPaymentByID(@PathVariable("id") Long id){
        Payment payment = paymentService.findPaymentByID(id);
        log.info("查询结果"+payment);
        if(payment!=null){
            return new CommonMessage(200,"查询成功"+port,payment);
        }else{
            return new CommonMessage(444,"为找到对应ID数据"+port,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
