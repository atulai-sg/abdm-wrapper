Project title -  __ABDM   CONSENT MANAGEMENT__

note 
our project was in the initial phase 
during the C4GT 2023 
we build this module(ie coded in from scratch)
It is a __multimodular gradle application__ consisting of diff module
my work is specific about consent mgmt module \
Project Description
The consent mgmt module is specific about making calls to the 
gateway via this springboot app

the springboot app here follows a __layered architecture__
controller layer
service layer
The service layer consist of interfaces and their implementation \
which currently store the information in locallly \
you can extend this feature to store them in diff database like mongo or mysql \
 \
 \
for have a look at the repo folder
the interfaces their extends Mongorepository which helps to store them in mongodb database
repos
the module consist of diff controllers
__ConsentMgmntHiuController__ which deals with hiu api for consent managment \
__Gateway controller__ is there for dealing with the callbacks \
till now the app is running on localhost and callbacks from internet(ie remote ip of gateway) are redirected using ssh tunnels
for above such purpose __Webhook or Ngrok__ can be used

Hip controller is there to listen to Hip callbacks 
for testing we can create health artificacts using Bahmni
which can act as both HIU and HIP

Models have diff classes for diff schema of the 
diff calls request and response

in springboot we can use both gradle or Maven 
here we are specifically using gradle for managing 
all the required dependencies
future work on this can be continued using the same


we have used fasterxml.jackson libraries for serialsation and deserialiisatin stuff


the application.properties file consist server port assinged for runnning the sprinboot server
also the connection variable required to connected to local databse instance of mongodb
which has different collections for storing diff information like consent status,consent artefact whenever we get them from 
on fetch callback after the request has been assinged

the test directory has some dummy test 
this can be used for setting some assertions to test 
diff component working correctly or not
using __Mockito__




