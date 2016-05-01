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
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "gateway_resource_profile_model_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace apache { namespace airavata { namespace model { namespace appcatalog { namespace gatewayprofile {


ComputeResourcePreference::~ComputeResourcePreference() throw() {
}


void ComputeResourcePreference::__set_computeResourceId(const std::string& val) {
  this->computeResourceId = val;
}

void ComputeResourcePreference::__set_overridebyAiravata(const bool val) {
  this->overridebyAiravata = val;
}

void ComputeResourcePreference::__set_loginUserName(const std::string& val) {
  this->loginUserName = val;
__isset.loginUserName = true;
}

void ComputeResourcePreference::__set_preferredJobSubmissionProtocol(const  ::apache::airavata::model::appcatalog::computeresource::JobSubmissionProtocol::type val) {
  this->preferredJobSubmissionProtocol = val;
__isset.preferredJobSubmissionProtocol = true;
}

void ComputeResourcePreference::__set_preferredDataMovementProtocol(const  ::apache::airavata::model::data::movement::DataMovementProtocol::type val) {
  this->preferredDataMovementProtocol = val;
__isset.preferredDataMovementProtocol = true;
}

void ComputeResourcePreference::__set_preferredBatchQueue(const std::string& val) {
  this->preferredBatchQueue = val;
__isset.preferredBatchQueue = true;
}

void ComputeResourcePreference::__set_scratchLocation(const std::string& val) {
  this->scratchLocation = val;
__isset.scratchLocation = true;
}

void ComputeResourcePreference::__set_allocationProjectNumber(const std::string& val) {
  this->allocationProjectNumber = val;
__isset.allocationProjectNumber = true;
}

void ComputeResourcePreference::__set_resourceSpecificCredentialStoreToken(const std::string& val) {
  this->resourceSpecificCredentialStoreToken = val;
__isset.resourceSpecificCredentialStoreToken = true;
}

void ComputeResourcePreference::__set_usageReportingGatewayId(const std::string& val) {
  this->usageReportingGatewayId = val;
__isset.usageReportingGatewayId = true;
}

uint32_t ComputeResourcePreference::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_computeResourceId = false;
  bool isset_overridebyAiravata = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->computeResourceId);
          isset_computeResourceId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_BOOL) {
          xfer += iprot->readBool(this->overridebyAiravata);
          isset_overridebyAiravata = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->loginUserName);
          this->__isset.loginUserName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          int32_t ecast0;
          xfer += iprot->readI32(ecast0);
          this->preferredJobSubmissionProtocol = ( ::apache::airavata::model::appcatalog::computeresource::JobSubmissionProtocol::type)ecast0;
          this->__isset.preferredJobSubmissionProtocol = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          int32_t ecast1;
          xfer += iprot->readI32(ecast1);
          this->preferredDataMovementProtocol = ( ::apache::airavata::model::data::movement::DataMovementProtocol::type)ecast1;
          this->__isset.preferredDataMovementProtocol = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->preferredBatchQueue);
          this->__isset.preferredBatchQueue = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->scratchLocation);
          this->__isset.scratchLocation = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->allocationProjectNumber);
          this->__isset.allocationProjectNumber = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 9:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->resourceSpecificCredentialStoreToken);
          this->__isset.resourceSpecificCredentialStoreToken = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 10:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->usageReportingGatewayId);
          this->__isset.usageReportingGatewayId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_computeResourceId)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  if (!isset_overridebyAiravata)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t ComputeResourcePreference::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("ComputeResourcePreference");

  xfer += oprot->writeFieldBegin("computeResourceId", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->computeResourceId);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("overridebyAiravata", ::apache::thrift::protocol::T_BOOL, 2);
  xfer += oprot->writeBool(this->overridebyAiravata);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.loginUserName) {
    xfer += oprot->writeFieldBegin("loginUserName", ::apache::thrift::protocol::T_STRING, 3);
    xfer += oprot->writeString(this->loginUserName);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.preferredJobSubmissionProtocol) {
    xfer += oprot->writeFieldBegin("preferredJobSubmissionProtocol", ::apache::thrift::protocol::T_I32, 4);
    xfer += oprot->writeI32((int32_t)this->preferredJobSubmissionProtocol);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.preferredDataMovementProtocol) {
    xfer += oprot->writeFieldBegin("preferredDataMovementProtocol", ::apache::thrift::protocol::T_I32, 5);
    xfer += oprot->writeI32((int32_t)this->preferredDataMovementProtocol);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.preferredBatchQueue) {
    xfer += oprot->writeFieldBegin("preferredBatchQueue", ::apache::thrift::protocol::T_STRING, 6);
    xfer += oprot->writeString(this->preferredBatchQueue);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.scratchLocation) {
    xfer += oprot->writeFieldBegin("scratchLocation", ::apache::thrift::protocol::T_STRING, 7);
    xfer += oprot->writeString(this->scratchLocation);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.allocationProjectNumber) {
    xfer += oprot->writeFieldBegin("allocationProjectNumber", ::apache::thrift::protocol::T_STRING, 8);
    xfer += oprot->writeString(this->allocationProjectNumber);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.resourceSpecificCredentialStoreToken) {
    xfer += oprot->writeFieldBegin("resourceSpecificCredentialStoreToken", ::apache::thrift::protocol::T_STRING, 9);
    xfer += oprot->writeString(this->resourceSpecificCredentialStoreToken);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.usageReportingGatewayId) {
    xfer += oprot->writeFieldBegin("usageReportingGatewayId", ::apache::thrift::protocol::T_STRING, 10);
    xfer += oprot->writeString(this->usageReportingGatewayId);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ComputeResourcePreference &a, ComputeResourcePreference &b) {
  using ::std::swap;
  swap(a.computeResourceId, b.computeResourceId);
  swap(a.overridebyAiravata, b.overridebyAiravata);
  swap(a.loginUserName, b.loginUserName);
  swap(a.preferredJobSubmissionProtocol, b.preferredJobSubmissionProtocol);
  swap(a.preferredDataMovementProtocol, b.preferredDataMovementProtocol);
  swap(a.preferredBatchQueue, b.preferredBatchQueue);
  swap(a.scratchLocation, b.scratchLocation);
  swap(a.allocationProjectNumber, b.allocationProjectNumber);
  swap(a.resourceSpecificCredentialStoreToken, b.resourceSpecificCredentialStoreToken);
  swap(a.usageReportingGatewayId, b.usageReportingGatewayId);
  swap(a.__isset, b.__isset);
}

ComputeResourcePreference::ComputeResourcePreference(const ComputeResourcePreference& other2) {
  computeResourceId = other2.computeResourceId;
  overridebyAiravata = other2.overridebyAiravata;
  loginUserName = other2.loginUserName;
  preferredJobSubmissionProtocol = other2.preferredJobSubmissionProtocol;
  preferredDataMovementProtocol = other2.preferredDataMovementProtocol;
  preferredBatchQueue = other2.preferredBatchQueue;
  scratchLocation = other2.scratchLocation;
  allocationProjectNumber = other2.allocationProjectNumber;
  resourceSpecificCredentialStoreToken = other2.resourceSpecificCredentialStoreToken;
  usageReportingGatewayId = other2.usageReportingGatewayId;
  __isset = other2.__isset;
}
ComputeResourcePreference& ComputeResourcePreference::operator=(const ComputeResourcePreference& other3) {
  computeResourceId = other3.computeResourceId;
  overridebyAiravata = other3.overridebyAiravata;
  loginUserName = other3.loginUserName;
  preferredJobSubmissionProtocol = other3.preferredJobSubmissionProtocol;
  preferredDataMovementProtocol = other3.preferredDataMovementProtocol;
  preferredBatchQueue = other3.preferredBatchQueue;
  scratchLocation = other3.scratchLocation;
  allocationProjectNumber = other3.allocationProjectNumber;
  resourceSpecificCredentialStoreToken = other3.resourceSpecificCredentialStoreToken;
  usageReportingGatewayId = other3.usageReportingGatewayId;
  __isset = other3.__isset;
  return *this;
}
void ComputeResourcePreference::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "ComputeResourcePreference(";
  out << "computeResourceId=" << to_string(computeResourceId);
  out << ", " << "overridebyAiravata=" << to_string(overridebyAiravata);
  out << ", " << "loginUserName="; (__isset.loginUserName ? (out << to_string(loginUserName)) : (out << "<null>"));
  out << ", " << "preferredJobSubmissionProtocol="; (__isset.preferredJobSubmissionProtocol ? (out << to_string(preferredJobSubmissionProtocol)) : (out << "<null>"));
  out << ", " << "preferredDataMovementProtocol="; (__isset.preferredDataMovementProtocol ? (out << to_string(preferredDataMovementProtocol)) : (out << "<null>"));
  out << ", " << "preferredBatchQueue="; (__isset.preferredBatchQueue ? (out << to_string(preferredBatchQueue)) : (out << "<null>"));
  out << ", " << "scratchLocation="; (__isset.scratchLocation ? (out << to_string(scratchLocation)) : (out << "<null>"));
  out << ", " << "allocationProjectNumber="; (__isset.allocationProjectNumber ? (out << to_string(allocationProjectNumber)) : (out << "<null>"));
  out << ", " << "resourceSpecificCredentialStoreToken="; (__isset.resourceSpecificCredentialStoreToken ? (out << to_string(resourceSpecificCredentialStoreToken)) : (out << "<null>"));
  out << ", " << "usageReportingGatewayId="; (__isset.usageReportingGatewayId ? (out << to_string(usageReportingGatewayId)) : (out << "<null>"));
  out << ")";
}


StoragePreference::~StoragePreference() throw() {
}


void StoragePreference::__set_storageResourceId(const std::string& val) {
  this->storageResourceId = val;
}

void StoragePreference::__set_loginUserName(const std::string& val) {
  this->loginUserName = val;
__isset.loginUserName = true;
}

void StoragePreference::__set_fileSystemRootLocation(const std::string& val) {
  this->fileSystemRootLocation = val;
__isset.fileSystemRootLocation = true;
}

void StoragePreference::__set_resourceSpecificCredentialStoreToken(const std::string& val) {
  this->resourceSpecificCredentialStoreToken = val;
__isset.resourceSpecificCredentialStoreToken = true;
}

uint32_t StoragePreference::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_storageResourceId = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->storageResourceId);
          isset_storageResourceId = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->loginUserName);
          this->__isset.loginUserName = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->fileSystemRootLocation);
          this->__isset.fileSystemRootLocation = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->resourceSpecificCredentialStoreToken);
          this->__isset.resourceSpecificCredentialStoreToken = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_storageResourceId)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t StoragePreference::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("StoragePreference");

  xfer += oprot->writeFieldBegin("storageResourceId", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->storageResourceId);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.loginUserName) {
    xfer += oprot->writeFieldBegin("loginUserName", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->loginUserName);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.fileSystemRootLocation) {
    xfer += oprot->writeFieldBegin("fileSystemRootLocation", ::apache::thrift::protocol::T_STRING, 3);
    xfer += oprot->writeString(this->fileSystemRootLocation);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.resourceSpecificCredentialStoreToken) {
    xfer += oprot->writeFieldBegin("resourceSpecificCredentialStoreToken", ::apache::thrift::protocol::T_STRING, 4);
    xfer += oprot->writeString(this->resourceSpecificCredentialStoreToken);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(StoragePreference &a, StoragePreference &b) {
  using ::std::swap;
  swap(a.storageResourceId, b.storageResourceId);
  swap(a.loginUserName, b.loginUserName);
  swap(a.fileSystemRootLocation, b.fileSystemRootLocation);
  swap(a.resourceSpecificCredentialStoreToken, b.resourceSpecificCredentialStoreToken);
  swap(a.__isset, b.__isset);
}

StoragePreference::StoragePreference(const StoragePreference& other4) {
  storageResourceId = other4.storageResourceId;
  loginUserName = other4.loginUserName;
  fileSystemRootLocation = other4.fileSystemRootLocation;
  resourceSpecificCredentialStoreToken = other4.resourceSpecificCredentialStoreToken;
  __isset = other4.__isset;
}
StoragePreference& StoragePreference::operator=(const StoragePreference& other5) {
  storageResourceId = other5.storageResourceId;
  loginUserName = other5.loginUserName;
  fileSystemRootLocation = other5.fileSystemRootLocation;
  resourceSpecificCredentialStoreToken = other5.resourceSpecificCredentialStoreToken;
  __isset = other5.__isset;
  return *this;
}
void StoragePreference::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "StoragePreference(";
  out << "storageResourceId=" << to_string(storageResourceId);
  out << ", " << "loginUserName="; (__isset.loginUserName ? (out << to_string(loginUserName)) : (out << "<null>"));
  out << ", " << "fileSystemRootLocation="; (__isset.fileSystemRootLocation ? (out << to_string(fileSystemRootLocation)) : (out << "<null>"));
  out << ", " << "resourceSpecificCredentialStoreToken="; (__isset.resourceSpecificCredentialStoreToken ? (out << to_string(resourceSpecificCredentialStoreToken)) : (out << "<null>"));
  out << ")";
}


GatewayResourceProfile::~GatewayResourceProfile() throw() {
}


void GatewayResourceProfile::__set_gatewayID(const std::string& val) {
  this->gatewayID = val;
}

void GatewayResourceProfile::__set_credentialStoreToken(const std::string& val) {
  this->credentialStoreToken = val;
__isset.credentialStoreToken = true;
}

void GatewayResourceProfile::__set_computeResourcePreferences(const std::vector<ComputeResourcePreference> & val) {
  this->computeResourcePreferences = val;
__isset.computeResourcePreferences = true;
}

void GatewayResourceProfile::__set_storagePreferences(const std::vector<StoragePreference> & val) {
  this->storagePreferences = val;
__isset.storagePreferences = true;
}

void GatewayResourceProfile::__set_identityServerTenant(const std::string& val) {
  this->identityServerTenant = val;
__isset.identityServerTenant = true;
}

void GatewayResourceProfile::__set_identityServerPwdCredToken(const std::string& val) {
  this->identityServerPwdCredToken = val;
__isset.identityServerPwdCredToken = true;
}

uint32_t GatewayResourceProfile::read(::apache::thrift::protocol::TProtocol* iprot) {

  apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;

  bool isset_gatewayID = false;

  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->gatewayID);
          isset_gatewayID = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->credentialStoreToken);
          this->__isset.credentialStoreToken = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->computeResourcePreferences.clear();
            uint32_t _size6;
            ::apache::thrift::protocol::TType _etype9;
            xfer += iprot->readListBegin(_etype9, _size6);
            this->computeResourcePreferences.resize(_size6);
            uint32_t _i10;
            for (_i10 = 0; _i10 < _size6; ++_i10)
            {
              xfer += this->computeResourcePreferences[_i10].read(iprot);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.computeResourcePreferences = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_LIST) {
          {
            this->storagePreferences.clear();
            uint32_t _size11;
            ::apache::thrift::protocol::TType _etype14;
            xfer += iprot->readListBegin(_etype14, _size11);
            this->storagePreferences.resize(_size11);
            uint32_t _i15;
            for (_i15 = 0; _i15 < _size11; ++_i15)
            {
              xfer += this->storagePreferences[_i15].read(iprot);
            }
            xfer += iprot->readListEnd();
          }
          this->__isset.storagePreferences = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->identityServerTenant);
          this->__isset.identityServerTenant = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->identityServerPwdCredToken);
          this->__isset.identityServerPwdCredToken = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  if (!isset_gatewayID)
    throw TProtocolException(TProtocolException::INVALID_DATA);
  return xfer;
}

uint32_t GatewayResourceProfile::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("GatewayResourceProfile");

  xfer += oprot->writeFieldBegin("gatewayID", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->gatewayID);
  xfer += oprot->writeFieldEnd();

  if (this->__isset.credentialStoreToken) {
    xfer += oprot->writeFieldBegin("credentialStoreToken", ::apache::thrift::protocol::T_STRING, 2);
    xfer += oprot->writeString(this->credentialStoreToken);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.computeResourcePreferences) {
    xfer += oprot->writeFieldBegin("computeResourcePreferences", ::apache::thrift::protocol::T_LIST, 3);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->computeResourcePreferences.size()));
      std::vector<ComputeResourcePreference> ::const_iterator _iter16;
      for (_iter16 = this->computeResourcePreferences.begin(); _iter16 != this->computeResourcePreferences.end(); ++_iter16)
      {
        xfer += (*_iter16).write(oprot);
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.storagePreferences) {
    xfer += oprot->writeFieldBegin("storagePreferences", ::apache::thrift::protocol::T_LIST, 4);
    {
      xfer += oprot->writeListBegin(::apache::thrift::protocol::T_STRUCT, static_cast<uint32_t>(this->storagePreferences.size()));
      std::vector<StoragePreference> ::const_iterator _iter17;
      for (_iter17 = this->storagePreferences.begin(); _iter17 != this->storagePreferences.end(); ++_iter17)
      {
        xfer += (*_iter17).write(oprot);
      }
      xfer += oprot->writeListEnd();
    }
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.identityServerTenant) {
    xfer += oprot->writeFieldBegin("identityServerTenant", ::apache::thrift::protocol::T_STRING, 5);
    xfer += oprot->writeString(this->identityServerTenant);
    xfer += oprot->writeFieldEnd();
  }
  if (this->__isset.identityServerPwdCredToken) {
    xfer += oprot->writeFieldBegin("identityServerPwdCredToken", ::apache::thrift::protocol::T_STRING, 6);
    xfer += oprot->writeString(this->identityServerPwdCredToken);
    xfer += oprot->writeFieldEnd();
  }
  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(GatewayResourceProfile &a, GatewayResourceProfile &b) {
  using ::std::swap;
  swap(a.gatewayID, b.gatewayID);
  swap(a.credentialStoreToken, b.credentialStoreToken);
  swap(a.computeResourcePreferences, b.computeResourcePreferences);
  swap(a.storagePreferences, b.storagePreferences);
  swap(a.identityServerTenant, b.identityServerTenant);
  swap(a.identityServerPwdCredToken, b.identityServerPwdCredToken);
  swap(a.__isset, b.__isset);
}

GatewayResourceProfile::GatewayResourceProfile(const GatewayResourceProfile& other18) {
  gatewayID = other18.gatewayID;
  credentialStoreToken = other18.credentialStoreToken;
  computeResourcePreferences = other18.computeResourcePreferences;
  storagePreferences = other18.storagePreferences;
  identityServerTenant = other18.identityServerTenant;
  identityServerPwdCredToken = other18.identityServerPwdCredToken;
  __isset = other18.__isset;
}
GatewayResourceProfile& GatewayResourceProfile::operator=(const GatewayResourceProfile& other19) {
  gatewayID = other19.gatewayID;
  credentialStoreToken = other19.credentialStoreToken;
  computeResourcePreferences = other19.computeResourcePreferences;
  storagePreferences = other19.storagePreferences;
  identityServerTenant = other19.identityServerTenant;
  identityServerPwdCredToken = other19.identityServerPwdCredToken;
  __isset = other19.__isset;
  return *this;
}
void GatewayResourceProfile::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "GatewayResourceProfile(";
  out << "gatewayID=" << to_string(gatewayID);
  out << ", " << "credentialStoreToken="; (__isset.credentialStoreToken ? (out << to_string(credentialStoreToken)) : (out << "<null>"));
  out << ", " << "computeResourcePreferences="; (__isset.computeResourcePreferences ? (out << to_string(computeResourcePreferences)) : (out << "<null>"));
  out << ", " << "storagePreferences="; (__isset.storagePreferences ? (out << to_string(storagePreferences)) : (out << "<null>"));
  out << ", " << "identityServerTenant="; (__isset.identityServerTenant ? (out << to_string(identityServerTenant)) : (out << "<null>"));
  out << ", " << "identityServerPwdCredToken="; (__isset.identityServerPwdCredToken ? (out << to_string(identityServerPwdCredToken)) : (out << "<null>"));
  out << ")";
}

}}}}} // namespace
