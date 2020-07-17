@Library(value="DDMan@master") _
import DDManAPI

node(){
    //script {
        def test = new DDManAPI_Function()
        def test1 = new DDManAPI(PARAPRJ_PARAVC_PARAPK,Aktion,DDMan_API)
   // }
    //def test1 = load 'DDManAPI\\vars\\DDManAPI.groovy'
 //   agent {
//        label "abdul-executor"
 //   }

 //   environment {
  //      DISABLE_AUTH = 'true'
  //      DB_ENGINE = 'sqlite'
  //  }


        stage('Build') {
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

        }

}