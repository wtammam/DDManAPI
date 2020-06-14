@Library(value="DDMan@master") _
node(){
 def test=new DDManAPI_Function()
    def test1=new DDManAPI()
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
            test.GetData(PARAPRJ_PARAVC_PARAPK)
            test1.GetData(PARAPRJ_PARAVC_PARAPK, "Job","Mod")
                //sh 'echo $DB_ENGINE'

        }

}