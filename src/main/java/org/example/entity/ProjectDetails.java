package org.example.entity;

import java.io.File;

public class ProjectDetails {
    private final String projectName;
    private final String projectPath;
//    private final File projectDir;
    public ProjectDetails(String projectName, String projectPath){
        this.projectName = projectName;
        this.projectPath = projectPath;
//        this.projectDir = new File(projectPath, projectName);
    }

    public String getProjectName(){
        return projectName;
    }
    public String getProjectPath(){
        return projectPath;
    }
//    public File getProjectDir(){
//        return projectDir;
//    }
}
