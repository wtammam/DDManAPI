@Library('DDManAPI') _
node(){
    def test=new DDManAPI()
 //   agent {
//        label "abdul-executor"
 //   }

 //   environment {
  //      DISABLE_AUTH = 'true'
  //      DB_ENGINE = 'sqlite'
  //  }


        stage('Build') {
            test.GetData(PARAPRJ_PARAVC_PARAPK)
                //sh 'echo $DB_ENGINE'

        }

}