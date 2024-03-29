/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.hawkbit.artifact.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

/**
 * Auto configuration for the {@link MongoDBArtifactStore}.
 */
@Configuration
@ConditionalOnProperty(prefix = "org.eclipse.hawkbit.artifact.repository.mongo", name = "enabled", matchIfMissing = true)
@PropertySource("classpath:/hawkbit-mongodb-defaults.properties")
@EnableConfigurationProperties(MongoProperties.class)
public class MongoDBArtifactStoreAutoConfiguration {

    /**
     * @return Default {@link ArtifactRepository} implementation.
     */
    @Bean
    ArtifactRepository artifactRepository(final GridFsOperations gridFs) {
        return new MongoDBArtifactStore(gridFs);
    }
}
