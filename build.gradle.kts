plugins {
	java
}

group = "io.bucher.bddsample"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(platform("org.junit:junit-bom:5.11.4"))
	testImplementation(platform("io.cucumber:cucumber-bom:7.20.1"))

	testImplementation("com.google.truth:truth:1.4.4")
	testImplementation("io.cucumber:cucumber-java")
	testImplementation("io.cucumber:cucumber-junit-platform-engine")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.junit.platform:junit-platform-suite")
}

tasks.test {
	useJUnitPlatform()
	// Work around. Gradle does not include enough information to disambiguate
	// between different examples and scenarios.
	systemProperty("cucumber.junit-platform.naming-strategy", "long")
}
