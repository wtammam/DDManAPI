//vars/DDManAPI.groovy
//#!/usr/bin/env groovy
//package vars
class DDManAPI {

    private String JavaPath = "C:\\Program Files (x86)\\Java\\jre1.8.0_251\\bin\\java.exe"
    private String DDManPath= "C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar"
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
        def lisle= [this.JavaPath, this.DDManPath, this.JavaArchive, this.JavaMemory, this.DDManModus , this.DDPar]
        return lisle
    }

def GetData() {
    String Prj
    String VZ
    String PK
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK = DDManPrjVzPk.split(' ')[2]

    //return ("${Prj}, ${VZ}, ${PK}")
    //return DDManPrjVzPk
    if (Prj!=''&& VZ!=''&& PK!=''&& DDManJob!=''){
        //execute( 'bat', 'echo ok')
        //def x= "cmd /c ${JavaPath} ${JavaArchive} ${JavaMemory} ${DDManPath} ${DDManModus[1]} ${DDManJob} ${Prj} ${VZ} ${PK} ${DDPar}".execute().text
        def DDManCommand= "\"${JavaPath}\" ${JavaArchive} ${JavaMemory} ${DDManPath} ${DDManModus[0]} ${DDManJob} PRJ=${Prj} PS=${VZ} PK=${PK} DB=${DDPar}"
        //println(Command)
        def sout = new StringBuilder()
        def serr = new StringBuilder()
        def DDManexecute= DDManCommand.execute()
        DDManexecute.waitFor()
        def test3=DDManexecute.text
        //test3.waitFor()
        //DDManexecute.consumeProcessOutput(sout, serr)
        //def args = ['cmd', '/c', 'C:\\Users\\AAithal\\Desktop\\MIR3\\bin\\inConsole', '-H', 'company.mir3.com', '-u', 'user', '-p', 'password', '-I', '-i', 'Server']
        //def proc = new ProcessBuilder( args )
        //Process process = proc.start()
        return ("${DDManexecute}")
        //return ("${Command}")
        //return ("${Prj}, ${VZ}, ${PK}")

    }


}
}
//println ("${DDManjob}, ${Mod}")
//if (${Prj}!=''&& ${VZ}!=''&& ${PK}!=''&& DDManjob!=''){
// x= bat javapath javapar1 Javapar2 ddmanpath ddmanpar DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
// }



