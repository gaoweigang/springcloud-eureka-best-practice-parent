package com.gwg.springcloud.consumer;


import com.gwg.springcloud.model.User;
import com.gwg.springcloud.remote.IHelloRemote;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${name:高伟刚}")
    private String name;

    @Autowired
    private IHelloRemote helloRemote;


    /**
     * 应用Consumer调用应用Provider的服务printServiceProvider
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        System.out.println("调用hello开始 start ****************");
        User user = new User();
        user.setName("高红程");
        user.setAge(11);
        return helloRemote.addUser(user);
    }

    @RequestMapping(value="/printUser", method = RequestMethod.GET)
    public String printUser(){
        System.out.println("调用helloRemote开始 start.......");
        return helloRemote.printUserInfo("gaoweigang", 22);
    }




}