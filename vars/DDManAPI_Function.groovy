//vars/DDManAPI.groovy
//#!/usr/bin/env groovy

//class PrjData {

//}
//PrjData PrjConfig = new PrjData()

def GetData(String DDManPrjVzPk = 'Hallo ich bin') {
    //String Prj
    //String VZ
    //String PK
    //Prj = DDManPrjVzPk.split(' ')[0]
    //VZ = DDManPrjVzPk.split(' ')[1]
    //PK = DDManPrjVzPk.split(' ')[2]
    //println ("${Prj}, ${VZ}, ${PK}")
    //def DDManCommand= "java -jar -Xmx1G C:\\Users\\wtammam\\AppData\\Local\\DDMan6\\release\\ddman6.jar -EXEC INTEGRATION-TEST-B PRJ=M260_M264 PS=19B_Star23_VC10 PK=L07FRG20"
    def DDManCommand= "java -X"
    def DDManexecute= DDManCommand.execute()
    def outputStream = new StringBuffer();
    DDManexecute.waitForProcessOutput(outputStream, System.err)
    def x=outputStream.toString()
    //String Prj
    //String VZ
    //String PK
    //Prj = DDManPrjVzPk.split(' ')[0]
    //VZ = DDManPrjVzPk.split(' ')[1]
    //PK = DDManPrjVzPk.split(' ')[2]
    //println ("${Prj}, ${VZ}, ${PK}")
    println ("${x}")
}

