package com.demo.api.base;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by darjandjamtovski on 12/9/17.
 */
public class SchemaReader {

    public SchemaReader(){

    }

    public String readJsonSchema(String schemaName){

        ClassLoader classLoader = getClass().getClassLoader();
        String schemaPath = String.format("schemas%s%s.json", File.separator, schemaName);
        File schemaFile = new File(classLoader.getResource(schemaPath).getFile());

        String schemaString;
        try{
            schemaString = FileUtils.readFileToString(schemaFile, "UTF-8");
            return schemaString;
        }catch (IOException e){
            return null;
        }
    }
}
