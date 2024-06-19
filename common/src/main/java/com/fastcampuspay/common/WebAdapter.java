package com.fastcampuspay.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
//@Target : 다른 어노테이션이 어디에 사용할 수 있는지를 명확히 지정하는 역할. 개발자가 어노테이션을 잘못된 곳에 사용하지 않도록 하고, 코드를 더 명확하고 오류가 적게 작성. 예를 들어, @Target(ElementType.METHOD)는 해당 어노테이션이 메서드에만 적용될 수 있도록 제한
@Retention(RetentionPolicy.RUNTIME)
//@Retention : 어노테이션이 언제까지 살아 남아있을지 정하는 것
@Documented
// @Documented : 해당 어노테이션을 javadoc에 포함
@Component
// @Component :  Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있음. 빈 등록자체를 빈 클래스 자체에다가 할 수 있다는 의미
//그냥 이름만 WebAdapter인 어노테이션이지 별 의미 없음.
public @interface WebAdapter {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
