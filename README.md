# Log4JSplunkKibana
This project implements a log using Log4J as framework and sends them to Splunk and Kibana to facilitate their visualization

## Steps:

* Run Git Bash in the root folder and execute this command to lift the splunk container: docker-compose up -d

* Access the container by the web using this URL: http://localhost:8000/

* User: admin Password: senha123

* Access: Settings > Data Inputs > Add a new TCP data input

* Select Source: Port: 15000 (It's configured in log4j2.xml file inside main > kotlin > resources)

* Input Settings: Source Type: Application > Log4J

* Review > Submit

* Click on Start Searching

* Now just execute the application to send a log
