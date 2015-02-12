package zhangzhi;

import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.spring.SpringSnakerEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SnakerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring/spring-x.xml");
		SpringSnakerEngine engine = (SpringSnakerEngine) ctx.getBean("engine");
		engine.process().deploy(
				StreamHelper.getStreamFromClasspath("process/fileName.snaker"));
	}
}
