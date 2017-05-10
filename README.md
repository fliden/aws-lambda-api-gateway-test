# g11n-aws-gateway-lambda
###Build
POC for phone number utility methods using api gateway and lambda

`./gradlew clean`

`./gradle build`

###Lambda

create and deploy distributions/g11n-aws-gateway-lambda to aws

###API Gateway
manually create and deploy api

/g11n/{proxy+}

###Serverless (https://serverless.com)

Install and configure serverless then run 
serverless deploy

Our aws does not have CloudFormation enabled so we can't use serverless

###Endpoints
####Format
https://{base}/g11n/v1/format-phonenumber/+11234567890?format=NATIONAL

format = INTERNATIONAL, NATIONAL, or E164

{
"result": "(720) 587-9681"
}

####Validate
https://{base}/g11n/v1/validate-phonenumber/+11234567890

{
  "result": "valid"
}