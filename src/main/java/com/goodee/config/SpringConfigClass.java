package com.goodee.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//전체 환경 설정을 해주는 엔트리 클래스
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{

	// 프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// RootConfigClasses 컴포넌트로 선언할 빈말고 임시적으로 쓸 빈들이 생길수 있는데 그런 빈들을 설정해주기 위한 클래스의 위치를 여기에서 지정
		//<?> 와일드카드 어떤 클래스든 다 입력받아 들어갈수 있다
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}

	//Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// MVC 프로젝트를 구성하는데 필요한 여러 구성정보를 담은 클래스를 지정할때 쓰는 메서드,
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}

	// DispatcherServlet에 매핑할 요청 주소를 세팅한다
	@Override
	protected String[] getServletMappings() {
		// 사용자가 어떤 주소로 접근했을때 지금있는 설정을 적용할 것인가 /정보를 기준으로 들어가야 정상 거의 고정이라고 보면 됨 
		// localhost:8080은 디폴트라고 보면됨
		return new String[] {"/"};
	}
	
	//파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		// mvc패턴에서 글자가 깨지지 않게 하기위해 리퀘스트 utf-8을 셋캐릭터인코딩을 전역으로 설정해주는 파일 이것도 고정이라고 보면됨
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}
