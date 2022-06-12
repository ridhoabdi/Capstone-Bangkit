Make sure you have created a project in firebase and connect with your project in GCP
Open the project directory on the local machine
Go to the compute engine.Then create instance make sure your region is asia-southeast2 and the machine type N1.
After the VM success installed, then start the VM and click the SSH
Clone your github or upload the API to the instance . if you use Flask you need to install python and flask
After install python and python, you have to run this command "export FLASK_APP=your_directory" check it with printenv
To run to a API project, run the following command from your project directory: “fLask run --host=0.0.0.0”
