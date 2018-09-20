package com.lh.diveinspringboot.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThymeleafTemplateEngineBootstrap {

    public static void main(String[] args) throws IOException {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        Context context = new Context();
        context.setVariable("message", "Hello,World");

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();

        FileInputStream inputStream = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();

        String content = outputStream.toString("UTF-8");
        String result = templateEngine.process(content, context);
        System.out.println(result);
    }

}
