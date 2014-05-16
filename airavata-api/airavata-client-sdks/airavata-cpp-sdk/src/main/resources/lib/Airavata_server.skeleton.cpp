// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "Airavata.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using boost::shared_ptr;

using namespace  ::airavata::api;

class AiravataHandler : virtual public AiravataIf {
 public:
  AiravataHandler() {
    // Your initialization goes here
  }

  void GetAPIVersion(std::string& _return) {
    // Your implementation goes here
    printf("GetAPIVersion\n");
  }

  void createProject(std::string& _return, const  ::Project& project) {
    // Your implementation goes here
    printf("createProject\n");
  }

  void updateProject(const  ::Project& project) {
    // Your implementation goes here
    printf("updateProject\n");
  }

  void getProject( ::Project& _return, const std::string& projectId) {
    // Your implementation goes here
    printf("getProject\n");
  }

  void getAllUserProjects(std::vector< ::Project> & _return, const std::string& userName) {
    // Your implementation goes here
    printf("getAllUserProjects\n");
  }

  void getAllExperimentsInProject(std::vector< ::Experiment> & _return, const std::string& projectId) {
    // Your implementation goes here
    printf("getAllExperimentsInProject\n");
  }

  void getAllUserExperiments(std::vector< ::Experiment> & _return, const std::string& userName) {
    // Your implementation goes here
    printf("getAllUserExperiments\n");
  }

  void createExperiment(std::string& _return, const  ::Experiment& experiment) {
    // Your implementation goes here
    printf("createExperiment\n");
  }

  void getExperiment( ::Experiment& _return, const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("getExperiment\n");
  }

  void updateExperiment(const std::string& airavataExperimentId, const  ::Experiment& experiment) {
    // Your implementation goes here
    printf("updateExperiment\n");
  }

  void updateExperimentConfiguration(const std::string& airavataExperimentId, const  ::UserConfigurationData& userConfiguration) {
    // Your implementation goes here
    printf("updateExperimentConfiguration\n");
  }

  void updateResourceScheduleing(const std::string& airavataExperimentId, const  ::ComputationalResourceScheduling& resourceScheduling) {
    // Your implementation goes here
    printf("updateResourceScheduleing\n");
  }

  bool validateExperiment(const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("validateExperiment\n");
  }

  void launchExperiment( ::ValidationResults& _return, const std::string& airavataExperimentId, const std::string& airavataCredStoreToken) {
    // Your implementation goes here
    printf("launchExperiment\n");
  }

  void getExperimentStatus( ::ExperimentStatus& _return, const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("getExperimentStatus\n");
  }

  void getExperimentOutputs(std::vector< ::DataObjectType> & _return, const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("getExperimentOutputs\n");
  }

  void getJobStatuses(std::map<std::string,  ::JobStatus> & _return, const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("getJobStatuses\n");
  }

  void cloneExperiment(std::string& _return, const std::string& existingExperimentID, const std::string& newExperiementName) {
    // Your implementation goes here
    printf("cloneExperiment\n");
  }

  void terminateExperiment(const std::string& airavataExperimentId) {
    // Your implementation goes here
    printf("terminateExperiment\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  shared_ptr<AiravataHandler> handler(new AiravataHandler());
  shared_ptr<TProcessor> processor(new AiravataProcessor(handler));
  shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}

