@Library(value="DDMan@master") _
import DDManAPI

node(){
    //script {
        def test = new DDManAPI_Function()
        def test1 = new DDManAPI(PARAPRJ_PARAVC_PARAPK,Aktion,DDMan_API)
    String WorkSpace1="C:\\meineDaten"
    String Branchname="xxxxxx"
    String Repository="https://git.daimler.com/rd-pef/BOSCH_M139_M177.git"
   // }
    //def test1 = load 'DDManAPI\\vars\\DDManAPI.groovy'
 //   agent {
//        label "abdul-executor"
 //   }

 //   environment {
  //      DISABLE_AUTH = 'true'
  //      DB_ENGINE = 'sqlite'
  //  }
    stage('Test') {
        def slaveJob1e1=test.git_own_f(WorkSpace1,Branchname,Repository)
        def result=""
        println ("start")
        print slaveJob1e1[0].toString
        println ("start")
        //batCommand.streamContainsErrors2(stream, preresult, searchedStrings) -> return [result,errorString,abbruch]
        /*def slaveJob1e=test.streamContainsErrors2(slaveJob1e1[0].toString(),slaveJob1e1[1],["fatal","error"])
        result+=slaveJob1e[0]
        bat ([label:"found ${slaveJob1e[1]}", returnStdout:false, script:"exit ${slaveJob1e[2]}"])*/

    }

       /* stage('Build') {
            //def test1 = new DDManAPI()
            log.info('process is started now ')
            log.warning('we have a problem but can solve it.')
            //DDManAPI_Function.GetData('ssccsc dddd ffff')
            println ("DDManAPI_Function")
            test.GetData(PARAPRJ_PARAVC_PARAPK)
            println ("DDManAPI")
            //println "${test1.DDManAPI1(PARAPRJ_PARAVC_PARAPK, "INTEGRATION-TEST-A", 'DDManAPI')}"
            // PARAPRJ_PARAVC_PARAPK,"Aktion",'aaa'
            println "${test1.GetDDManConfig()}"
            println "${test1.GetData()}"
           // test1.SetDDManConfig("aa","bb","cc","dd","ee","ff")
            //println "${test1.GetDDManConfig()}"
                //sh 'echo $DB_ENGINE'

        }*/

}