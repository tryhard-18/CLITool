package org.example.commands;

import org.example.entity.ProjectDetails;

import java.io.File;

public class GenerateProjectCommand implements ICommand {
    private final ProjectDetails projectDetails;

    public GenerateProjectCommand(ProjectDetails projectDetails){
        this.projectDetails = projectDetails;
    }
    @Override
    public void execute() {
        File projectDir = new File(projectDetails.getProjectPath(), projectDetails.getProjectName());
//        File projectDir = projectDetails.getProjectDir();
        if (!projectDir.exists()) {
            projectDir.mkdirs();
        }
        String command = "/Users/kushalkhattar/downloads/gradle-7.5.1/bin/gradle init --type java-application";

        try {
            Process process = Runtime.getRuntime().exec(command, null, projectDir);
            process.waitFor();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
