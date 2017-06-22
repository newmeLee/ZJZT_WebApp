package com.zjzt.webService;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;



/**
 * WebService≤‚ ‘¿‡
 * @author Administrator
 * mysql -uroot -p12345678
 */
public class TestMain {
	public static void main(String[] args) {
		HealthInfoService healthService=new HealthInfoServiceImpl();
		JaxWsServerFactoryBean bean=new JaxWsServerFactoryBean();
		bean.setAddress("http://localhost:8088/ws/HealthService");
		bean.setServiceClass(HealthInfoService.class);
		bean.setServiceBean(healthService);
		bean.create();
	}
}
