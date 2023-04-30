package org.example.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.example.entity.SubProjectDetails;


import javax.jws.Oneway;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WriteCommand implements ICommand{

    private final SubProjectDetails subProjectDetails;

    private final List<String> dependencies;

    public WriteCommand(SubProjectDetails subProjectDetails,List<String> dependencies ){
        this.dependencies = dependencies;
        this.subProjectDetails = subProjectDetails;
    }

    @Override
    public void execute() {
//        File projectDir = subProjectDetails.getSubProjectDir();
        File projectDir = new File(subProjectDetails.getProjectDetails().getProjectPath()
                , subProjectDetails.getProjectDetails().getProjectName());
        File subProjectDir = new File(projectDir, subProjectDetails.getSubProjectName());
        updateFile("build.gradle.ftl", "build.gradle", new File(subProjectDir, "app"));
//        updateFile("settings.gradle.ftl", "settings.gradle", projectDir);
    }

    private void updateFile(String ftlFileName, String fileName, File projectDir){
        Map<String, Object> data = createDataModel();
        Configuration cfg = createConfiguration();
        try {
            Template buildTemplate = cfg.getTemplate(ftlFileName);
            FileWriter fileWriter = new FileWriter(new File(projectDir, fileName));
            buildTemplate.process(data, fileWriter);
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private Map<String, Object> createDataModel(){
        Map<String, Object> data = new HashMap<>();
        data.put("projectName", subProjectDetails.getProjectDetails().getProjectName());
        data.put("dependencies", dependencies);
        return data;
    }

    private Configuration createConfiguration(){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(getClass(), "/templates");
        return cfg;

    }
}
