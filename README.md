This is app SpringBoot on OpenShift

I have taken springboot rest app and deployed it on openshift.


how to build:

* rhc app create tom tomcat-7
* git remote add upstream -m master  https://github.com/majecek/openshift-springboot.git
* git pull -s recursive -X theirs upstream master
* git push


how to run (on openshift):

* last git command (above - git push) sends new code to openshift and restart application


how to run (locally):

* mvn clean package -P openshift
* mvn clean spring-boot:run




sample rest app - http://spring.io/guides/gs/rest-service/

to test:

* localhost: http://localhost:8080/greeting

* remote: http://openshift_url/greeting
