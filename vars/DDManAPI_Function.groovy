//vars/DDManAPI.groovy
//#!/usr/bin/env groovy

//class PrjData {

//}
//PrjData PrjConfig = new PrjData()

def GetData(String DDManPrjVzPk = 'Hallo ich bin') {
    String Prj
    String VZ
    String PK
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK = DDManPrjVzPk.split(' ')[2]
    println ("${Prj}, ${VZ}, ${PK}")
    //NUfal
    /*def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20"
    def DDManCommand= "java -X >c:\\temp\\a.txt 2>&1"
    def DDManexecute= DDManCommand.execute()
    def outputStream = new StringBuffer();
    DDManexecute.waitForProcessOutput(outputStream, System.err)
    def x=outputStream.toString()

    println ("${x}")*/
    //Wajih
    /*def sout = new StringBuilder(), serr = new StringBuilder()
    //def proc = 'java -X >c:\\temp\\a.txt 2>&1'.execute()
    def proc = 'runas /wtammam:itk "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20"'.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitForOrKill(1000)
    println "out> $sout err> $serr"    def sout = new StringBuilder(), serr = new StringBuilder()
    //def proc = 'java -X >c:\\temp\\a.txt 2>&1'.execute()
    def proc = 'runas /wtammam:itk "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20"'.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitForOrKill(1000)
    println "out> $sout err> $serr"*/


}
//Function to git anzuwerfen und einen bestimmten Branch auszugeben.
def git_own_f(String WorkSpace1,String Branchname,String Repository){
    def outputstream = new StringBuilder()
    def errorstream = new StringBuilder()
    def process
    def cmdcommand ="cmd /c git init"
    cmdcommand= cmdcommand + " & git fetch --progress ${Repository} +refs/heads/${Branchname}:refs/remotes/${Branchname} --depth 1"
    cmdcommand= cmdcommand + " & git --git-dir=.\\.git --work-tree=.\\. checkout ${Branchname} -f"
    cmdcommand= cmdcommand + " & rd .git /S /Q"
    println cmdcommand
    def output=""
    def result=0
    def abbruch=0

    try{
        bat "where cmd"
        println WorkSpace1
        process = cmdcommand.execute(null, new File("${WorkSpace1}"))
        println "process-waitForProcessOutput(outputstream, errorstream)"
        process.waitForProcessOutput(outputstream, errorstream)
        println "process-waitForProcessOutput(outputstream, errorstream)"
        output = cmdcommand + "\n"
        output += outputstream.toString() + errorstream.toString()
        output += "exit[${process.exitValue()}]"
        if(process.exitValue()!=0){
            result = 1
            abbruch = -1
        }
    }
    catch(IOException){
        result =1
        abbruch =-1
        println "result"+result
        println "result"+abbruch
    }

//	println output
//	println result
    return [output, result, abbruch]
}

//todo -> git_own tag and sparse should be put into git_own (+params)
def git_own_f_tag(String WorkSpace1,String Tag,String Repository){
    def outputstream = new StringBuilder()
    def errorstream = new StringBuilder()
    def process
    def cmdcommand ="cmd /c git init"
    cmdcommand= cmdcommand + " & git fetch --progress ${Repository} +refs/heads/${Tag}:refs/remotes/${Tag} --depth 1"
    cmdcommand= cmdcommand + " & git --git-dir=.\\\\.git --work-tree=.\\\\. checkout ${Tag} -f"
    cmdcommand= cmdcommand + " & git show -s > GITINFO.txt"
    cmdcommand= cmdcommand + " & rd .git /S /Q"
    def output=""
    def result=0
    def abbruch=0
    try{
        process = cmdcommand.execute(null, new File("${WorkSpace1}"))
        process.waitForProcessOutput(outputstream, errorstream)
        output = cmdcommand + "\n"
        output += outputstream.toString() + errorstream.toString()
        output +="exit[${process.exitValue()}]"
        if(process.exitValue()!=0){
            result =1
            abbruch = -1
        }
    }
    catch(IOException){
        result =1
        abbruch =-1
    }

//	println output
//	println result
    return [output, result, abbruch]
}

def git_own_f_sparse(String WorkSpace1,String Branchname,String Repository,String subfolders){
    def outputstream = new StringBuilder()
    def errorstream = new StringBuilder()
    def process
    def cmdcommand ="cmd /c git init"
    cmdcommand= cmdcommand + " & git fetch --progress ${Repository} +refs/heads/${Branchname}:refs/remotes/${Branchname} --depth 1"
    cmdcommand= cmdcommand + " & git --git-dir=.\\\\.git --work-tree=.\\\\. checkout ${Branchname} -f -- ${subfolders}"
    cmdcommand= cmdcommand + " & git show -s > GITINFO.txt"
    cmdcommand= cmdcommand + " & rd .git /S /Q"
    def output=""
    def result=0
    def abbruch=0

    try{
        process = cmdcommand.execute(null, new File("${WorkSpace1}"))
        process.waitForProcessOutput(outputstream, errorstream)
        output = cmdcommand + "\n"
        output += outputstream.toString() + errorstream.toString()
        output += "exit[${process.exitValue()}]"
        if(process.exitValue()!=0){
            result = 1
            abbruch = -1
        }

    }
    catch(IOException){
        result =1
        abbruch =-1
    }

//	println output
//	println result
    return [output, result, abbruch]
}

def streamContainsErrors2(def stream, def preresult, searchedStrings){
    def result = 0
    def errorString = []
    def abbruch=0

    for (int i = 0; i < searchedStrings.size(); i++) {
        if(stream.contains(searchedStrings[i])){
            errorString.add(searchedStrings[i])
            result = 1
            abbruch =-1
        }
    }
    if ((preresult==1)||(result==1)){
        result = 1
        abbruch =-1

    }
    return [result,errorString,abbruch]
}

