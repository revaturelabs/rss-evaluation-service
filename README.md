# rss-evaluation-service
Revature Swag Shop Evaluation Service

# Getting started
* If you already have Docker Desktop with Kubernetes running on your machine with the nginx-ingress service skip to the setup files portion of this walkthrough
* You need to have Docker installed on your computer. Install Docker [here](https://docs.docker.com/get-docker/).
* If you are running windows Docker Desktop is your quickest option.
* Enable Kubernetes on Docker Desktop in settings.
* Install Helm on your machine if you are using Windows. This will allow for the quick installation of the nginx-ingress. [Helm](https://helm.sh/docs/intro/install/) [nginx-ingress](https://github.com/kubernetes/ingress-nginx).
* Once you have the nginx-ingress in your Kubernetes services use `kubctl apply -f rss-evaluation-setup.yaml` to deploy this service


# Viewing Changes Locally for Testing
* You must have a Dockerhub account. Use `docker build -t yourdockerhub/rss-evaluation-service .` to build the Docker image and push that image to your Dockerhub.
* Change the image target in the rss-evaluation-setup.yaml in the deployment section to use the image from your Dockerhub that you just pushed.
* Use `kubctl apply -f rss-evaluation-setup.yaml` to redeploy your new image.
