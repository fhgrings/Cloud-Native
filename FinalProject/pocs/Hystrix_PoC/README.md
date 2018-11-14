# Basic Hystrix implementation

The Hystrix framework library helps to control the interaction between services by providing fault tolerance and latency tolerance. It improves overall resilience of the system by isolating the failing services and stopping the cascading effect of failures.

# Gradle
Add in build.gradle as dependencies compile

     'com.netflix.hystrix:hystrix-core:1.5.4'

And dependencies implementation

      'org.springframework.boot:spring-boot-starter-web'
      

## HystrixCommand

The way Hystrix provides fault and latency tolerance is to isolate and wrap calls to remote services.In this simple example we wrap a call in the run() method of the HystrixCommand:

Hystrix needs to extands HystrixCommand class and implements his methods run();

      public class CommandHelloWorld extends HystrixCommand<String> {
      private RestTemplate restTemplate = new RestTemplate();

        private String gitHubUser;

        

        @Override
        protected String run() {
            String url = "http://172.18.0.25:8080/repos?user=" + gitHubUser;
            return restTemplate.getForObject(url, String.class);

       }


Hystrix needs a GroupKey in constructor that we will use;

      public CommandHelloWorld(Setter config, String gitHubUser) {
                  super(config);
                  this.gitHubUser = gitHubUser;
              }
              
To configure fallback Hystrix method is very simple, we need just to Overrite the method FallBack() and return as we want

      @Override
          protected String getFallback() {
              return "Hello Failure !";
          }
          
## Configure Client use

To Configure hystrix GroupKey we will use a base sample;

      HystrixCommand.Setter config = HystrixCommand
                      .Setter
                      .withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloGitHubSample"));
                      
                      
To execute our sample we gonna use .execute() that is a super method contained in HystrixCommand, and it will return success or our fallback() configuration

      System.out.println(new CommandHelloWorld(config,"GitHub_Acount").execute());
      

## TimeOut Hytrix Configuration

To configure hystrix timeout we are going to use;

      HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
      commandProperties.withExecutionTimeoutInMilliseconds(1_000);
      config.andCommandPropertiesDefaults(commandProperties);

That <commandProperties.withExecutionTimeoutInMilliseconds(1_000);> represents the time to get the response until break in miliseconds



## Complete Code

     public class CommandHelloGitHub extends HystrixCommand<String> {
         private RestTemplate restTemplate = new RestTemplate();

         private String gitHubUser;

         public CommandHelloWorld(Setter config, String gitHubUser) {
             super(config);
             this.gitHubUser = gitHubUser;
         }

         @Override
         protected String run() {
             String url = "http://172.18.0.25:8080/repos?user=" + gitHubUser;
             return restTemplate.getForObject(url, String.class);
         }

         @Override
         protected String getFallback() {
             return "Hello Failure !";
         }
     }
     
     
     public class HelloGitHub {

          public static void main(String[] args) {

             HystrixCommand.Setter config = HystrixCommand
                     .Setter
                     .withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloGitHubdSample"));


             HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
             commandProperties.withExecutionTimeoutInMilliseconds(1_000);
             config.andCommandPropertiesDefaults(commandProperties);

             System.out.println(new CommandHelloWorld( config,"GitHub_Acount").execute());
         }
    }



  

  
  
  
  
  
