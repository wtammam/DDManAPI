@Library(value="DDMan@master")
import DDManAPIClass
node(){
 def test=new DDManAPI_Function()
    def test1=new DDManAPIClass()
    //def test1 = load 'DDManAPI\\vars\\DDManAPI.groovy'
 //   agent {
//        label "abdul-executor"
 //   }

 //   environment {
  //      DISABLE_AUTH = 'true'
  //      DB_ENGINE = 'sqlite'
  //  }


        stage('Build') {
            log.info('process is started now ')
            log.warning('we have a problem but can solve it.')
            //DDManAPI_Function.GetData('ssccsc dddd ffff')
            println ("DDManAPI_Function")
            test.GetData(PARAPRJ_PARAVC_PARAPK)
            println ("DDManAPI")
            test1.GetData(PARAPRJ_PARAVC_PARAPK,Aktion,'aaa')
                //sh 'echo $DB_ENGINE'

        }

}