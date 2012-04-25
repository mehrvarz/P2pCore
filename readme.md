P2pCore - A portable peer-to-peer framework
===========================================

P2pCore is a portable peer-to-peer framework written in Scala. It enables end-to-end RSA-encrypted direct datagram socket communication for devices located behind (different) firewalls. "UDP hole punching" as described here http://www.brynosaurus.com/pub/net/p2pnat/ has been implemented for this purpose. One important objective was to enable remote parties to communicate with each other, without them being required to login to any service. As a result, no username, password, account, etc. is required to use this framework. P2pCore is very portable. It is our goal to use this framework in Gnome/GTK environments, as well as for Android projects, for example. Internally, P2pCore uses string messages as well as binary encoded messages on top of Protobuf.



System requirements
-------------------

To run (and build) this, the following 3rd party software packages needs to be installed: Scala 2.9.x, OpenJDK 6 and Ant.

On Ubuntu 12.04, for example, you would install:

    apt-get install scala ant


Building from source
--------------------

To build the project, run:

    ./make

The `make` script will work in three steps:

  1. compile P2pCore.java generated by the protocol buffer compiler using Ant
  2. compile all src/*.scala classes using Scalac
  3. run ./makejar script using the jar tool to create p2pCore.jar


Running the code 
----------------

A `run` script is provided to let you invoke different functionality. The `run` script uses the Scala runtime to execute the specified classes.

Two instances of the software need to run at the same time, so they can connect to each other and transfer data back and forth. Ideally, you would run the two instances on separate machines. Running both instances on the same machine is, of course, possible. But if there are no firewals to bridge, the purpose of the project would be kind of defeated. Ideally you would use separate machines in different networks and behind firewalls. (Example setup: two laptops, one connected to the internet via DSL, the other one connected to internet via 3G card or mobile phone tethering.)

Frameworks need to be embedded in applications to become 'alive'. The P2pCore framework comes with a small number of console apps as listed below. The purpose of these apps is testing and proof of concept.


### RelayBase

RelayBase will establish a communication link with another instance of RelayBase by routing all communication through a relay server. Two instances match by asking the relay server to connect them with another instance by the same advertised name 'RelayBase'. The [RelayBase](P2pCore/blob/master/src/RelayBase.scala) class implements two methods in 15 lines of code. `connectedThread()` is called when a p2p connection has been established. `receiveMsgHandler()` is called when a string message arrives from the other client. If the string message is "data", the application terminates. RelayBase can be executed without arguments:

    ./run timur.p2pCore.RelayBase
    ./run timur.p2pCore.RelayBase
  
This is what is shown in the console, when looking at one of the two instances:

    RelayBase relaySocket.getLocalPort=50582 relayServer=109.74.203.226 relayPort=18771y
    RelayBase receiveHandler send encrypted initialMsg='...'
    RelayBase connectedThread send='data'
    RelayBase connectedThread finished
    RelayBase receiveMsgHandler 'data'; setting relayQuitFlag


### RelayStress

RelayStress uses a relayed communication path, just like RelayBase. But it will send 5000 "data" strings before it sends "last" to signal the end of communication. The [RelayStress](P2pCore/blob/master/src/RelayStress.scala) class implements three methods in about 25 lines of code. Two clients match by asking the relay server to connect them with another instance of the same advertised name 'RelayStress'. RelayStress can be executed without arguments:

    ./run timur.p2pCore.RelayStress
    ./run timur.p2pCore.RelayStress

A console log showing that all 5000 data elements have been sent and another 5000 data elements from the remote client have been received:

    RelayStress relaySocket.getLocalPort=51626 relayServer=109.74.203.226 relayPort=18771
    RelayStress receiveHandler send encrypted initialMsg='...'
    RelayStress connectString finished sending; relayQuitFlag=false
    RelayStress receiveMsgHandler last; relayQuitFlag=false
    RelayStress relayExit outgoingDataCounter=5000 incomingDataCounter=5000


### P2pBase

P2pBase works like RelayBase, but it will establish a direct p2p link between two clients. The [P2pBase](P2pCore/blob/master/src/P2pBase.scala) class implements 15 methods in about 300 lines of code. P2pBase clients will ask the relay server to match them with another instance of the same name. The relay server will be used only to match clients and help them learn about their public adresses and port numbers. All other communication will take place directly between the clients. P2pBase can be executed without arguments:

    ./run timur.p2pCore.P2pBase
    ./run timur.p2pCore.P2pBase

This is what is shown in the console, when looking at one of the two instances:

    P2pBase relaySocket.getLocalPort=48564 relayServer=109.74.203.226 relayPort=18771
    P2pBase receiveHandler send encrypted initialMsg='...'
    P2pBase combinedUdpAddrString this peer udpAddress=89.201.71.60:60177|192.168.1.135:60177
    P2pBase receiveMsgHandler other peer combindedUdpAddress=89.201.71.60:51556|192.168.1.135:51556
    P2pBase datagramSendThread udpIpAddr='89.201.71.60' udpPortInt=51556 connected
    P2pBase datagramSendThread udpIpAddr='192.168.1.135' udpPortInt=51556 abort
    P2pBase p2pReceiveHandler str='hello 0'
    P2pBase p2pReceiveHandler str='hello 1'
    P2pBase p2pReceiveHandler str='hello 2'


### P2pEncrypt

P2pEncrypt works like P2pBase, except that all transfered data will be encrypted. P2pEncrypt needs to be extecuted with two or three arguments

P2pEncrypt run with two arguments: 1. the name of the folder containing the remote public keys. And 2. the name of the target key, to which a connection shall be established. If run this way, the fingerprints of the given target keys (bob and alice) are being used to match the two clients (alice is looking for bob, bob is looking for alice). 

    ./run timur.p2pCore.P2pEncrypt keysAlice bob
    ./run timur.p2pCore.P2pEncrypt keysBob alice

Here is Alice's session log:

    P2pEncrypt fullLocalKeyName=keysAlice/key.pub used for fingerprint matching
    P2pEncrypt fullRemoteKeyN.ame=keysAlice/bob.pub used for fingerprint matching
    P2pEncrypt relaySocket.getLocalPort=48878 relayServer=109.74.203.226 relayPort=18771
    P2pEncrypt receiveHandler send encrypted initialMsg='...'
    P2pEncrypt combinedUdpAddrString this peer udpAddress=89.201.71.60:34570|192.168.1.135:34570
    P2pEncrypt receiveMsgHandler other peer combindedUdpAddress='89.201.71.60:54413|192.168.1.135:54413'
    P2pEncrypt datagramSendThread udpIpAddr='192.168.1.135' udpPortInt=54413 abort
    P2pEncrypt datagramSendThread udpIpAddr='89.201.71.60' udpPortInt=54413 connected
    P2pEncrypt p2pReceiveHandler decryptString='hello 0'
    P2pEncrypt p2pReceiveHandler decryptString='hello 1'
    P2pEncrypt p2pReceiveHandler decryptString='hello 2'

P2pEncrypt run with three arguments: 1. the name of the folder containing the remote public keys. 2. a dash to indicate that no key shall be used for client matching. 3. a random string. Random string matching (here: "rendesvouz") can be used as an alternative to fingerprint matching. In order to get matched, both clients must use the exact same string. The idea behind random string matching is to hide all client specific information (such as key fingerprints) from the relay server. Key fingerprints are only exchanged between clients over the direct p2p link. Incoming fingerprints are used to load the corresponding public keys, which are used for end-to-end encryption. 

    ./run timur.p2pCore.P2pEncrypt keysAlice - rendesvouz
    ./run timur.p2pCore.P2pEncrypt keysBob - rendesvouz

Here is Bob's session log:

    P2pEncrypt fullLocalKeyName=keysBob/key.pub used for fingerprint matching
    P2pEncrypt matching clients with rendezvous string 'rendesvouz'
    P2pEncrypt relaySocket.getLocalPort=48884 relayServer=109.74.203.226 relayPort=18771
    P2pEncrypt receiveHandler send encrypted initialMsg='...'
    P2pEncrypt combinedUdpAddrString this peer udpAddress=89.201.71.60:46347|192.168.1.135:46347
    P2pEncrypt receiveMsgHandler other peer combindedUdpAddress='89.201.71.60:40939|192.168.1.135:40939'
    P2pEncrypt datagramSendThread udpIpAddr='89.201.71.60' udpPortInt=40939 connected
    P2pEncrypt datagramS endThread udpIpAddr='192.168.1.135' udpPortInt=40939 abort
    P2pEncrypt requestPubKeyFingerprint...
    P2pEncrypt sending fingerprint of our pubkey on request=5453889C95BDB4703CE7D83E6DEACA8F7E3774DB
    P2pEncrypt p2pReceiveHandler: remoteKeyFingerprint=0B40B89E4BE4F94BF2609F0EB522F693466FC14F
    P2pEncrypt found stored pubKeyRemote in file alice.pub
    P2pEncrypt p2pReceiveHandler decryptString='hello 0'
    P2pEncrypt p2pReceiveHandler decryptString='hello 1'
    P2pEncrypt p2pReceiveHandler decryptString='hello 2'


More info
---------

### Protobuf

P2pCore makes use of Google Protobuf to package peer-to-peer data. The [protobuf](P2pCore/blob/master/protobuf) folder contains file [P2pCore.proto](P2pCore/blob/master/protobuf/P2pCore.proto) describing the raw transfer format. This file is being used to generate a Java class named [P2pCore.java](P2pCore/blob/master/src/timur/P2pCore.java). This Java class is being used at runtime to encode and decode binary over-the-wire packages.

### Bouncy Castle

P2pCore makes use of Bouncy Castle to encrypt and decrypt using RSA cipher. In order for the default `bcprov-jdk15on-147.jar` library to be usable on Android OS, the default Java namespace `org.bouncycastle.*` was changed to `ext.org.bouncycastle.*` using the JarJar tool. The [bouncy-jarjar](P2pCore/blob/master/bouncy-jarjar) folder contains all info about this process.

### Apache commons-codec

The commons-codec-1.6.jar library is being used to encode and decode Base64 formated strings only.

### getjars

The [getjars](P2pCore/blob/master/getjars) script file is provided to document how the binary jar files can be fetched from their original source.

### RSA key files

Two folders `keysAlice` and `keysBob` are provided for testing purposes. Both folders contain one individual RSA key pair (`key` and `key.pub`) as well as a third file, which is the other parties public key (`keysAlice/bob.pub` and `keysBob/alice.pub`).

### relaykey.pub

A special [relaykey.pub](P2pCore/blob/master/relaykey.pub) is provided which contains the relay servers public RSA key. A P2pCore client can encrypt it's communication towards a relay server using this key. The purpose is to hide this communication (rendesvouz strings or key fingerprints) from 3rd party eyes.

### The role of the relay server

Like any peer-to-peer client solutions, P2pCore requires some amount of 3rd-party support, in order for two clients to connect to each other. The P2pCore relay server provides clients with a TCP relay service (port 18771) and a UDP echo service (port 18775). The kind of support the clients get from relay server is really the most minimal possible. Relay server does not mandate the use of user accounts or some other personal information. Relay server can be compared to a webserver, providing it's services without knowing who is using them. P2pCore clients usually disconnect from the relay server as soon as their peer-to-peer connection has been established. Clients have the option to use the relay functionality for full session communication purposes, if no direct connection can be established, due to firewall restrictions.


License
-------

Source code is licensed under the GNU General Public License, Version 3

See [LICENSE](P2pCore/blob/master/LICENSE).

Copyright (C) 2012 timur.mehrvarz@gmail.com


3rd party libraries being used:

- Bouncy Castle http://bouncycastle.org/

- Google Protobuf https://code.google.com/p/protobuf/

- Apache Commons-codec http://commons.apache.org/codec/

- jarjar tool https://code.google.com/p/jarjar/



