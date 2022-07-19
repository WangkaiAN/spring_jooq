import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*

plugins {
    id("org.springframework.boot") version "2.3.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
}

group = "com"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}
buildscript {
    dependencies {
        classpath("org.jooq:jooq-codegen:3.14.15")
        classpath("mysql:mysql-connector-java:8.0.27")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("mysql:mysql-connector-java:8.0.27")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.jooq:jooq:3.14.15")
    implementation("org.jooq:jooq-codegen:3.14.15")
    implementation("org.jooq:jooq-meta:3.14.15")
    implementation("com.xiaoleilu:hutool-core:3.3.2")
    implementation ("org.projectlombok:lombok:1.18.24")
// https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter
    implementation("io.springfox:springfox-boot-starter:3.0.0")
}

tasks.register("JOOQ_Code_Generate") {
    doLast {
        val config: org.jooq.meta.jaxb.Configuration = Configuration()
                .withJdbc(Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl("jdbc:mysql://192.168.10.121:3306/people?characterEncoding=utf-8&serverTimezone=Asia/Shanghai")
                        .withUsername("root")
                        .withPassword("123456"))
                .withGenerator(Generator()
                        .withGenerate(Generate()
                                .withComments(true) // 注释 √
                                .withCommentsOnCatalogs(true)
                                .withRelations(true)
                                .withImmutablePojos(false) // if true, cannot use 'into()' method
                                .withInterfaces(true)
                                .withDaos(true))
                        .withDatabase(Database()
                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withIncludes(".*")
                                .withExcludes("")
                                .withInputSchema("people")
                        )
                        .withTarget(org.jooq.meta.jaxb.Target()
                                .withPackageName("")
                                .withDirectory("src/main/java"))
                )
        GenerationTool.generate(config)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
