pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Bu adimda GitHub'daki kodlari Jenkins'e cekeriz
                checkout scm
            }
        }
        
        stage('Build with Maven') {
            steps {
                // Proje kodlarini derler ve target klasorunde jar olusturur
                // Not: Eger Jenkins'iniz Unix/Linux uzerindeyse 'bat' yerine 'sh' yazin.
                bat 'mvn clean package -DskipTests'
            }
        }
        
        stage('Docker Build & Deploy') {
            steps {
                script {
                    // Mevcut çalışan bir container varsa durdur ve sil (Hata verirse yoksay)
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'docker stop spring-ci-cd-demo'
                        bat 'docker rm spring-ci-cd-demo'
                    }
                    
                    // Docker imajini olustur
                    bat 'docker build -t spring-ci-cd-image .'
                    
                    // Docker uzerinde yeni projeyi calistir
                    bat 'docker run -d -p 8080:8080 --name spring-ci-cd-demo spring-ci-cd-image'
                }
            }
        }
    }
}
