package net.minecraftforge.mcpconfig.tasks

import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile

class DepigifierTask  extends JarExec {
    @InputFile File oldPG
    @InputFile File newPG
    //@InputFile File oldMapping
    @InputFile @Optional File manualMapping
    @OutputDirectory File outDir
    @OutputFile @Optional File log = null


    @Override
    protected void preExec() {
        def logStream = log == null ? JarExec.NULL_OUTPUT : log.newOutputStream()
        def mappingPath = manualMapping == null ? "" : manualMapping.absolutePath
        standardOutput logStream
        errorOutput logStream
        setArgs(Utils.fillVariables(args, [
                'oldPG' : oldPG.absolutePath,
                'newPG' : newPG.absolutePath,
                //'srg': oldMapping.absolutePath,
                'mappings': mappingPath,
                'out' : outDir.absolutePath
        ]))
        if (!outDir.exists())
            outDir.mkdirs()
    }
}
