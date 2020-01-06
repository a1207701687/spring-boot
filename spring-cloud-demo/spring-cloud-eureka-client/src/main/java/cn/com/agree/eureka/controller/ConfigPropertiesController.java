package cn.com.agree.eureka.controller;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigPropertiesController {

    private DynamicStringProperty propertyFirstDynamic = DynamicPropertyFactory.getInstance().
            getStringProperty("springcloud.archaius.properties.first", "not found");

    private DynamicStringProperty propertySecondDynamic = DynamicPropertyFactory.getInstance()
            .getStringProperty("springcloud.archaius.properties.second", "not found");

//    private DynamicStringProperty propertyThirdDynamic = DynamicPropertyFactory.getInstance()
//            .getStringProperty("springcloud.archaius.properties.third", "not found");

    private DynamicStringProperty propertyForthDynamic = DynamicPropertyFactory.getInstance()
            .getStringProperty("springcloud.archaius.properties.forth", "not found");

    @RequestMapping(value = "/configuration")
    public Map<String, String> configuration() {
        Map<String, String> configMap = new HashMap<>();
        DynamicStringProperty propertyThirdDynamic = DynamicPropertyFactory.getInstance()
                .getStringProperty("springcloud.archaius.properties.third", "not found");
        configMap.put(propertyFirstDynamic.getName(), propertyFirstDynamic.get());
        configMap.put(propertySecondDynamic.getName(), propertySecondDynamic.get());
        configMap.put(propertyThirdDynamic.getName(), propertyThirdDynamic.get());
        configMap.put(propertyForthDynamic.getName(), propertyForthDynamic.get());
        return configMap;
    }
}
