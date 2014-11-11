/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef messagingEvents_TYPES_H
#define messagingEvents_TYPES_H

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>
#include "experimentModel_types.h"
#include "applicationInterfaceModel_types.h"


namespace apache { namespace airavata { namespace model { namespace messaging { namespace event {

struct MessageLevel {
  enum type {
    INFO = 0,
    DEBUG = 1,
    ERROR = 2,
    ACK = 3
  };
};

extern const std::map<int, const char*> _MessageLevel_VALUES_TO_NAMES;

struct MessageType {
  enum type {
    EXPERIMENT = 0,
    TASK = 1,
    WORKFLOWNODE = 2,
    JOB = 3
  };
};

extern const std::map<int, const char*> _MessageType_VALUES_TO_NAMES;


class ExperimentStatusChangeEvent {
 public:

  static const char* ascii_fingerprint; // = "38C252E94E93B69D04EB3A6EE2F9EDFB";
  static const uint8_t binary_fingerprint[16]; // = {0x38,0xC2,0x52,0xE9,0x4E,0x93,0xB6,0x9D,0x04,0xEB,0x3A,0x6E,0xE2,0xF9,0xED,0xFB};

  ExperimentStatusChangeEvent() : state(( ::apache::airavata::model::workspace::experiment::ExperimentState::type)0), experimentId(), gatewayId() {
  }

  virtual ~ExperimentStatusChangeEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::ExperimentState::type state;
  std::string experimentId;
  std::string gatewayId;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::ExperimentState::type val) {
    state = val;
  }

  void __set_experimentId(const std::string& val) {
    experimentId = val;
  }

  void __set_gatewayId(const std::string& val) {
    gatewayId = val;
  }

  bool operator == (const ExperimentStatusChangeEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(experimentId == rhs.experimentId))
      return false;
    if (!(gatewayId == rhs.gatewayId))
      return false;
    return true;
  }
  bool operator != (const ExperimentStatusChangeEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ExperimentStatusChangeEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(ExperimentStatusChangeEvent &a, ExperimentStatusChangeEvent &b);


class WorkflowIdentifier {
 public:

  static const char* ascii_fingerprint; // = "AB879940BD15B6B25691265F7384B271";
  static const uint8_t binary_fingerprint[16]; // = {0xAB,0x87,0x99,0x40,0xBD,0x15,0xB6,0xB2,0x56,0x91,0x26,0x5F,0x73,0x84,0xB2,0x71};

  WorkflowIdentifier() : workflowNodeId(), experimentId(), gatewayId() {
  }

  virtual ~WorkflowIdentifier() throw() {}

  std::string workflowNodeId;
  std::string experimentId;
  std::string gatewayId;

  void __set_workflowNodeId(const std::string& val) {
    workflowNodeId = val;
  }

  void __set_experimentId(const std::string& val) {
    experimentId = val;
  }

  void __set_gatewayId(const std::string& val) {
    gatewayId = val;
  }

  bool operator == (const WorkflowIdentifier & rhs) const
  {
    if (!(workflowNodeId == rhs.workflowNodeId))
      return false;
    if (!(experimentId == rhs.experimentId))
      return false;
    if (!(gatewayId == rhs.gatewayId))
      return false;
    return true;
  }
  bool operator != (const WorkflowIdentifier &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const WorkflowIdentifier & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(WorkflowIdentifier &a, WorkflowIdentifier &b);


class WorkflowNodeStatusChangeEvent {
 public:

  static const char* ascii_fingerprint; // = "9686679C94D43D75F2B35A0BED2E4003";
  static const uint8_t binary_fingerprint[16]; // = {0x96,0x86,0x67,0x9C,0x94,0xD4,0x3D,0x75,0xF2,0xB3,0x5A,0x0B,0xED,0x2E,0x40,0x03};

  WorkflowNodeStatusChangeEvent() : state(( ::apache::airavata::model::workspace::experiment::WorkflowNodeState::type)0) {
  }

  virtual ~WorkflowNodeStatusChangeEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::WorkflowNodeState::type state;
  WorkflowIdentifier workflowNodeIdentity;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::WorkflowNodeState::type val) {
    state = val;
  }

  void __set_workflowNodeIdentity(const WorkflowIdentifier& val) {
    workflowNodeIdentity = val;
  }

  bool operator == (const WorkflowNodeStatusChangeEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(workflowNodeIdentity == rhs.workflowNodeIdentity))
      return false;
    return true;
  }
  bool operator != (const WorkflowNodeStatusChangeEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const WorkflowNodeStatusChangeEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(WorkflowNodeStatusChangeEvent &a, WorkflowNodeStatusChangeEvent &b);


class TaskIdentifier {
 public:

  static const char* ascii_fingerprint; // = "C93D890311F28844166CF6E571EB3AC2";
  static const uint8_t binary_fingerprint[16]; // = {0xC9,0x3D,0x89,0x03,0x11,0xF2,0x88,0x44,0x16,0x6C,0xF6,0xE5,0x71,0xEB,0x3A,0xC2};

  TaskIdentifier() : taskId(), workflowNodeId(), experimentId(), gatewayId() {
  }

  virtual ~TaskIdentifier() throw() {}

  std::string taskId;
  std::string workflowNodeId;
  std::string experimentId;
  std::string gatewayId;

  void __set_taskId(const std::string& val) {
    taskId = val;
  }

  void __set_workflowNodeId(const std::string& val) {
    workflowNodeId = val;
  }

  void __set_experimentId(const std::string& val) {
    experimentId = val;
  }

  void __set_gatewayId(const std::string& val) {
    gatewayId = val;
  }

  bool operator == (const TaskIdentifier & rhs) const
  {
    if (!(taskId == rhs.taskId))
      return false;
    if (!(workflowNodeId == rhs.workflowNodeId))
      return false;
    if (!(experimentId == rhs.experimentId))
      return false;
    if (!(gatewayId == rhs.gatewayId))
      return false;
    return true;
  }
  bool operator != (const TaskIdentifier &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const TaskIdentifier & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(TaskIdentifier &a, TaskIdentifier &b);


class TaskStatusChangeEvent {
 public:

  static const char* ascii_fingerprint; // = "8D18A3CD1822DBC67D7BD8CB98E7B4F1";
  static const uint8_t binary_fingerprint[16]; // = {0x8D,0x18,0xA3,0xCD,0x18,0x22,0xDB,0xC6,0x7D,0x7B,0xD8,0xCB,0x98,0xE7,0xB4,0xF1};

  TaskStatusChangeEvent() : state(( ::apache::airavata::model::workspace::experiment::TaskState::type)0) {
  }

  virtual ~TaskStatusChangeEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::TaskState::type state;
  TaskIdentifier taskIdentity;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::TaskState::type val) {
    state = val;
  }

  void __set_taskIdentity(const TaskIdentifier& val) {
    taskIdentity = val;
  }

  bool operator == (const TaskStatusChangeEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(taskIdentity == rhs.taskIdentity))
      return false;
    return true;
  }
  bool operator != (const TaskStatusChangeEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const TaskStatusChangeEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(TaskStatusChangeEvent &a, TaskStatusChangeEvent &b);


class TaskStatusChangeRequestEvent {
 public:

  static const char* ascii_fingerprint; // = "8D18A3CD1822DBC67D7BD8CB98E7B4F1";
  static const uint8_t binary_fingerprint[16]; // = {0x8D,0x18,0xA3,0xCD,0x18,0x22,0xDB,0xC6,0x7D,0x7B,0xD8,0xCB,0x98,0xE7,0xB4,0xF1};

  TaskStatusChangeRequestEvent() : state(( ::apache::airavata::model::workspace::experiment::TaskState::type)0) {
  }

  virtual ~TaskStatusChangeRequestEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::TaskState::type state;
  TaskIdentifier taskIdentity;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::TaskState::type val) {
    state = val;
  }

  void __set_taskIdentity(const TaskIdentifier& val) {
    taskIdentity = val;
  }

  bool operator == (const TaskStatusChangeRequestEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(taskIdentity == rhs.taskIdentity))
      return false;
    return true;
  }
  bool operator != (const TaskStatusChangeRequestEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const TaskStatusChangeRequestEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(TaskStatusChangeRequestEvent &a, TaskStatusChangeRequestEvent &b);


class TaskOutputChangeEvent {
 public:

  static const char* ascii_fingerprint; // = "850570A8E8883AE24DE92AFC9AA86C7E";
  static const uint8_t binary_fingerprint[16]; // = {0x85,0x05,0x70,0xA8,0xE8,0x88,0x3A,0xE2,0x4D,0xE9,0x2A,0xFC,0x9A,0xA8,0x6C,0x7E};

  TaskOutputChangeEvent() {
  }

  virtual ~TaskOutputChangeEvent() throw() {}

  std::vector< ::apache::airavata::model::appcatalog::appinterface::OutputDataObjectType>  output;
  TaskIdentifier taskIdentity;

  void __set_output(const std::vector< ::apache::airavata::model::appcatalog::appinterface::OutputDataObjectType> & val) {
    output = val;
  }

  void __set_taskIdentity(const TaskIdentifier& val) {
    taskIdentity = val;
  }

  bool operator == (const TaskOutputChangeEvent & rhs) const
  {
    if (!(output == rhs.output))
      return false;
    if (!(taskIdentity == rhs.taskIdentity))
      return false;
    return true;
  }
  bool operator != (const TaskOutputChangeEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const TaskOutputChangeEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(TaskOutputChangeEvent &a, TaskOutputChangeEvent &b);


class JobIdentifier {
 public:

  static const char* ascii_fingerprint; // = "BFF0E21728CB005F9AA5774A41542B8D";
  static const uint8_t binary_fingerprint[16]; // = {0xBF,0xF0,0xE2,0x17,0x28,0xCB,0x00,0x5F,0x9A,0xA5,0x77,0x4A,0x41,0x54,0x2B,0x8D};

  JobIdentifier() : jobId(), taskId(), workflowNodeId(), experimentId(), gatewayId() {
  }

  virtual ~JobIdentifier() throw() {}

  std::string jobId;
  std::string taskId;
  std::string workflowNodeId;
  std::string experimentId;
  std::string gatewayId;

  void __set_jobId(const std::string& val) {
    jobId = val;
  }

  void __set_taskId(const std::string& val) {
    taskId = val;
  }

  void __set_workflowNodeId(const std::string& val) {
    workflowNodeId = val;
  }

  void __set_experimentId(const std::string& val) {
    experimentId = val;
  }

  void __set_gatewayId(const std::string& val) {
    gatewayId = val;
  }

  bool operator == (const JobIdentifier & rhs) const
  {
    if (!(jobId == rhs.jobId))
      return false;
    if (!(taskId == rhs.taskId))
      return false;
    if (!(workflowNodeId == rhs.workflowNodeId))
      return false;
    if (!(experimentId == rhs.experimentId))
      return false;
    if (!(gatewayId == rhs.gatewayId))
      return false;
    return true;
  }
  bool operator != (const JobIdentifier &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const JobIdentifier & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(JobIdentifier &a, JobIdentifier &b);


class JobStatusChangeEvent {
 public:

  static const char* ascii_fingerprint; // = "062775D589B60D1687103FD465B0F5E8";
  static const uint8_t binary_fingerprint[16]; // = {0x06,0x27,0x75,0xD5,0x89,0xB6,0x0D,0x16,0x87,0x10,0x3F,0xD4,0x65,0xB0,0xF5,0xE8};

  JobStatusChangeEvent() : state(( ::apache::airavata::model::workspace::experiment::JobState::type)0) {
  }

  virtual ~JobStatusChangeEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::JobState::type state;
  JobIdentifier jobIdentity;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::JobState::type val) {
    state = val;
  }

  void __set_jobIdentity(const JobIdentifier& val) {
    jobIdentity = val;
  }

  bool operator == (const JobStatusChangeEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(jobIdentity == rhs.jobIdentity))
      return false;
    return true;
  }
  bool operator != (const JobStatusChangeEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const JobStatusChangeEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(JobStatusChangeEvent &a, JobStatusChangeEvent &b);


class JobStatusChangeRequestEvent {
 public:

  static const char* ascii_fingerprint; // = "062775D589B60D1687103FD465B0F5E8";
  static const uint8_t binary_fingerprint[16]; // = {0x06,0x27,0x75,0xD5,0x89,0xB6,0x0D,0x16,0x87,0x10,0x3F,0xD4,0x65,0xB0,0xF5,0xE8};

  JobStatusChangeRequestEvent() : state(( ::apache::airavata::model::workspace::experiment::JobState::type)0) {
  }

  virtual ~JobStatusChangeRequestEvent() throw() {}

   ::apache::airavata::model::workspace::experiment::JobState::type state;
  JobIdentifier jobIdentity;

  void __set_state(const  ::apache::airavata::model::workspace::experiment::JobState::type val) {
    state = val;
  }

  void __set_jobIdentity(const JobIdentifier& val) {
    jobIdentity = val;
  }

  bool operator == (const JobStatusChangeRequestEvent & rhs) const
  {
    if (!(state == rhs.state))
      return false;
    if (!(jobIdentity == rhs.jobIdentity))
      return false;
    return true;
  }
  bool operator != (const JobStatusChangeRequestEvent &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const JobStatusChangeRequestEvent & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(JobStatusChangeRequestEvent &a, JobStatusChangeRequestEvent &b);

typedef struct _Message__isset {
  _Message__isset() : updatedTime(false), messageLevel(false) {}
  bool updatedTime;
  bool messageLevel;
} _Message__isset;

class Message {
 public:

  static const char* ascii_fingerprint; // = "6904C391426E568AF9DEAF69860C076A";
  static const uint8_t binary_fingerprint[16]; // = {0x69,0x04,0xC3,0x91,0x42,0x6E,0x56,0x8A,0xF9,0xDE,0xAF,0x69,0x86,0x0C,0x07,0x6A};

  Message() : event(), messageId("DO_NOT_SET_AT_CLIENTS"), messageType((MessageType::type)0), updatedTime(0), messageLevel((MessageLevel::type)0) {
  }

  virtual ~Message() throw() {}

  std::string event;
  std::string messageId;
  MessageType::type messageType;
  int64_t updatedTime;
  MessageLevel::type messageLevel;

  _Message__isset __isset;

  void __set_event(const std::string& val) {
    event = val;
  }

  void __set_messageId(const std::string& val) {
    messageId = val;
  }

  void __set_messageType(const MessageType::type val) {
    messageType = val;
  }

  void __set_updatedTime(const int64_t val) {
    updatedTime = val;
    __isset.updatedTime = true;
  }

  void __set_messageLevel(const MessageLevel::type val) {
    messageLevel = val;
    __isset.messageLevel = true;
  }

  bool operator == (const Message & rhs) const
  {
    if (!(event == rhs.event))
      return false;
    if (!(messageId == rhs.messageId))
      return false;
    if (!(messageType == rhs.messageType))
      return false;
    if (__isset.updatedTime != rhs.__isset.updatedTime)
      return false;
    else if (__isset.updatedTime && !(updatedTime == rhs.updatedTime))
      return false;
    if (__isset.messageLevel != rhs.__isset.messageLevel)
      return false;
    else if (__isset.messageLevel && !(messageLevel == rhs.messageLevel))
      return false;
    return true;
  }
  bool operator != (const Message &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Message & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(Message &a, Message &b);

}}}}} // namespace

#endif
