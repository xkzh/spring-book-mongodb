package com.xk.mongodb.controller;

import com.xk.mongodb.response.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xk on 2019-11-23 14:33:46
 */
@RestController
public class HelloWorldController {

    private static final Logger log= LoggerFactory.getLogger(HelloWorldController.class);

    private static final String Prefix="hello-world";

    /**
     * 测试SpringBoot整合是否有问题-hello world
     * @return
     */
    @RequestMapping(value = Prefix+"/mongo",method = RequestMethod.GET)
    public BaseResult rabbitmq(){
        String str="spring boot整合Mongodb";
        return BaseResult.success(str);
    }


}
