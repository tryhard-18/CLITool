package org.example.entity;

import java.io.File;

public class SubProjectDetails {
    private final ProjectDetails projectDetails;
    private final String subProjectName;
    private final String sourcePackageName;
//    private final File subProjectDir;
    public SubProjectDetails(ProjectDetails projectDetails, String subProjectName, String sourcePackageName){
        this.projectDetails = projectDetails;
        this.subProjectName = subProjectName;
        this.sourcePackageName = sourcePackageName;
//        this.subProjectDir = new File(projectDetails.getProjectDir(), subProjectName);
    }

    public ProjectDetails getProjectDetails(){
        return projectDetails;
    }

    public String getSubProjectName(){
        return subProjectName;
    }

    public String getSourcePackageName(){
        return sourcePackageName;
    }

//    public File getSubProjectDir(){
//        return subProjectDir;
//    }

}
