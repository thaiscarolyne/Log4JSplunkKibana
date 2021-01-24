# Log4JSplunkKibana
This project implements a log using Log4J as framework and sends them to Splunk and Kibana to facilitate their visualization

## Steps to test Splunk:

#### log4j -> splunk (Using Socket Appender, which writes data over TCP or UDP, accepts any format)

* Run Git Bash in the root folder and execute this command to bring up the splunk container: docker-compose up splunk -d

* Access the container by the web using this URL: http://localhost:8000/

* User: admin Password: senha123

* Access: Settings > Data Inputs > Add a new TCP data input

* Select Source: Port: 15000 (It's configured in log4j2.xml file inside main > kotlin > resources)

* Input Settings: Source Type: Application > Log4J

* Review > Submit

* Click on Start Searching

* Now just execute the application to send a log


## Steps to test Kibana:

#### In order to view logs on Kibana, you need to also bring up the elastic search container, since the logs need to be sent to elastic search and then consumed by kibana

#### log4j -> elastic search <- kibana 
#### Elastic Search = Search and distributed analysis mecanism based on JSON
#### Kibana = Shapes the data and presents to user
#### (log4j send logs using HTTP appender, where we need to inform the type of data beeing transmited, in this case in JSON, and Kibana automatically search for logs in elastic search because it's set in the enviroment variables of kibana container (ELASTICSEARCH_URL and ELASTICSEARCH_HOSTS))
#### Using this approach we send data directly to a node on elastic search cluster, you can use filebeat to write the logs between all the node on the cluster, it is more fault tolerant, because if one node goes down, the logs don't stop being writen (See mostafa site in references)

* Run Git Bash in the root folder and execute this command to bring up the elastic search container: docker-compose up es01 -d

    Obs.: If the es01 container doesn't bring up because of vm memory, you can run um cmd:

    * wsl -d docker-desktop
    * sysctl -w vm.max_map_count=262144

* Run Git Bash in the root folder and execute this command to bring up the kibana container: docker-compose up kibana -d

* Access the jibana container by the web using this URL: http://localhost:5601/

* In the right menu choose Kibana > Discover

* Now just execute the application to send a log


### References:

#### Splunk:

* https://dev.splunk.com/enterprise/docs/devtools/java/logging-java/
* https://dev.splunk.com/enterprise/docs/devtools/java/logging-java/howtouseloggingjava/enablelogtcpjava

#### Kibana:

* https://www.elastic.co/pt/elastic-stack
* https://www.elastic.co/guide/en/kibana/current/docker.html
* https://www.elastic.co/guide/en/elastic-stack-get-started/current/get-started-docker.html
* https://mostafa-asg.github.io/post/ship-app-logs-to-elasticsearch-elk-filebeat/
* https://www.baeldung.com/java-application-logs-to-elastic-stack
