package com.zee.ebs.failureanalyzer;


import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Sep, 2026
 */

public class ExternalComponentAccessibilityFailureAnalyzer extends AbstractFailureAnalyzer<ExternalComponentException> {

    @Override
    protected @Nullable FailureAnalysis analyze(@NotNull Throwable rootFailure, @NotNull ExternalComponentException cause) {
        return new FailureAnalysis("Unable to access the external component " +  cause.getUrl(),
                "Check if the url is accessible", cause);
    }
}
