package com.fastcampuspay.money.common.mapper;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumMapperFactory {

    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public EnumMapperFactory() {}

    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, toEnumValues(e));
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(EnumMapperValue::new)
                .collect(Collectors.toList());
    }

    public List<EnumMapperValue> get(String key){
        return factory.get(key);
    }

    public Map<String, List<EnumMapperValue>> get(List<String> keys) {
        if(keys == null || keys.size() == 0){
            return new LinkedHashMap<>();
        }

        return keys.stream()
                .collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }

    public Map<String, List<EnumMapperValue>> getAll() {
        return factory;
    }

}