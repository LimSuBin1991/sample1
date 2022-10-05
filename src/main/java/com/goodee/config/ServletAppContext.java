package com.goodee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
//Controller 어노테이션이 세팅되어 있는 클래스를 등록하는 어노테이션
@EnableWebMvc
//컨트롤러라는 @가 담긴 클래스를 읽을때 그에대한 구성정보를 자동으로 설정해주기위해 사용
//request response를 더 이상 설정해줄 필요가 없음 얘가 다 알아서 구성해주기 때문에
//스캔할 패키지 지정
//@ComponentScan과 반드시 같이 움직여야함
@ComponentScan("com.goodee.controller")
//@Component라는 어노테이션을 스캔할때 쓰는거
public class ServletAppContext implements WebMvcConfigurer{
	
	//controller의 매서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙여주도록 설정한다
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// configureViewResolvers의 역활은 리턴한 스트링 데이터의 앞과 뒤의 문장을 합쳐 우리가 불러온 view의 경로를 알아서 설정해줌
		//abc라고 경로를 설정하면 registry.jsp("/WEB-INF/views/", ".jsp")를 합쳐서 리턴해줌
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	//정적 파일의 경로 세팅
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceHandlers view가 리턴되면 그 안에 있는 내용들을 접근 하고자하는 경로를 설정할떄
		//우리가 앱에서 쓰고자 하는 자원들을 어떤 경로를 타고 가도록 설정하는지
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/resourse/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///D:/sample/");
		//외부 파일 경로 참조하는법
		//업로드라는 경로로 시작하면 참조할 경로를 외부의 file:///D:/sample/
		//resourse라는 경로로 시작하면 /resources/를 참조 
		
		// /** 전체경로 아래 어떤 경로든간에 호출하면 모든 경로를 태운다
		//내가 실제로 view쪽에서 이런식으로 호출하면 /resources/를 찾아보겠다
		
		//이 모든 기능은 WebMvcConfigurer을 상속받아서 이루어지는데 spring코어에서 있는 설정이 아닌 스프링 mvc에 있는 설정이 담긴 클래스를 선언하고자 할때 사용
	}
	
	// 파일 업로드 세팅
		private final int MAX_SIZE = 10 * 1024 * 1024;
		
		@Bean
		public MultipartResolver multipartResolver() {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
			
			// 디폴트 인코딩 타입 설정
			multipartResolver.setDefaultEncoding("UTF-8");
			// 전체 올릴 수 있는 파일들의 총 용량 최대치
			multipartResolver.setMaxUploadSize(MAX_SIZE*10);
			// 파일 한개 당 올릴 수 있는 용량 최대치
			multipartResolver.setMaxUploadSizePerFile(MAX_SIZE);
			
			return multipartResolver;
		}
	
	
	
	
	
	
	
	
}












