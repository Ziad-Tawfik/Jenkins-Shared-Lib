#!/usr/bin/env groovy

def call(){
  pipeline {
    agent { label 'EC2-Agent-1' }

    stages {
        stage('Install-Nginx') {
            steps {
                sh "sudo yum -y update"
                sh "sudo yum install -y nginx"
            }
        }
        stage('Start-Nginx') {
            steps {
                sh "sudo systemctl enable --now nginx"
            }
        }
        stage('Test-Nginx') {
            steps {
                sh "curl localhost"
            }
        }
    }
  }
}
