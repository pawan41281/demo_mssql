Spring Security Integration

1. Login Functionality
2. User Registration Functionality

**Execute the following queries once before the user registration API call**

INSERT INTO ROLES(1,'ROLE_ADMIN');

INSERT INTO ROLES(2,'ROLE_USER');


**docker network create employee-network
**
**docker run --rm --name elasticsearch-container -p 9200:9200 -p 9300:9300 --network employee-network -e "discovery.type=single-node" -e "xpack.security.enabled=false" -v d:/data/mysql:/var/lib/mysql elasticsearch:8.18.0
**
**mvn clean install -Dmaven.test.skip=true**

**docker build -t pawan41281/employeeapi:latest .**

**docker run --rm -p 8080:8080 --network employee-network pawan41281/employeeapi:latest**
