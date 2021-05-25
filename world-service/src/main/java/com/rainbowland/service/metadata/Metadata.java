package com.rainbowland.service.metadata;

import com.rainbowland.service.metadata.db2.Db2Reader;
import com.rainbowland.utils.SysProperties;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Metadata {

    private static final Metadata INSTANCE = new Metadata();

    private Path metadataFolder;

    private Metadata() {
        metadataFolder = Paths.get(SysProperties.METADATA_FOLDER);
    }

    public <T> Db2Reader createDb2Reader(String fileName, Class<T> clazz) {
        Path path = metadataFolder.resolve(SysProperties.METADATA_DB2_FOLDER).resolve(fileName);
        return new Db2Reader(path.toFile(), clazz);
    }

}
