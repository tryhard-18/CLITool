package org.example.commands;

import org.example.commands.ICommand;

import java.util.List;

public class MacroCommand implements ICommand {
    private List<ICommand> commands;
    public MacroCommand(List<ICommand> commands){
        this.commands = commands;
    }
    @Override
    public void execute() {
        for(ICommand command: commands){
            command.execute();
        }
    }
}
