# How to use
* Add repository in the repositories section.
* Add dependency in dependencies section.
## Add the repository
```xml
<repositories>
    ...
    <repository>
            <id>easy-spring</id>
            <name>Easy Spring</name>
            <releases>
                    <enabled>true</enabled>
            </releases>
            <snapshots>
                    <enabled>false</enabled>
            </snapshots>
            <url>https://raw.github.com/agthumoe/easy-spring.git/releases</url>
    </repository>
    ...
</repositories>
```
## Add depencency
```xml
<depencencies>
    <dependency>
        <groupId>com.achromex</groupId>
        <artifactId>easy-spring</artifactId>
        <version>1.9.0</version>
    </dependency>
</depencencies>
```
## How to deploy
```bash
mvn clean package
mvn clean deploy
```
