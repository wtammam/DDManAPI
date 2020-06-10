pipeline {
    agent {
        label "abdul-executor"
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE = 'sqlite'
    }

    stages {
        stage('Build') {
            steps {
                sh 'echo $DB_ENGINE'
            }
        }
        stage('Test') {
            steps {
                sh 'echo $DISABLE_AUTH'
            }
        }
    }
}