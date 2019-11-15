package cn.com.agree.basis.unitTest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AService {
    public String getAServiceName(){
        return "this is service A";
    }
}
