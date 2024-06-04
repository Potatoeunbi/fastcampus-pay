package common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
//@Target : 다른 어노테이션이 어디에 사용할 수 있는지를 명확히 지정하는 역할. 개발자가 어노테이션을 잘못된 곳에 사용하지 않도록 하고, 코드를 더 명확하고 오류가 적게 작성. 예를 들어, @Target(ElementType.METHOD)는 해당 어노테이션이 메서드에만 적용될 수 있도록 제한

//그냥 이름만 WebAdapter인 어노테이션이지 별 의미 없음.
public @interface WebAdapter {
}
