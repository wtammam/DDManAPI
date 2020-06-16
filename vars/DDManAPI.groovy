//vars/DDManAPI.groovy
//#!/usr/bin/env groovy
//package vars
class DDManAPI {

    //String javapath='C:\\Program Files (x86)\\Java\\jre1.8.0_251\\bin\\java.exe'
    //String ddmanpath='C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar'
    //String javapar1='-jar'
    //String Javapar2='-Xmx2G'
    //String ddmanpar='-EXEC'
    //String ddpar='DDMAN6'
    //String DDManPrjVzPk
    def DDManAPI1() {
        return "Hallo"
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
def GetData(String DDManPrjVzPk, String DDManjob, String Mod) {
    String Prj
    String VZ
    String PK
    Prj = DDManPrjVzPk.split(' ')[0]
    VZ = DDManPrjVzPk.split(' ')[1]
    PK = DDManPrjVzPk.split(' ')[2]
    println ("${Prj}, ${VZ}, ${PK}")
    //println ("${DDManjob}, ${Mod}")
    //if (${Prj}!=''&& ${VZ}!=''&& ${PK}!=''&& DDManjob!=''){
   // x= bat javapath javapar1 Javapar2 ddmanpath ddmanpar DDManjob -PRJ Prj -SGP VZ -PRG PK -DB ddpar
   // }
}
}




