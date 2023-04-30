package org.example;

import org.example.commands.*;
import org.example.entity.ProjectDetails;
import org.example.entity.SubProjectDetails;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        String projectName = "dummy";
        String projectPath = "/Users/kushalkhattar/desktop/flh";

        ProjectDetails projectDetails = new ProjectDetails(projectName, projectPath);

        String subProjectName = "dummy1";
        String sourcePackageName = "dmy";
        SubProjectDetails subProjectDetails = new SubProjectDetails(projectDetails, subProjectName, sourcePackageName);

        List<String> dependencies = new ArrayList<>();
        dependencies.add("Mongo");
        dependencies.add("Elastic");

        ICommand generateProjectCommand = new GenerateProjectCommand(projectDetails);

        ICommand generateSubProjectCommand = new GenerateSubProjectCommand(subProjectDetails);

        ICommand writeCommand = new WriteCommand(subProjectDetails, dependencies);

        List<ICommand> commands = new ArrayList<>();
        commands.add(generateProjectCommand);

        ICommand macroCommand = new MacroCommand(commands);

        CommandControl commandControl = new CommandControl();
        commandControl.setCommand(0, macroCommand);
        commandControl.setCommand(1, generateSubProjectCommand);
        commandControl.setCommand(2, writeCommand);

//        commandControl.runCommand(0);
        commandControl.runCommand(1);
        commandControl.runCommand(2);



    }
}