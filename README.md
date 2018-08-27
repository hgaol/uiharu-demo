# uiharu demo

:bulb:a simple demo demonstrate how to use uiharu framework.



## package

```shell
mvn clean package -DskipTests
```



## run

move the war file to tomcat to startup.

```shell
mv target/uiharu-demo-1.0.war <your_tomcat_webapps_dir>
# cd to tomcat dir
./bin/startup.sh
```

then go to `http://localhost:<port>/data` to see the get api.

## stop

```shell
# cd to tomcat dir
./bin/shutdown.sh
```

## demo

1. 获取view
![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557386940857-40d2aa4c-0445-43ec-93f6-161fdbaa49a9.png)

2. 获取data

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557386965514-8b907652-773b-4a5e-9e91-f9537d1f9bc7.png)

3. POST接口，解析JSON并自动注入

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557387104822-34e78e89-e4ff-4505-92b9-de5b353805f4.png)

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557387161438-5b1a1638-5d07-4a16-b76c-77acdc013819.png)

4. 数据库插入数据

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557388395399-1effa7a0-cbd4-472c-8321-cf450d532736.png)

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557388424940-790e2ad2-fa1f-444c-82ce-9a40daacd25b.png)

5. 数据库事务，失败回滚

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557388457444-c7c2f86d-bfe7-42bf-bf72-93f96f7100dc.png)

![](https://cdn.nlark.com/yuque/0/2019/png/135791/1557388471426-88eec33e-30e7-4cb5-bbd5-ad097dc592e4.png)

