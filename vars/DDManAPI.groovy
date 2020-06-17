//vars/DDManAPI.groovy
//#!/usr/bin/env groovy
//package vars
class DDManAPI {

    private String Javapath = "C:\\Program Files (x86)\\Java\\jre1.8.0_251\\bin\\java.exe"
    private String DDManpath= ":\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar"
    private String JavaArchive = "-jar"
    private String JavaMemory = "-Xmx2G"
    private String [] DDManModus = ["-EXEC", "-MOD"]
    private String DDpar = "DDMAN6"
    private String DDManPrjVzPk
    private String DDManjob
    private String Modus

    DDManAPI(String PrjVzPk, String Job, String Mod) {
        this.DDManPrjVzPk = PrjVzPk
        this.DDManjob = Job
        this.Modus = Mod
        //return "${DDManPrjVzPk}"
        //return "Hallo"
    }
    def SetDDManCnnfig(String Java_path, String DDMan_path, String Java_Archive, String Java_Memory,String DDMan_Modus,String DD_par) {
        this.Javapath = Java_path
        this.DDManpath = DDMan_path
        this.JavaArchive = Java_Archive
        this.JavaMemory = Java_Memory
        this.DDManModus = DDMan_Modus
        this.DDpar = DD_par
    }
    def GetDDManCnnfig() {
        def liste= [this.Javapath, this.DDManpath, this.JavaArchive, this.JavaMemory, this.DDManModus , this.DDpar]
        return liste
    }


    //def DDManAPI(String JavaPath, String DDManPa
    //Possible solutions: each(groovy.lang.Closure), gth, String JavaPar1, String JavaPar2, String DDManpar, String DDpar) {
     //   this.javapath = JavaPath
     //   this.ddmanpath = DDManPath
      //  this.javapar1 = JavaPar1
      //  this.javapar2 = JavaPar2
       // this.ddmanpar = DDManpar
       // this.ddpar = DDpar
    //println ("Test 2")
   // }
    // String DDManPrjVzPk, String DDManjob, String Modus
def GetData() {
    String Prj
    String VZ
    String PK
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK = DDManPrjVzPk.split(' ')[2]
    return ("${Prj}, ${VZ}, ${PK}")
    //println ("${DDManjob}, ${Mod}")
    //if (${Prj}!=''&& ${VZ}!=''&& ${PK}!=''&& DDManjob!=''){
   // x= bat javapath javapar1 Javapar2 ddmanpath ddmanpar DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
   // }
}
}




