# apptore
利用fabric8通过client操作kubernetes，一种通过kubernetes集群的pki，一种利用serviceaccount

[使用PKI](https://github.com/chengaofeng/apptore/wiki/cafile_appstore.yml)  
[使用ServiceAccount](https://github.com/chengaofeng/apptore/wiki/serviceaccount_appstore.yml)

### 调用流程
KubernetesClientCache在启动时，根据kubernetesConfig中的配置信息初始化DefaultKubernetesClient，根据配置的参数选择认证方式，以jar包的形式提供给appstore-business工程调用  

appstore-business工程会通过maven插件spring-boot-maven-plugin打成一个可执行jar包，之后根据Dockerfile打成一个镜像，Docker file中加入了一个CUSTOM_PARAMS，可以通过外部传参数到容器内  

kubernetes的描述文件，通过CUSTOM_PARAMS传入认证文件的地址，进行认证
  


