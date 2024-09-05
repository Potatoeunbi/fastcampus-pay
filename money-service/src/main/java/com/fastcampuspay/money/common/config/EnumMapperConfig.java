package com.fastcampuspay.money.common.config;

import com.fastcampuspay.money.common.enums.MoneyChangingStatus;
import com.fastcampuspay.money.common.mapper.EnumMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumMapperConfig {

    @Bean
    public EnumMapperFactory enumMapperFactory() {
        EnumMapperFactory enumMapperFactory = new EnumMapperFactory();
        enumMapperFactory.put("MoneyChangingStatus", MoneyChangingStatus.class); // 필요한 enum 추가
        return enumMapperFactory;
    }
}