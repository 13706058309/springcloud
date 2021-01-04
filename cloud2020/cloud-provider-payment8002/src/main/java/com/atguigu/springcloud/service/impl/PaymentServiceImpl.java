package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.Mapper.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment findPaymentByID(Long id) {
        return paymentMapper.findPaymentByID(id);
    }
}
