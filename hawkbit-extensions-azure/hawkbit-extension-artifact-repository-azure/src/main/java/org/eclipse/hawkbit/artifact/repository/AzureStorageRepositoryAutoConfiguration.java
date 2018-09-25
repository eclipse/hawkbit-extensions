/**
 * Copyright (c) 2018 Microsoft and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.artifact.repository;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.azure.storage.CloudStorageAccount;

/**
 * The Spring auto-configuration to register the necessary beans for the Azure
 * Storage artifact repository implementation.
 */
@Configuration
@EnableConfigurationProperties(AzureStorageRepositoryProperties.class)
public class AzureStorageRepositoryAutoConfiguration {

    /**
     * @return Azure storage repository based {@link ArtifactRepository}
     *         implementation.
     */
    @Bean
    public ArtifactRepository artifactRepository(final CloudStorageAccount storageAccount,
            final AzureStorageRepositoryProperties properties) {
        return new AzureStorageRepository(storageAccount, properties);
    }
}
