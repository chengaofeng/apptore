package chengf.falcon.appstore.business;

import chengf.falcon.appstore.kubernetes.services.KubernetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    KubernetesService kubernetesService;

    @RequestMapping("/createService")
    public String createService() {
        kubernetesService.deploy();
        return  "OK";
    }

    @RequestMapping("/deleteService")
    public String deleteService() {
        kubernetesService.delete();
        return  "OK";
    }

    @RequestMapping("/health")
    public String health() {
        return  "OK";
    }
}
