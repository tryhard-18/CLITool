package org.example.commands;

import org.example.entity.SubProjectDetails;

import java.io.File;


public class GenerateSubProjectCommand implements ICommand {

    private final SubProjectDetails subProjectDetails;

    public GenerateSubProjectCommand(SubProjectDetails subProjectDetails){
        this.subProjectDetails = subProjectDetails;
    }
    @Override
    public void execute() {
        File projectDir = new File(subProjectDetails.getProjectDetails().getProjectPath()
                                    , subProjectDetails.getProjectDetails().getProjectName());
        File subProjectDir = new File(projectDir, subProjectDetails.getSubProjectName());
//        File subProjectDir = subProjectDetails.getSubProjectDir();
        if(!subProjectDir.exists()){
            subProjectDir.mkdirs();
        }
        String command = "/Users/kushalkhattar/downloads/gradle-7.5.1/bin/gradle init --type java-application --project-name " +
                          subProjectDetails.getSubProjectName() + " --package " + subProjectDetails.getSourcePackageName();
        try {
            Process process = Runtime.getRuntime().exec(command, null, subProjectDir);
            process.waitFor();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(subProjectDetails.getProjectDetails().getProjectName().equals(subProjectDetails.getSubProjectName())){
            deleteFile(subProjectDir, "settings.gradle");
        }

    }

    private void deleteFile(File projectDir, String fileName){
        File file = new File(projectDir, fileName);
        if(file.exists()){
            file.delete();
        }
    }
}
