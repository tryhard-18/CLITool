package org.example.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandControl {
    private List<ICommand> commands;

    public CommandControl(){
        commands = new ArrayList<>();
    }
    public void setCommand(int ind, ICommand command){
        commands.add(ind, command);
    }

    public void runCommand(int ind){
        commands.get(ind).execute();
    }


}
