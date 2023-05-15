pipeline {
    agent any
    environment {
          JIRA_XRAY_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI2M2VmM2E0MDQwZDBmZTcwOTA3NTdhNzIiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY4NDE2OTgyNSwiZXhwIjoxNjg0MjU2MjI1LCJhdWQiOiIyMUI3NTNDNzc1MkE0RjQwQTg5N0FEOTU4QTY2NjQ3MyIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IjIxQjc1M0M3NzUyQTRGNDBBODk3QUQ5NThBNjY2NDczIn0.KHIoDMeW7y3LZb2NUIIM_uB9LQ0-rDVDmkcw1hkIap8"
    }

     stages {
//         stage('exporting BDD tests cases from Jira/Xray') {
//             steps {
//                 sh "curl -H 'Content-Type: application/json' -X GET -H 'Authorization: Bearer ${JIRA_XRAY_TOKEN}' 'https://xray.cloud.getxray.app/api/v1/export/cucumber?keys=POEI23P2G1-21;POEI23P2G1-22;POEI23P2G1-23;POEI23P2G1-24;POEI23P2G1-27;POEI23P2G1-19;POEI23P2G1-48;POEI23P2G1-33;POEI23P2G1-18;POEI23P2G1-20;POEI23P2G1-17&fz=true' --output features.zip"
//                 sh "unzip -o features.zip -d src/test/resources/features"
// //                 unzip  dir: 'src/test/rersources/features', glob: ' ', zipFile: 'features.zip'
//                 sh "rm features.zip"
//             }
//         }
        stage('Launch Tests') {
            steps {
                 sh "mvn clean test -Dtest=RunCucumberTest"
            }
        }

        stage('Importing tests execution to Jira/Xray') {
            steps {
                sh "curl -H 'Content-Type: application/json' -X POST -H 'Authorization: Bearer ${JIRA_XRAY_TOKEN}'  --data @'target/cucumber.json' https://xray.cloud.getxray.app/api/v1/import/execution/cucumber"
            }
        }
    }

//       post {
//         always {
//           step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
//         }
//       }
}