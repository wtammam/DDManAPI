//vars/DDManAPI.groovy
//#!/usr/bin/env groovy
//package vars
class DDManAPI {

    private String JavaPath = "C:\\Program Files (x86)\\Java\\jre1.8.0_251\\bin\\java.exe"
    private String DDManPath= "C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar"
    private String JavaArchive = "-jar"
    private String JavaMemory = "-Xmx2G"
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
    def SetDDManCnnfig(String Java_Path, String DDMan_Path, String Java_Archive, String Java_Memory,String DDMan_Modus,String DD_Par) {
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
    if (Prj!=''&& VZ!=''&& PK!=''&& DDManJob!=''){
        return ("${Prj}, ${VZ}, ${PK}")
    }
   // bat JavaPath JavaArchive JavaMemory DDManPath DDManModus[1] DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
    //// }
}
}
//println ("${DDManjob}, ${Mod}")
//if (${Prj}!=''&& ${VZ}!=''&& ${PK}!=''&& DDManjob!=''){
// x= bat javapath javapar1 Javapar2 ddmanpath ddmanpar DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
// }



