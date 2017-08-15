/**
 * Copyright 2016 Hortonworks.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.hortonworks.registries.schemaregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Preconditions;

import java.io.Serializable;

/**
 * This class represents versioned instance of schema with respective information like schemaMetadataId/version,
 * schemaVersionId.
 *
 * It is not necessary that all fields are always available but the minimum information to find schema version is available.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SchemaIdVersion implements Serializable {
    private static final long serialVersionUID = 6081264497288914406L;

    private Long schemaMetadataId;
    private Integer version;
    private Long schemaVersionId;

    /** Private constructor for Jackson JSON mapping */
    @SuppressWarnings("unused")
    private SchemaIdVersion() { }

    /**
     * @param schemaMetadataId unique id of schema metadata
     * @param version version of the schema
     */
    public SchemaIdVersion(Long schemaMetadataId, Integer version) {
        Preconditions.checkNotNull(schemaMetadataId, "schemaMetadataId can not be null");
        Preconditions.checkNotNull(version, "version can not be null");
        this.schemaMetadataId = schemaMetadataId;
        this.version = version;
    }

    public SchemaIdVersion(Long schemaVersionId) {
        Preconditions.checkNotNull(schemaVersionId, "schemaMetadataId can not be null");
        this.schemaVersionId = schemaVersionId;
    }

    public SchemaIdVersion(Long schemaMetadataId, Integer version, Long schemaVersionId) {
        Preconditions.checkNotNull(schemaMetadataId, "schemaMetadataId can not be null");
        Preconditions.checkNotNull(version, "version can not be null");
        Preconditions.checkNotNull(schemaVersionId, "schemaMetadataId can not be null");
        this.schemaMetadataId = schemaMetadataId;
        this.version = version;
        this.schemaVersionId = schemaVersionId;
    }

    /**
     * @return version of the schema
     */
    public Integer getVersion() { return version; }

    /**
     * @return unique id of the schema metadata.
     */
    public Long getSchemaMetadataId() {
        return schemaMetadataId;
    }

    /**
     * @return id to represent versioned instance of the schema.
     */
    public Long getSchemaVersionId() {
        return schemaVersionId;
    }

    @Override
    public String toString() {
        return "SchemaIdVersion{" +
                "schemaMetadataId=" + schemaMetadataId +
                ", version=" + version +
                ", schemaVersionId=" + schemaVersionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchemaIdVersion that = (SchemaIdVersion) o;

        if (schemaMetadataId != null ? !schemaMetadataId.equals(that.schemaMetadataId) : that.schemaMetadataId != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        return schemaVersionId != null ? schemaVersionId.equals(that.schemaVersionId) : that.schemaVersionId == null;
    }

    @Override
    public int hashCode() {
        int result = schemaMetadataId != null ? schemaMetadataId.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (schemaVersionId != null ? schemaVersionId.hashCode() : 0);
        return result;
    }
}
