//vars/DDManAPI.groovy
//#!/usr/bin/env groovy
//package vars
class DDManAPI {

    private String JavaPath = "C:\\Program Files (x86)\\Java\\jre1.8.0_251\\bin\\java.exe"
    //private String JavaPath = "C:\\Program Files\\Java\\jre1.8.0_251\\bin\\java.exe"
    private String DDManPath= "C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release"
    private String JavaArchive = "-jar"
    private String JavaMemory = "-Xmx1G"
    private String [] DDManModus = ["-EXEC", "-MOD"]
    private String DDPar = "DDMAN6"
    private String DDManPrjVzPk
    private String DDManJob
    private String OldNewAPI

    DDManAPI(String DDMan_PrjVzPk, String DDMan_Job, String OldNew_API) {
        this.DDManPrjVzPk = DDMan_PrjVzPk
        this.DDManJob = DDMan_Job
        this.OldNewAPI = OldNew_API

        //return "${DDManPrjVzPk}"
        //return "Hallo"
    }
    def SetDDManConfig(String Java_Path, String DDMan_Path, String Java_Archive, String Java_Memory,String DDMan_Modus,String DD_Par) {
        this.JavaPath = Java_Path
        this.DDManPath = DDMan_Path
        this.JavaArchive = Java_Archive
        this.JavaMemory = Java_Memory
        this.DDManModus = DDMan_Modus
        this.DDPar = DD_Par
    }
    def GetDDManConfig() {
        def lisle= [this.JavaPath, this.JavaArchive, this.JavaMemory, this.DDManPath, this.DDManModus , this.DDPar]
        return lisle
    }

def GetData() {
    String Prj
    String VZ
    String PK
    String DDManJobOld
    String [] DDManJobNew
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK = DDManPrjVzPk.split(' ')[2]
    def sout = new StringBuilder()
    def serr = new StringBuilder()
    def sum = new StringBuilder("")
    def DDManCommand
    def proc
    String DDManOldAPI=DDManPath+"\\ddman6.jar"
    String DDManNewAPI=DDManPath+"\\ddmanExportClient\\ddmanExportClient.jar"
    String WORKINGPLACE="C:\\meinedaten\\sgprojekte\\"+"${Prj}\\${VZ}\\${PK}"
    switch(DDManJob) {
        case "Integration":
            DDManJobOld = "INTEGRATION-TEST-A";
            DDManJobNew =["KOMMANDO=\"GET_CODE TARGET=${WORKINGPLACE}\""]
            break;
        case "DOKU/DCM/DAISTRUCT/A2L/KGS":
            DDManJobOld = "INTEGRATION-TEST-B";
            DDManJobNew =["DOKU","DCM","DAI_STRUCT","ASAP","KGSXML","DOKUXML","KGS"]
            break;
        case "A2L/DOKUu/KGS/DCM/DAISTRUCT":
            DDManJobOld = "INTEGRATION-TEST-C";
            DDManJobNew =[""]
            break;
        case "FDEF":
            DDManJobOld = "FDEF";
            DDManJobNew =["KOMMANDO=\"GET_FDEF TARGET=${WORKINGPLACE}\\description\""]
            break;
        case "FDEFMDX":
            DDManJobOld = "FDEFMDX";
            DDManJobNew =["KOMMANDO=\"GET_FDEF TARGET=${WORKINGPLACE}\\description\""]
            break;
        default:
            break;
    }
    //return ("${Prj}, ${VZ}, ${PK}")
    //return DDManPrjVzPk
    if (Prj!=''&& VZ!=''&& PK!=''&& DDManJob!=''){
        //execute( 'bat', 'echo ok')
        //def x= "cmd /c ${JavaPath} ${JavaArchive} ${JavaMemory} ${DDManPath} ${DDManModus[1]} ${DDManJob} ${Prj} ${VZ} ${PK} ${DDPar}".execute().text

        //try {
            switch(OldNewAPI){
                case "OLD":
                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManOldAPI} ${DDManModus[0]} ${DDManJobOld} PRJ=${Prj} PS=${VZ} PK=${PK} DB=${DDPar}"
                    //def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20 >c:\\temp\\test.txt 2>&1"
                    proc = DDManCommand.execute()
                    proc.waitForProcessOutput(sout, serr)
                    sum.append(DDManCommand)
                    sum.append(sout)
                    sum.append(serr)
                    break;
                case "NEW":
                    if(DDManJob=="Integration" ||DDManJob=="FDEF") {
                        DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[0]} ${DDManJobNew[0]} PRJ=${Prj} PS=${VZ} PK=${PK}"
                        //def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20 >c:\\temp\\test.txt 2>&1"
                        proc = DDManCommand.execute()
                        proc.waitForProcessOutput(sout, serr)
                        sum.append(DDManCommand)
                        sum.append(sout)
                        sum.append(serr)
                    }
                    else if(DDManJob=="DOKU/DCM/DAISTRUCT/A2L/KGS") {
                        if (Prj != "PT3_Otto") {
                            for (int i = 0; i < DDManJobNew.length - 2; i++) {
                                if (i != 2 || i != 3) {
                                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJobNew[i]} -PRJ ${Prj} -SGP ${VZ} -PRG ${PK} -DIR ${WORKINGPLACE}\\description"
                                } else {
                                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJobNew[i]} -PRJ ${Prj} -SGP ${VZ} -PRG ${PK} -DIR ${WORKINGPLACE}"
                                }
                                proc = DDManCommand.execute()
                                sout.append(DDManCommand)
                                proc.waitForProcessOutput(sout, serr)
                                //sum.append(DDManCommand)
                                //sum.append(sout)
                                //sum.append(serr)
                            }
                        } else {
                            for (int i = 0; i < DDManJobNew.length; i++) {
                                if (i != 3 || i != 4) {
                                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJobNew[i]} -PRJ ${Prj} -SGP ${VZ} -PRG ${PK} -DIR ${WORKINGPLACE}\\description"
                                    proc = DDManCommand.execute()
                                    proc.waitForProcessOutput(sout, serr)
                                }
                            }
                        }
                    }
                    break;
                default:
                    break;
            }

            //proc.waitFor(1200, TimeUnit.SECONDS)
            //proc.waitForOrKill(1800*1000)
            //proc.wait
            //println "out> $sout err> $serr"
            //def DDManCommand= "java -X"
            //def DDManCommand= "cmd /c echo hallo welt"
            //println(Command)
            // def sout = new StringBuilder()
            //def serr = new StringBuilder()
            //def DDManexecute= DDManCommand.execute()
            //def outputStream = new StringBuffer();
            //DDManexecute.waitForProcessOutput(outputStream, System.out)

            //DDManexecute.waitFor()
            //DDManexecute.waitFor()

            //def test3=DDManexecute.text
            //test3.waitFor()
            //DDManexecute.consumeProcessOutput(sout, serr)
            //def args = ["cmd.exe", "/c",JavaPath, JavaArchive, JavaMemory, DDManPath, DDManModus[0], DDManJob, "PRJ=${Prj}", "PS=${VZ}", "PK=${PK}", "DB=${DDPar}"]
            //String[] commandArray = args.toArray(new String[args.size()]);
            //ProcessBuilder  proc = new ProcessBuilder(args)
            //Process process = proc.start()
            //return ("${outputStream.toString()}")
            //return ("$DDManCommand, $sout, $serr")
            return ("$sum")
       // } catch(Exception e) {
        //return("Exception: ${e}")
   // }
        //return (process)
        //return ("${Prj}, ${VZ}, ${PK}")

    }


}
}
//println ("${DDManjob}, ${Mod}")
//if (${Prj}!=''&& ${VZ}!=''&& ${PK}!=''&& DDManjob!=''){
// x= bat javapath javapar1 Javapar2 ddmanpath ddmanpar DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
// }

//def processBuilder = new ProcessBuilder();

//processBuilder.command("cmd.exe", "/c",JavaPath, JavaArchive, JavaMemory, DDManPath, DDManModus[0], DDManJob, "PRJ=${Prj}", "PS=${VZ}", "PK=${PK}", "DB=${DDPar}");
//def process = processBuilder.start();
//def ret = process.waitFor();
//return ("${ret}")

