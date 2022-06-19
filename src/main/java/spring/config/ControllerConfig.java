package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberRegisterService;
import spring.controller.HelloController;
import spring.controller.RegisterController;

@Configuration
public class ControllerConfig {

    MemberRegisterService memberRegisterService;

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegisterController registerController() {

        return new RegisterController(memberRegisterService);
    }
}
