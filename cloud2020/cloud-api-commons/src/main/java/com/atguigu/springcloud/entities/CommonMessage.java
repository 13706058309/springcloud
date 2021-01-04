package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonMessage<T> implements Serializable {
    private Integer code;
    private String Message;
    private T date;

    public CommonMessage(Integer code, String message){

        this.code = code;
        this.Message = message;
    }
}
