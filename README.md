﻿# Architecture-microservice

First of all we made a request through postman to the api gateway that produces a message to the broker under the topic "application-process"
![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/54a15914-704d-4e09-88b3-474d9ec8a571)

The message is received by the commercial microservice and this one must treat the application of the user to attribute a score, if the client is eligible it will produce a message to the broker under the topic "risk-process"

![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/c8363b5d-e884-4d01-b971-ea88ec3bf9ec)


afterward the risk microservice who's listening to the "risk-process" topic receive that message , process the data of the client and make a call to the Central bank database to check for debt, if the user have enough money on his balance, a message will be send thourgh the "extract-job" that will be received by the Ocr microservice that will get the documents from the s3 bucket and extract data from these document in addition to checking data integrity and then it will produce the result under the "extract-result" topic 

![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/98cede3d-e29e-42aa-93e9-67e5030f112f)


these data will be received by the risk service that will, after receiving a message from the "extract-result" topic will produce a message under the topic "agreement-process" 

![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/2fd493d3-a884-428c-b181-438fe4725aa2)

the credit microservice will receive the message store document into another filesystem and generate a contract for the customer


![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/87cc7d31-0e49-4dfa-96c2-2d6ce77c4f6c)

and then it will prodce a message under "agreement-result" topic . the api gateway is listening to this topic in order to make a server sent event to the user to inform him about the status of his application 


![image](https://github.com/aymenbouhaha/Architecture-microservice/assets/92325496/9efcc2f1-e400-4d7f-bfd9-d795ff0f3435)

