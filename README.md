Google Exchange Rate Parser
===================


This repository is a small showcase app using JAVA/Spring to create a small REST API interface. It uses [Jsoup](https://github.com/jhy/jsoup) to scrape google's result page (note: This is potentially against google's terms of service)

----------


Example
-------------

Simply start the application and point your brower to http://127.0.0.1:8080/exchange?from=EUR&to=GBP
This will give you the exchange rate of the EUR/GBP pair is JSON format, as shown below:

```json
{
    "from":"EUR",
    "to":"GBP",
    "rate":0.878747103,
    "error":false,
    "errorMsg":""
}
```
