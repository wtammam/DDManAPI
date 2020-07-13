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
    private String DDManAPI

    DDManAPI(String DDMan_PrjVzPk, String DDMan_Job, String DDMan_API) {
        this.DDManPrjVzPk = DDMan_PrjVzPk
        this.DDManJob = DDMan_Job
        this.DDManAPI = DDMan_API

        //return "${DDManPrjVzPk}"
        //return "Hallo"
    }
    def SetDDManConfig(String Java_Path, String DDMan_Path, String Java_Archive, String Java_Memory,String DDMan_Modus,String DD_Par) {
        if(Java_Path!='') {
            this.JavaPath = Java_Path
        }
        if(DDMan_Path!='') {
            this.DDManPath = DDMan_Path
        }
        if(Java_Archive!='') {
            this.JavaArchive = Java_Archive
        }
        if(Java_Memory!='') {
            this.JavaMemory = Java_Memory
        }
        if(DDMan_Modus!='') {
            this.DDManModus = DDMan_Modus
        }
        if(DD_Par!='') {
            this.DDPar = DD_Par
        }
    }
    def SetDDManAPI(DDMan_API) {
        if(SET_API!='') {
            this.DDManAPI = DDMan_API
        }

    }
    def GetDDManConfig() {
        def lisle= [this.JavaPath, this.JavaArchive, this.JavaMemory, this.DDManPath, this.DDManModus , this.DDPar]
        return lisle
    }


def GetData() {
    String Prj
    String VZ
    String PK_Pre
    String PK
    String DDManJobOld
    String [] DDManJobNew
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK_Pre = DDManPrjVzPk.split(' ')[2]
    PK = PK_Pre.replaceAll("_EngBuild", "")
    def sout = new StringBuilder()
    def serr = new StringBuilder()
    //def sum = new StringBuilder("")
    //def DDManCommand
    //def proc
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
        case "UWK":
            DDManJobOld = "INTEGRATION-TEST-C";
            DDManJobNew =["KOMMANDO=\"GET_ALL SUB_DIR=matlab/tlcode;SUFFIX={.a2l};TARGET=${WORKINGPLACE}\\description/avl_a2l\"","KOMMANDO=\"GET_ALL SUB_DIR=matlab/tlcode;SUFFIX={.xlsx};TARGET=${WORKINGPLACE}\\temp_SiL/UWK_xlsx\"","NORM"]
            break;
        case "FDEF":
            DDManJobOld = "FDEF";
            DDManJobNew =["KOMMANDO=\"GET_FDEF TARGET=${WORKINGPLACE}\\description\"","KOMMANDO=\"GENERATE MDX TARGET=${WORKINGPLACE}\\description\""]
            break;
        case "KGSXML":
            DDManJobOld = "KGSXML";
            DDManJobNew =["KGSXML"]
            break;
        case "Schnittstellenanalyse":
            DDManJobOld = "SSA";
            DDManJobNew =["SSA"]
            break;
        default:
            break;
    }
    //return ("${Prj}, ${VZ}, ${PK}")
    //return DDManPrjVzPk
    if (Prj!=''&& VZ!=''&& PK!=''&& DDManJob!='' && DDManAPI!=""){
        //execute( 'bat', 'echo ok')
        //def x= "cmd /c ${JavaPath} ${JavaArchive} ${JavaMemory} ${DDManPath} ${DDManModus[1]} ${DDManJob} ${Prj} ${VZ} ${PK} ${DDPar}".execute().text

        //try {
        switch(DDManAPI){
            case "OLD":
                sout = OldDDManAPI(Prj, VZ, PK,DDManJobOld)[0]
                serr = OldDDManAPI(Prj, VZ, PK,DDManJobOld)[1]
                break;
            case "NEW":
                sout = OldDDManAPI(Prj, VZ, PK,DDManJobOld)[0]
                serr = OldDDManAPI(Prj, VZ, PK,DDManJobOld)[1]
                break;
           /* case "AUTO":
                SetDDManAPI("NEW")
                def temp = new DDManAPI("${Prj} ${VZ} ${PK}","Schnittstellenanalyse","NEW")
                temp.GetData()
                sout.append("\n************************** Export ${OldNewAPI} ${Prj} ${VZ} ${PK} **************************\n")
                break*/
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
            return ("$sout, $serr")
       // } catch(Exception e) {
        //return("Exception: ${e}")
   // }
        //return (process)
        //return ("${Prj}, ${VZ}, ${PK}")

    } else {

        return ("Error please set the Parameter")
    }


}

    private String [] OldDDManAPI(String Projekt, String VZyklus, String PKonfiguration, String DDManJob_Old){
        String DDManOldAPI=DDManPath+"\\ddman6.jar"
        String WORKINGPLACE="C:\\meinedaten\\sgprojekte\\"+"${Projekt}\\${VZyklus}\\${PKonfiguration}"
        def sout = new StringBuilder()
        def serr = new StringBuilder()
        def DDManCommand
        def proc
        if(DDManJob=="Schnittstellenanalyse"){
            DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManOldAPI} ${DDManModus[1]} ${DDManJob_Old} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DAT C:\\meinedaten\\Schnittstellenanalyse.txt -DB ${DDPar}"
        }
        else if(DDManJob=="KGSXML"){
            DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManOldAPI} ${DDManModus[1]} ${DDManJob_Old} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DAT ${WORKINGPLACE}\\description\\agk.xml -DB ${DDPar}"
        } else {
            DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManOldAPI} ${DDManModus[0]} ${DDManJob_Old} PRJ=${Projekt} PS=${VZyklus} PK=${PKonfiguration} DB=${DDPar}"
            //def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20 >c:\\temp\\test.txt 2>&1"
        }
        proc = DDManCommand.execute()
        sout.append("\n************************** Export ${DDManJob_Old} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
        sout.append(DDManCommand)
        sout.append("\n")
        proc.waitForProcessOutput(sout, serr)
        return new String [] {"$sout", "$serr"}
    }

    private String [] NewDDManAPI(String Projekt, String VZyklus, String PKonfiguration, String [] DDManJob_New){
        String DDManNewAPI=DDManPath+"\\ddmanExportClient\\ddmanExportClient.jar"
        String WORKINGPLACE="C:\\meinedaten\\sgprojekte\\"+"${Projekt}\\${VZyklus}\\${PKonfiguration}"
        def sout = new StringBuilder()
        def serr = new StringBuilder()
        def DDManCommand
        def proc
        if(DDManJob=="Integration" || DDManJob=="FDEF") {
            for (int i = 0; i < DDManJob_New.length ; i++) {
                DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[0]} ${DDManJob_New[i]} PRJ=${Projekt} PS=${VZyklus} PK=${PKonfiguration} DB=${DDPar}"
                //def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20 >c:\\temp\\test.txt 2>&1"
                proc = DDManCommand.execute()
                sout.append("\n************************** Export ${DDManJob_New[0]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
                sout.append(DDManCommand)
                sout.append("\n")
                proc.waitForProcessOutput(sout, serr)
            }
        }
        else if(DDManJob=="DOKU/DCM/DAISTRUCT/A2L/KGS") {

            for (int i = 0; i < DDManJob_New.length ; i++) {
                if (Projekt != "PT3_Otto_M274") {
                    if (i ==2 || i == 3) {
                        DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[i]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DIR ${WORKINGPLACE} -DB ${DDPar}"
                    } else {
                        DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[i]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DIR ${WORKINGPLACE}\\description -DB ${DDPar}"
                    }
                    if(i != 5 && i != 6) {
                        proc = DDManCommand.execute()
                        sout.append("\n************************** Export ${DDManJob_New[i]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
                        sout.append(DDManCommand)
                        sout.append("\n")
                        proc.waitForProcessOutput(sout, serr)
                    }
                } else {
                    if (i == 2) {
                        DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[i]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DIR ${WORKINGPLACE} -DB ${DDPar}"
                    } else {
                        DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[i]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DIR ${WORKINGPLACE}\\description -DB ${DDPar}"
                    }
                    if(i != 3 && i != 4) {
                        proc = DDManCommand.execute()
                        sout.append("\n************************** Export ${DDManJob_New[i]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
                        sout.append(DDManCommand)
                        sout.append("\n")
                        proc.waitForProcessOutput(sout, serr)

                    }
                }
            }
        }
        else if(DDManJob=="UWK") {
            for (int i = 0; i < DDManJob_New.length; i++) {
                if (Projekt != "PT3_Otto_M274") {
                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[0]} ${DDManJob_New[i]} PRJ=${Projekt} PS=${VZyklus} PK=${PKonfiguration} DB=${DDPar}"
                    if(i != 2){
                        proc = DDManCommand.execute()
                        sout.append("\n************************** Export ${DDManJob_New[i]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
                        sout.append(DDManCommand)
                        sout.append("\n")
                        proc.waitForProcessOutput(sout, serr)
                    }
                } else {
                    DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[i]} -DIR ${WORKINGPLACE}\\description -DB ${DDPar}"
                    if(i == 2) {
                        proc = DDManCommand.execute()
                        sout.append("\n************************** Export ${DDManJob_New[i]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
                        sout.append(DDManCommand)
                        sout.append("\n")
                        proc.waitForProcessOutput(sout, serr)
                    }
                }

            }
        }
        else if(DDManJob=="Schnittstellenanalyse") {
            DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[0]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DAT ${WORKINGPLACE}\\Schnittstellenanalyse.txt -DB ${DDPar}"
            proc = DDManCommand.execute()
            sout.append("\n************************** Export ${DDManJob_New[0]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
            sout.append(DDManCommand)
            sout.append("\n")
            proc.waitForProcessOutput(sout, serr)
        }
        else if(DDManJob=="KGSXML") {
            DDManCommand = "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManNewAPI} ${DDManModus[1]} ${DDManJob_New[0]} -PRJ ${Projekt} -SGP ${VZyklus} -PRG ${PKonfiguration} -DAT ${WORKINGPLACE}\\description\\agk.xml -DB ${DDPar}"
            proc = DDManCommand.execute()
            sout.append("\n************************** Export ${DDManJob_New[0]} ${Projekt} ${VZyklus} ${PKonfiguration} **************************\n")
            sout.append(DDManCommand)
            sout.append("\n")
            proc.waitForProcessOutput(sout, serr)
        }
        return new String [] {"$sout", "$serr"}
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

