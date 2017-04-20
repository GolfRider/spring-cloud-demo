## Spring Cloud Demo
  Illustrates usage of Spring Cloud for building resilient and scalable distributed systems using 
  Spring Boot, Spring Cloud & Netflix OSS components: 
  
| Components    | Description           
| ------------- |--------------------------------| 
| Zuul          | Gateway/Edge Server            | 
| Eureka        | Discovery Server               |  
| Ribbon        | Client based loadbalancing     |  
| Turbine       | Hystrix Metrics Aggregator     |  
| Hystrix       | Circuit Breakers, Bulkheading  |   
| Hystrix Dashboard | Metrics Dashboard          |  
| Spring Boot   | Microservices                  |     
| Spring Cloud  | To build cloud-native apps     |     


Note: Ports are randomly assigned to each microservice. So you can spawn multiple instances 
      of the same service even on localhost.
To run the project:
  1. Import the project
  2. Run Discovery Server (EurekaDiscoveryServer.java)
  3. Run Core Microservice 1 (AccountServer.java)
  4. Run Core Microservice 2 (UserServer.java)
  5. Run Composite Microservice 3 (DummyServer.java)
  6. Run Composite Microservice 4 (DashboardServer.java)
  7. Run Gateway Server (ZuulGatewayServer.java)
  8. Run HystrixDashboard/Turbine Server (HystrixDashboardAndTurbineServer.java)
  9. Note: To see the metrics , it is important to make some requests on the microservices, otherwise 
     you don't see any metrics on the dashboard

####  1. Eureka Screenshot 
<img src="https://github.com/GolfRider/spring-cloud-demo/blob/master/eureka-discovery.png" width="700" height="225" />


#### 2. Hystrix Screenshot
A brief note on Hystrix:
- Hysterix belongs to client side(ie, Client-API side)
- Provides fault tolerant communications between microservices with consistent latency levels
- Provides breathing space for the downstream services to recover
- Provides bounded resource utilization for each downstream/external services
- Provides time-out/fallback mechanisms

##### To see graphs in Hystrix Dashboard, for example: 
-------------------------------------------------------
 - Go to your hystrix dashboard page: http://hystrix-dashboard-url/hystrix.stream  (Replace with your Hystrix Dashboard Url)
 - Enter target service url in the text-box, say (http://localhost:53415/hystrix.stream)  of (or your web service url)
   - Note: Invoke the target service (Dashboard Service) few times to see the graph plot
           - Hit this url for this test case: http://dashboard-service-url/details/1 
 
<img src="https://github.com/GolfRider/spring-cloud-demo/blob/master/hystrix-dashboard.png" width="700" height="300" />
