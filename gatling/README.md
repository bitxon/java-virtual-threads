
```mermaid
gantt
    title mean requests/sec
    dateFormat  X
    axisFormat %s

    section Dropwizard
    Jetty Sync              : 0, 1785
    section Dropwizard
    Jetty Async             : 0, 2777
    section Dropwizard
    Jetty Virtual Threads   : 0, 8333
    section Spring
    Tomcat Sync             : 0, 1923
    section Spring
    Tomcat Async            : 0, 2857
    section Spring
    Tomcat Virtual Threads  : 0, 8333
```