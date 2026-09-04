package com.zee.ebs.logging;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.json.JsonWriter;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

import java.time.ZoneId;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Sep, 2026
 */

public final class ESBStructuredLoggerFormatter implements StructuredLogFormatter<ILoggingEvent> {

    private final JsonWriter<ILoggingEvent> writer = JsonWriter.<ILoggingEvent>of(members -> {
        //        members.add("time", ILoggingEvent::getInstant); //caching happens
        members.add("@timestamp", event -> event.getInstant()
                .atZone(ZoneId.systemDefault()));
        members.add("log.logger", ILoggingEvent::getLoggerName);
        members.add("level", ILoggingEvent::getLevel);
        members.add("thread", ILoggingEvent::getThreadName);
        members.add("duration_ms", event -> event.getMDCPropertyMap().get("duration_ms"))
                .whenNotNull();
        members.add("message", ILoggingEvent::getFormattedMessage);

        members.add("http").usingMembers(httpMembers -> {
            httpMembers.add("method", event -> event.getMDCPropertyMap().get("method"));
            httpMembers.add("status", event -> event.getMDCPropertyMap().get("status"));
            httpMembers.add("path", event -> event.getMDCPropertyMap().get("path"));
        });

        members.add("error.stack_trace", event -> {
            IThrowableProxy throwableProxy = event.getThrowableProxy();
            if (throwableProxy == null) return null;

            StringBuilder sb = new StringBuilder();
            sb.append(throwableProxy.getClassName()).append(": ").append(throwableProxy.getMessage()).append("\n");
            for (StackTraceElementProxy step : throwableProxy.getStackTraceElementProxyArray()) {
                sb.append("\tat ").append(step.getSTEAsString()).append("\n");
            }
            return sb.toString();
        });
        members.add("service.name", event -> event.getMDCPropertyMap().get("service.name"));
    }).withNewLineAtEnd();

    @Override
    public @NotNull String format(@NotNull ILoggingEvent event) {
        return this.writer.writeToString(event);
    }
}
