package com.ideahut.sbms.sample.api.exporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.ideahut.sbms.client.service.RemoteMethodService;
import com.github.ideahut.sbms.shared.remote.cutom.HttpInvokerServiceExporter;
import com.github.ideahut.sbms.shared.remote.service.ServiceExporterBase;
import com.github.ideahut.sbms.shared.remote.service.ServiceExporterInterceptor;
import com.ideahut.sbms.sample.client.service.TestService;

@Configuration
public class HttpInvokerExporter extends ServiceExporterBase {
	
	private static final String PATH = "/httpinvoker";
	
	@Autowired
	private ServiceExporterInterceptor interceptor;
	
	
	@Autowired
	private TestService testService;
	
	@Bean(name = PATH + "/TestService")
	public HttpInvokerServiceExporter TestServiceExporter() {
		return export(
			HttpInvokerServiceExporter.class, 
			TestService.class, 
			testService
		).setInterceptor(interceptor);
	}
	
	
	@Autowired
	private RemoteMethodService remoteMethodService;
	
	@Bean(name = PATH + "/RemoteMethodService")
	public HttpInvokerServiceExporter RemoteMethodServiceExporter() {
		return export(
			HttpInvokerServiceExporter.class, 
			RemoteMethodService.class, 
			remoteMethodService
		).setInterceptor(interceptor);
	}
}