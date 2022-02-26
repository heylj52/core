package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
	
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		System.out.println("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		
		System.out.println("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		
		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);
		
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		
		ac.close(); //prototype은 종료를 하지 않는다.
		
		//종료를 해야 할 때 수동으로 직접 종료를 해줘야 한다.
		prototypeBean1.destroy();
		prototypeBean2.destroy();
	}
	
	@Scope("prototype")
	static class PrototypeBean {
		
		@PostConstruct
		public void init() {
			System.out.println("PrototypeTest.PrototypeBean.init()");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeTest.PrototypeBean.destroy()");
		}
		
	}
	
}
