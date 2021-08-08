pipeline {
    agent any
    tools {
        maven 'maven_3_8_1'
    }

    stages {
        stage ('Compile Stage') {

            steps {
                bat "mvn clean compile"
            }
        }

        stage ('Testing Stage') {

            steps {
                bat "mvn gauge:execute -DspecsDir=src/test/java/mobile/specs/GetirSample.spec"

            }
        }


        stage ('Deployment Stage') {
            steps {
                bat "mvn deploy"

            }
        }
    }
}
