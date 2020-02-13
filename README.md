## apptore
利用fabric8通过client操作kubernetes，一种通过kubernetes集群的pki，一种利用serviceaccount


### 主要思路
1. 创建spring boot工程，依赖fabric8

1. 工程启动时创建serviceaccount，通过ClusterRoleBinding绑定到cluster-admin

1. 将spring-boot打成镜像

1. 将serviceAccount赋给对应的镜像

1. 工程启动时通过serviceAccount挂载到镜像内部的/var/run/secrets/kubernetes.io/serviceaccount/ca.crt和/var/run/secrets/kubernetes.io/serviceaccount/token初始化一个DefaultKubernetesClient

1. 通过DefaultKubernetesClient和k8s集群的kube-apiserver进行交互


[使用PKI](https://github.com/chengaofeng/apptore/wiki/cafile_appstore.yml)  
[使用ServiceAccount](https://github.com/chengaofeng/apptore/wiki/serviceaccount_appstore.yml)

### 调用流程
KubernetesClientCache在启动时，根据kubernetesConfig中的配置信息初始化DefaultKubernetesClient，根据配置的参数选择认证方式，以jar包的形式提供给appstore-business工程调用  

appstore-business工程会通过maven插件spring-boot-maven-plugin打成一个可执行jar包，之后根据Dockerfile打成一个镜像，Docker file中加入了一个CUSTOM_PARAMS，可以通过外部传参数到容器内  

kubernetes的描述文件，通过CUSTOM_PARAMS传入认证文件的地址，进行认证
  

