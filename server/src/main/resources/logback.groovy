import ch.qos.logback.classic.encoder.PatternLayoutEncoder

scan("30 seconds")

jmxConfigurator()

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = '%d{HH:mm:ss.SSS} [%-5level] %logger{15} - %msg%n%rEx'
    }
}

logger('ch.qos.logback', WARN)

root(INFO, ["STDOUT"])
