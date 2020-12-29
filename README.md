# Fuel_Cost_Calulator_Mercedes_Assignment
A fuel cost calculator is an api. In which in between two activity there is one message broker through which accept data from producer and pass to consumer in every 2 min . Whenever consumer try to consume data from queue it will print price of petrol for 4L in any city from Karnataka state using 3rd party api.

#Software you need to install
1. Any IDE (I am using vs code here).
2. Erlang
3. RabbitMQ Msg broker
4. Java jdk required.

#Step-1 (Download and configure rabbitMQ broker )
-> Download rabbitMQ and unzip it.
-> Download Erlang then unzip it and install it.
-> Now setup the path variable : 
                                -> Create new path variable name it as a ERLANG_HOME and provide the path value and include it in path.
 
-> Now we need to enable plugin to start our rabbitMQ server 
      -> open rabbitMQ folder -> sbin folder
      -> Now right click and open cli. or else you could open cmd and navigate till bin folder
      -> Now run "rabbitmq enable rabbitmq-plugins.bat enable rabbitmq_management" command.
      -> Plugins enabled this msg will appear.
      
-> Now run rabbitmq-server bat file.
-> hit https://localhost:15672 url:
      ->Enter guest as a username
      ->Enter guest as a password
-> Now server is up.

#step-2 (Folder setup)
-> Clone this repo.
-> And Open it in your IDE.

#step-3 (Execution)
-> Run FuelCostCalculatorApplication.java file
-> you will 1st output after that
-> in every 2 min you will get output as a fuel price.

#Thank_You


