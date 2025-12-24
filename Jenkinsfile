pipeline {
    agent any
    stages {
        stage('拉取代码') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/zdw1214/my-devops-demo.git'
            }
        }
        stage('构建前端') {
            steps {
                dir('frontend') {
                    sh 'npm run build'
                    sh 'cat build.log'
                }
            }
        }
        stage('构建后端') {
            steps {
                tool name: 'JDK-11', type: 'jdk'
                tool name: 'Maven-3.9.6',type: 'maven'
                dir('backend') {
                    sh 'mvn clean package -DskipTests'
                    sh 'ls -lh target/*.jar'
                }
            }
        }
        stage('Docker部署') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose build --no-cache'
                sh 'docker-compose up -d'
                sh 'sleep 10 && curl -s http://localhost:8080/info || true'
            }
        }
    }
    post {
        success {
            echo '✅ DevOps自动化构建部署成功！'
            echo '项目访问地址: http://服务器IP:8080/info'
            echo '预期输出: 2340231214-张得伟'
        }
        failure {
            echo '❌ 构建失败，请检查日志。'
        }
    }
}
