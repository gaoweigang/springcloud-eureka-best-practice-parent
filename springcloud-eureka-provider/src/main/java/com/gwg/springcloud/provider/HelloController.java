package com.gwg.springcloud.provider;

import com.gwg.springcloud.model.User;
import com.gwg.springcloud.remote.IHelloRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restful接口的第二种写法,在使用Eureka时候推荐，因为这样可以将服务提供方(IHelloRemote)单独抽象到一个模块中,服务提供方和使用方仅需要依赖
 */
@RestController
public class HelloController implements IHelloRemote {


    public String printUserInfo(@PathVariable("name") String name, @PathVariable("age") int age) {
        String message = "姓名: " + name+", 年龄:"+ age;
        System.out.println("printUserInfo : "+message);
        return message;
    }

    public String addUser(@RequestBody User user) {
        String message = "姓名: " + user.getName()+", 年龄:"+ user.getAge();
        System.out.println("addUser : "+message);
        return message;
    }

    public String info() {
        return "HelloRemote";
    }
}
