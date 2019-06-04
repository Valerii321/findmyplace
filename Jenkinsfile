pipeline {
  agent {
    docker {
      image 'maven:3.6-jdk-11'
      args '--network=jenkins_local'
//      -v /var/run/docker.sock:/var/run/docker.sock
    }
  }
  stages {
    stage('get git') {
      steps {
        git(url: 'https://github.com/Valerii321/findmyplace', branch: 'demo6')        
      }
    }
    stage('build') {
      steps {
        sh 'ls'
        sh 'cd api/ && mvn install -Dmaven.test.skip=true'
        sh 'cd api/ && mvn clean package -DskipTests=true'
          }
        }
    }
  post {
    failure {
    //  slackSend(color: '#FF0000', message: ":angry: Failed Bimeister: '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
      slackSend(color: '#FF0000', message: ":angry: Failed Bimeister: '${env.GIT_BRANCH} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
    }
    success {
      slackSend(color: '#008000', message: ":sunglasses: GOOD Result: '${env.GIT_BRANCH} [${env.BUILD_NUMBER}]' (${env.RUN_DISPLAY_URL})")
    }
  }
}