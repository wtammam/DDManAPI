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
def git_own_f(String WorkSpace1,String Branchname,String Repository){
    def outStream = new StringBuilder()
    def outError = new StringBuilder()
    def proc
    def cmd = "git init".execute() & "git fetch --progress ${Repository} +refs/heads/${Branchname}:refs/remotes/${Branchname} --depth 1".execute()
    //proc=cmd.execute()
    cmd.waitForProcessOutput(outStream, outError)
    println(outStream.toString())
    println(outError.toString())
    /*def cmd = new StringBuilder()
    cmd.append("git init\n")
    cmd.append("git fetch --progress ${Repository} +refs/heads/${Branchname}:refs/remotes/${Branchname} --depth 1\n")
    cmd.append("git --git-dir=.\\.git --work-tree=.\\. checkout ${Branchname} -f\n")
    cmd.append("rd .git /S /Q\n")
    def output=""
    def result=0
    def abbruch=0

    try{
        dir(WorkSpace1){
            output=bat (label:"git checkout/s ${Repository}/s ${Branchname}/s --depth 1", returnStdout:true, script:"${cmd.toString()}")
                   /* """
					git init
					git fetch --progress ${Repository} +refs/heads/${Branchname}:refs/remotes/${Branchname} --depth 1 
					git --git-dir=.\\.git --work-tree=.\\. checkout ${Branchname} -f 
					rd .git /S /Q
				"""]).trim()
        }
    }
    catch(IOException){
        result =1
        abbruch =-1
    }

	//println output
	//println result
   return [output, result, abbruch]*/
    return [outStream.toString(), outError.toString(), 0]
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

