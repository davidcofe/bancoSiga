plugins {
	kotlin("jvm") version "1.6.0" // Agrega el plugin de Kotlin si no lo has hecho
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("jacoco")
}

group = "co.edu.unisabana.siga"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("mysql:mysql-connector-java:8.0.32")
	implementation("org.jetbrains:annotations:24.0.0")
	testImplementation("com.h2database:h2:2.2.220")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<JacocoReport> {
	dependsOn(tasks.test)
	reports {
		csv.required.set(true)
	}
	classDirectories.setFrom(
			sourceSets.main.get().output.asFileTree.matching {
				exclude("**/controller/dto/**")
				exclude("**/bd/**")
			}
	)
}

jacoco {
	toolVersion = "0.8.8"
}