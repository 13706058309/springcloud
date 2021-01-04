package com.atguigu.springcloud.Mapper;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    int create(Payment payment);

    Payment findPaymentByID(@Param("id") Long id);

}
