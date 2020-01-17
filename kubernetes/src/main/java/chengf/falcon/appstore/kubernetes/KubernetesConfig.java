package chengf.falcon.appstore.kubernetes;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("chengf.kubernetes.config")
public class KubernetesConfig {

    private String masterUrl;
    private String caCertData;
    private String clientCertData;
    private String clientKeyData;

    private String caCertFile;
    private String clientCertFile;
    private String clientKeyFile;

    private String oauthTokenData;

    private String oauthTokenFile;

    private String namespace;

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getCaCertData() {
        return caCertData;
    }

    public void setCaCertData(String caCertData) {
        this.caCertData = caCertData;
    }

    public String getClientCertData() {
        return clientCertData;
    }

    public void setClientCertData(String clientCertData) {
        this.clientCertData = clientCertData;
    }

    public String getClientKeyData() {
        return clientKeyData;
    }

    public void setClientKeyData(String clientKeyData) {
        this.clientKeyData = clientKeyData;
    }

    public String getCaCertFile() {
        return caCertFile;
    }

    public void setCaCertFile(String caCertFile) {
        this.caCertFile = caCertFile;
    }

    public String getClientCertFile() {
        return clientCertFile;
    }

    public void setClientCertFile(String clientCertFile) {
        this.clientCertFile = clientCertFile;
    }

    public String getClientKeyFile() {
        return clientKeyFile;
    }

    public void setClientKeyFile(String clientKeyFile) {
        this.clientKeyFile = clientKeyFile;
    }

    public String getOauthTokenData() {
        return oauthTokenData;
    }

    public void setOauthTokenData(String oauthTokenData) {
        this.oauthTokenData = oauthTokenData;
    }

    public String getOauthTokenFile() {
        return oauthTokenFile;
    }

    public void setOauthTokenFile(String oauthTokenFile) {
        this.oauthTokenFile = oauthTokenFile;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
