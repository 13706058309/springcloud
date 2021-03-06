package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonMessage;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonMessage<Payment>   create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonMessage.class);  //写操作
    }


    @GetMapping(value = "/consumer/payment/getByID/{id}")
    public CommonMessage<Payment> getByID(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getByID/"+id,CommonMessage.class);
    }
}
