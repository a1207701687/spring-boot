//package cn.com.agree.eureka.ribbon;
//
//import com.netflix.client.config.DefaultClientConfigImpl;
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class DefaultConfiguration {
//    @Bean
//    public IRule ribbonRule() {
////        return new AvailabilityFilteringRule();
//        return new BestAvailableRule();
//    }
//
//    @Bean
//    public ServerListSubsetFilter serverListFilter() {
//        return new ServerListSubsetFilter();
//    }
//
//    @Bean
//    public IPing ribbonPing(){
//        return new PingUrl();
//    }
//
//    @Bean
//    public IClientConfig ribbonConfig(){
//        return new DefaultClientConfigImpl();
//    }
//
//    @Bean
//    public ServerList<Server> ribbonServerList(IClientConfig config) {
//        return new RibbonClientDefaultConfigurationTestConfig.BazServerList(config);
//    }
//}
