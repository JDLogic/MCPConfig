package net.minecraftforge.mcpconfig.tasks

import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile

class MappingGeneratorTask extends JarExec {
    @InputFile File input
    @InputFile File conf
    @InputFile File mapping
    @InputFile File libs
    @OutputFile File log
    @OutputFile File dest

    @Override
    protected void preExec() {
        setArgs(Utils.fillVariables(args, [
                'input': input,
                'conf': conf,
                'mapping': mapping,
                'libs': libs,
                'log': log,
                'output': dest
        ]))
    }
}
