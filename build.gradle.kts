plugins {
	java
}

group = "io.bucher.bddsample"
version = "1.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(platform(libs.junit.bom))
	testImplementation(platform(libs.cucumber.bom))

	testImplementation(libs.truth)
	testImplementation(libs.cucumber.java)
	testImplementation(libs.cucumber.junit.platform.engine)
	testImplementation(libs.junit.jupiter)
	testImplementation(libs.junit.platform.suite)
}

tasks.test {
	useJUnitPlatform()
	// Work around. Gradle does not include enough information to disambiguate
	// between different examples and scenarios.
	systemProperty("cucumber.junit-platform.naming-strategy", "long")
}
