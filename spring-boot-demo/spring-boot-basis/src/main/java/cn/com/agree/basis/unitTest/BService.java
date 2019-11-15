package cn.com.agree.basis.unitTest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BService {
    public String getName(){
        return "this is service B";
    }
}
