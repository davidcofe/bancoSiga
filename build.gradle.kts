plugins {
	id("java")
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("jacoco")
	id("org.sonarqube") version "4.4.1.3373"
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
	implementation("org.springdoc:springdoc-openapi-data-rest:1.7.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.7.0")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE")
}

jacoco {
	toolVersion = "0.8.8"
}

tasks.test {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

tasks {
	jacocoTestReport {
		dependsOn(test)
		reports {
			xml.required.set(true)
		}
	}
}

tasks.withType<JacocoReport> {
	dependsOn(tasks.test)
	reports {
		csv.required.set(true) // Habilita el informe CSV de JaCoCo
	}
	val mainSourceSetOutput = sourceSets.main.get().output
	classDirectories.setFrom(
			mainSourceSetOutput.asFileTree.matching {
				exclude("**/controller/dto/**")
				exclude("**/co/edu/unisabana/siga/banco/bd/**")
			}
	)
}

sonarqube {
	properties {
		property("sonar.projectName", "sigaBanco")
	}
}


