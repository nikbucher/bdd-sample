# bdd-sample

[![build](https://github.com/nikbucher/bdd-sample/actions/workflows/build.yml/badge.svg)](https://github.com/nikbucher/bdd-sample/actions/workflows/build.yml)

A minimal behavior-driven development (BDD) sample: [Cucumber](https://cucumber.io)
scenarios running on the JUnit 5 platform, built with Gradle.

## Requirements

JDK 25 — Gradle auto-provisions the toolchain if it isn't installed locally
(any JDK is enough to *run* Gradle itself).

## Run the tests

```shell
./gradlew test
```

Scenario output goes to the console; the full report lands in
`build/reports/tests/test/index.html`.

## Examples

| Feature | Shows |
|---|---|
| [`hello/is_it_friday_yet.feature`](src/test/resources/cucumber/hello/is_it_friday_yet.feature) | plain scenarios and a `Scenario Outline` with an `Examples` table |
| [`belly/belly.feature`](src/test/resources/cucumber/belly/belly.feature) | the classic Cucumber "cukes" example |

## Layout

```
src/
├── main/java/cucumber/belly/Belly.java     # production code under test
└── test/
    ├── java/cucumber/                      # step definitions + JUnit suite runner
    └── resources/cucumber/                 # .feature files (the specifications)
```

## Adding a scenario

1. Add or edit a `.feature` file under `src/test/resources/cucumber/`
2. Run `./gradlew test` — undefined steps are printed to the console
3. Implement the missing step definitions in `src/test/java/cucumber/`

## CI & dependencies

GitHub Actions builds every push and pull request; [Dependabot](.github/dependabot.yml)
keeps dependencies current.

## License

[MIT](LICENSE)
