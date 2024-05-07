package com.example.gradle;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;

@CacheableRule
public class Slf4JSimpleRule implements ComponentMetadataRule {
    @Override
    public void execute(ComponentMetadataContext componentMetadataContext) {
        componentMetadataContext.getDetails().allVariants(variant -> variant.withDependencies(dep -> dep.removeIf(gav -> gav.getName().equals("sf4j-api"))));
    }
}
