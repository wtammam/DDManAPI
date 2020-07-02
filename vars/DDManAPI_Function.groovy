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

    def DDManexecute= DDManCommand.execute()
    def outputStream = new StringBuffer();
    DDManexecute.waitForProcessOutput(outputStream, System.out)
    //String Prj
    //String VZ
    //String PK
    //Prj = DDManPrjVzPk.split(' ')[0]
    //VZ = DDManPrjVzPk.split(' ')[1]
    //PK = DDManPrjVzPk.split(' ')[2]
    //println ("${Prj}, ${VZ}, ${PK}")
    println ("${outputStream.toString()}")
}

