mvn clean install
rm -fr target
mkdir -p target
cp ./ServiceProviderA/target/*.jar target
cp ./ServiceProviderB/target/*.jar target
cp ./ServiceConsumer/target/*.jar  target
java  -Djava.ext.dirs=target -jar target/ServiceConsumer-1.0-SNAPSHOT.jar


