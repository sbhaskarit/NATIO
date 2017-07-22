# NATS IO
NATS IO (High Performance Cloud Native Messaging)

Overview
------------------------------------------
NATS IO is an open source messaging system
NATS IO server is written in Go programming language
Apcera develops and provide support for NATS (Developed by Derek Collision in Ruby earlier)
The core design principle of NATS are Performance, Scalability and Easy of Use
Security - Pluggable Integration with External Authorisation

Activities
------------------------------------------
NATS Streaming Server setup
Java Program - Publisher & Subscriber
Integration With Spring Boot
Testing with JMeter by Pushing millions of messages
Scalability

NATS Streaming Server setup
-------------------------------------

1) Download the NATS Streaming server from https://nats.io/download/nats-io/nats-streaming-server/ (nats-streaming-server-v0.4.0-linux-386)

2) Unzip the file in your own directory

3) Open Terminal (Linux) and follow the path to get nats-streaming-server-v0.4.0.sh

4) Run nats-streaming-server-v0.4.0.sh 


Java Program - Publisher & Subscriber
-------------------------------------------------

1) Write a Publisher class (Publisher.java)
2) Export the Runnable jar file [Publisher.jar]
3) Run the Jar [ java -jar Publisher.jar --server "Hello Shailesh Bhaskar..!"]
4) Write a Subscriber class (Subscriber.java)
5) Export the Runnable jar file(Subscriber.jar)
6) Run the Jar [ java -jar Subscriber.jar --server]

Note: Start the NATS server and Run the Subscriber first and then Publisher. You are done..
