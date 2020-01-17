package chengf.falcon.appstore.kubernetes;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class KubernetesClientCache {

    private final  Log log = LogFactory.getLog(KubernetesClientCache.class);

    @Autowired
    KubernetesConfig kubernetesConfig;


    private KubernetesClient kubernetesClient;

    @PostConstruct
    public void init() throws IOException {
        ConfigBuilder builder = new ConfigBuilder();

        builder.withMasterUrl(StringUtils.isEmpty(kubernetesConfig.getMasterUrl()) ? "https://192.168.0.107:6443/" : kubernetesConfig.getMasterUrl());

        if (!StringUtils.isEmpty(kubernetesConfig.getNamespace())) {
            builder.withNamespace(kubernetesConfig.getNamespace());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getCaCertData())) {
            log.info("authentication by CaCertData" + kubernetesConfig.getCaCertData());
            builder.withCaCertData(kubernetesConfig.getCaCertData());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getClientCertData())) {
            log.info("authentication by ClientCertData" + kubernetesConfig.getClientCertData());
            builder.withClientCertData(kubernetesConfig.getClientCertData());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getClientKeyData())) {
            log.info("authentication by ClientKeyData" + kubernetesConfig.getClientKeyData());
            builder.withClientKeyData(kubernetesConfig.getClientKeyData());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getCaCertFile())) {
            log.info("authentication by CaCertFile" + kubernetesConfig.getCaCertFile());
            builder.withCaCertFile(kubernetesConfig.getCaCertFile());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getClientCertFile())) {
            log.info("authentication by ClientCertFile" + kubernetesConfig.getClientCertFile());
            builder.withClientCertFile(kubernetesConfig.getClientCertFile());
        }
        if (!StringUtils.isEmpty(kubernetesConfig.getClientKeyFile())) {
            log.info("authentication by ClientKeyFile" + kubernetesConfig.getClientKeyFile());
            builder.withClientKeyFile(kubernetesConfig.getClientKeyFile());
        }
        if(!StringUtils.isEmpty(kubernetesConfig.getOauthTokenData())) {
            log.info("authentication by OauthTokenData" + kubernetesConfig.getOauthTokenData());
            builder.withOauthToken(kubernetesConfig.getOauthTokenData());
        } else if(!StringUtils.isEmpty(kubernetesConfig.getOauthTokenFile())) {

            String token = getAccountToken(kubernetesConfig.getOauthTokenFile());
            log.info("authentication by OauthTokenFile" + token);
            builder.withOauthToken(token);
        }
        Config config = builder.build();
        this.kubernetesClient = new DefaultKubernetesClient(config);
    }

    private String getAccountToken(String oauthTokenFile) {
        String token = null;
        File file = new File(oauthTokenFile);
        try {
            FileInputStream in=new FileInputStream(file);
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            token=new String(buffer);
        } catch (IOException e) {

            return null;

        }
        return token;
    }

    public KubernetesClient getKubernetesClient() {
        return kubernetesClient;
    }

}
