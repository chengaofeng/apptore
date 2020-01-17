package chengf.falcon.appstore.kubernetes.services;

import chengf.falcon.appstore.kubernetes.KubernetesClientCache;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.beans.factory.annotation.Autowired;

public class KubernetesService {

    @Autowired
    KubernetesClientCache kubernetesClientCache;

    public void deploy() {

        ServicePort servicePort = new ServicePort();

        servicePort.setPort(8899);
        servicePort.setTargetPort(new IntOrString(8888));


        kubernetesClientCache.getKubernetesClient()
                .services()
                .inNamespace("default")
                .createNew()
                .withApiVersion("v1")
                .withNewMetadata()
                .withName("myservice")
                .addToLabels("another", "label")
                .endMetadata()
                .withNewSpec()
                .addNewPortLike(servicePort)
                .endPort()
                .addToSelector("app", "webapp")
                .endSpec()
                .done();
    }

    public void delete() {
        kubernetesClientCache.getKubernetesClient()
                .services()
                .inNamespace("default")
                .withName("myservice")
                .delete();


    }
}
