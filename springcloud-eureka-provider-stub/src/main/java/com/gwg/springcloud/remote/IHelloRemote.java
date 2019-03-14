package com.gwg.springcloud.remote;

import com.gwg.springcloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="service-provider")
public interface IHelloRemote {

    @RequestMapping(value = "/user/{name}/{age}", method = RequestMethod.GET)
    String printUserInfo(@PathVariable("name") String name, @PathVariable("age") int age);

    @RequestMapping(value="/add", method = RequestMethod.POST)
    String addUser(@RequestBody User user);

    /*打印出微服务信息*/
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info();

}
