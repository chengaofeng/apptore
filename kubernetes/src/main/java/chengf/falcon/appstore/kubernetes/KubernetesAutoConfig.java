package chengf.falcon.appstore.kubernetes;

import chengf.falcon.appstore.kubernetes.services.KubernetesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KubernetesAutoConfig {

    @Bean
    public KubernetesConfig kubernetesConfig() {
        return new KubernetesConfig();
    }

    @Bean
    public KubernetesClientCache kubernetesClientCache() {
        return new KubernetesClientCache();
    }

    @Bean
    public KubernetesService kubernetesService() {
        return new KubernetesService();
    }

}
