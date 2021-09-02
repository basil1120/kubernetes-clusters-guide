# kubernetes-clusters-guide

#  what is a kubernetes cluster
- Kubenetese cluster is Setup of multiple NODE machines to run containerized apps.
- This nodes are normally :- MASTER-NODE & WORKER-NODE(s)
- The master-node is the control plane node while the rest (worker-nodes) are joined to the cluster to easen load.

# Docker & Docker Images
- Kubernetes Run on top of DOCKER.
-

# A Kubernetes cluster contains six main components:

1. API server: Exposes a REST interface to all Kubernetes resources. Serves as the front end of the Kubernetes control plane.
2. Scheduler: Places containers according to resource requirements and metrics. Makes note of Pods with no assigned node, and selects nodes for them to run on.
3. Controller manager: Runs controller processes and reconciles the cluster’s actual state with its desired specifications. Manages controllers such as node controllers, endpoints controllers and replication controllers.
4. Kubelet: Ensures that containers are running in a Pod by interacting with the Docker engine , the default program for creating and managing containers. Takes a set of provided PodSpecs and ensures that their corresponding containers are fully operational.
5. Kube-proxy: Manages network connectivity and maintains network rules across nodes. Implements the Kubernetes Service concept across every node in a given         cluster.
5. Etcd: Stores all cluster data. Consistent and highly available Kubernetes backing store. 
