# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is the databerries bidder ###

The databerries bidder allows us to bet on advertising auction.

[BidSwitch](http://www.iponweb.com/bidswitch/what-is-it/) sends us a request by auction and we choose to bet on it or not.

To choose if we want to bet on this auction, the [request](http://www.iponweb.com/bidswitch_assets/api_spec/BidSwitch_specs_4.0.pdf) contains informations about the device that will receive the advertising, especially the idfa that identify the device in our databases. 

So if the idfa matches one we have stored on our server and the [Avocado server](https://bitbucket.org/databerries/avocado) allows us to buy it, we will buy it.

The bidder refresh its list of idfa from our dataStore every night at midnight

To bet on an auction, we must answer BidSwitch with a response in less than 40ms, to do so we use the [Vert.x](http://vertx.io/docs/) to handle requests library, and [Redis](http://redis.io/) to handle our data base.

### How to import thr project ###

To import the bidder project you can follow this few steps :

1.  #### Clone the project

	![](https://bitbucket.org/databerries/bidder/raw/master/images/clone.png "Click on Clone")

    - - -

2.  #### Copy the link


    ![](https://bitbucket.org/databerries/bidder/raw/master/images/link.png "Copy the link")

    You have to go to you workspace in the terminal and paste the link.

    - - -

3.  #### Install IntelliJ

    All th esteps are explain in [IntelliJ](https://www.jetbrains.com/idea/download/) web site.

    - - -

4.  #### Open the project

    ![](https://bitbucket.org/databerries/bidder/raw/master/images/open.png "Click on Open")

    - - -

5.  #### Configure the project

    ![](https://bitbucket.org/databerries/bidder/raw/master/images/config.png "Your config have to be like this")

    - - -

6.  #### Open gradle

	To open the gradle tools : 
		-Help
		-Find Action
		-Write "gradle"
		-press enter

    - - -

7.   #### Synchronise Gradle

     ![](https://bitbucket.org/databerries/bidder/raw/master/images/runGradle.png "Click on the refresh buton")

    - - -

8.   #### Work

     ![](https://bitbucket.org/databerries/bidder/raw/master/images/Work.png "You can work")


    - - -

- - -
### How do I get set up? ###

On Mac OS X
- install Redis via Brew:
$ brew install redis
- to start Redis:
$ redis-server /usr/local/etc/redis.conf