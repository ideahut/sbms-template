package com.ideahut.sbms.sample.api.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.ideahut.sbms.sample.api.service.PhpTestService;

@Configuration
public class PhpHessianProxy {
	
	private final String BASE_URL = "http://localhost:58080/hessian";
	
	private HessianProxyFactoryBean setup(Class<?> serviceInterface, String serviceUrl) {
		HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
		proxy.setServiceInterface(serviceInterface);
		proxy.setServiceUrl(serviceUrl);
		proxy.setHessian2(true);
		proxy.setHessian2Request(true);
		proxy.setConnectTimeout(5000);
		proxy.setReadTimeout(30000);
		//proxy.setUsername(username);
		//proxy.setPassword(password);
		return proxy;
	}
		
	@Bean
	public HessianProxyFactoryBean TestServiceProxy() {
		return setup(PhpTestService.class, BASE_URL + "/test");
	}

}
