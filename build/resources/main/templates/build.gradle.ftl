plugins {
    id 'java'
}

group '${projectName}'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    <#list dependencies as dependency>
     Item: ${dependency}
    </#list>
}