/**
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
 *
 */
package org.apache.airavata.grouper.group;

import static edu.internet2.middleware.subject.provider.SubjectTypeEnum.PERSON;
import static org.apache.airavata.grouper.AiravataGrouperUtil.COLON;
import static org.apache.airavata.grouper.AiravataGrouperUtil.GROUPS_STEM_NAME;
import static org.apache.airavata.grouper.AiravataGrouperUtil.SUBJECT_SOURCE;
import static org.apache.airavata.grouper.group.GroupMembershipType.DIRECT;
import static org.apache.airavata.grouper.group.GroupMembershipType.INDIRECT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.airavata.grouper.SubjectType;

import edu.internet2.middleware.grouper.GroupFinder;
import edu.internet2.middleware.grouper.GroupSave;
import edu.internet2.middleware.grouper.GrouperSession;
import edu.internet2.middleware.grouper.Member;
import edu.internet2.middleware.grouper.MemberFinder;
import edu.internet2.middleware.grouper.SubjectFinder;
import edu.internet2.middleware.grouper.exception.GroupAddAlreadyExistsException;
import edu.internet2.middleware.grouper.exception.GroupNotFoundException;
import edu.internet2.middleware.grouper.exception.InsufficientPrivilegeException;
import edu.internet2.middleware.grouper.group.TypeOfGroup;
import edu.internet2.middleware.grouper.internal.dao.QueryOptions;
import edu.internet2.middleware.grouper.misc.SaveMode;
import edu.internet2.middleware.grouper.privs.AccessPrivilege;
import edu.internet2.middleware.grouper.util.GrouperUtil;
import edu.internet2.middleware.subject.Subject;
import edu.internet2.middleware.subject.SubjectNotFoundException;
=======
 * 
 */
package org.apache.airavata.grouper.group;

import edu.internet2.middleware.grouper.*;
import edu.internet2.middleware.grouper.exception.GroupNotFoundException;
import edu.internet2.middleware.grouper.group.TypeOfGroup;
import edu.internet2.middleware.grouper.internal.dao.QueryOptions;
import edu.internet2.middleware.grouper.util.GrouperUtil;
import edu.internet2.middleware.subject.Subject;
import edu.internet2.middleware.subject.SubjectNotFoundException;
import org.apache.airavata.grouper.SubjectType;

import java.util.ArrayList;
import java.util.List;

import static edu.internet2.middleware.grouper.misc.SaveMode.INSERT_OR_UPDATE;
import static edu.internet2.middleware.subject.provider.SubjectTypeEnum.PERSON;
import static org.apache.airavata.grouper.AiravataGrouperUtil.*;
import static org.apache.airavata.grouper.group.GroupMembershipType.DIRECT;
import static org.apache.airavata.grouper.group.GroupMembershipType.INDIRECT;
>>>>>>> adding more files

/**
 * @author vsachdeva
 *
 */
public class GroupServiceImpl implements GroupService {
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856


  public void createGroup(Group group) throws SubjectNotFoundException, GroupAddAlreadyExistsException {

    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      Subject subject = SubjectFinder.findByIdAndSource(group.getOwnerId(), SUBJECT_SOURCE, true);
=======
  
  
  public void createOrUpdateGroup(Group group) {
    
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
>>>>>>> adding more files
      GroupSave groupSave = new GroupSave(grouperSession);
      groupSave.assignTypeOfGroup(TypeOfGroup.group);
      groupSave.assignGroupNameToEdit(GROUPS_STEM_NAME+COLON+group.getId());
      groupSave.assignName(GROUPS_STEM_NAME+COLON+group.getId());
      groupSave.assignDisplayExtension(group.getName());
      groupSave.assignDescription(group.getDescription());
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
      groupSave.assignSaveMode(SaveMode.INSERT);
      groupSave.assignCreateParentStemsIfNotExist(true);
      edu.internet2.middleware.grouper.Group grp = groupSave.save();
      grp.grantPriv(subject, AccessPrivilege.ADMIN, false);
      for (String userId: group.getMembers()) {
        Subject sub = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, true);
        grp.addMember(sub, false);
      }
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }

  public void updateGroup(Group group) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException {

    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      Subject subject = SubjectFinder.findByIdAndSource(group.getOwnerId(), SUBJECT_SOURCE, true);

      edu.internet2.middleware.grouper.Group grouperGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+group.getId(),
          true, new QueryOptions().secondLevelCache(false));

      Subject admin = null;
      // there will be one admin only.
      if (grouperGroup.getAdmins().size() > 0) {
        admin = grouperGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+group.getId()+". It should have never happened.");
      }
      if (!admin.getId().equals(subject.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group can update.");
      }
      GroupSave groupSave = new GroupSave(grouperSession);
      groupSave.assignTypeOfGroup(TypeOfGroup.group);
      groupSave.assignGroupNameToEdit(GROUPS_STEM_NAME+COLON+group.getId());
      groupSave.assignName(GROUPS_STEM_NAME+COLON+group.getId());
      groupSave.assignDisplayExtension(group.getName());
      groupSave.assignDescription(group.getDescription());
      groupSave.assignSaveMode(SaveMode.UPDATE);
      groupSave.assignCreateParentStemsIfNotExist(true);
      edu.internet2.middleware.grouper.Group grp = groupSave.save();
      for (Member member: grp.getMembers()) {
        grp.deleteMember(member);
      }
      for (String userId: group.getMembers()) {
        Subject sub = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, true);
        grp.addMember(sub, false);
=======
      groupSave.assignSaveMode(INSERT_OR_UPDATE);
      groupSave.assignCreateParentStemsIfNotExist(true);
      edu.internet2.middleware.grouper.Group grp = groupSave.save();
      for (String userId: group.getUsers()) {
        Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, false);
        if (subject == null) {
          throw new SubjectNotFoundException(userId+" airavata internal user id was not found.");
        }
        grp.addMember(subject, false);
>>>>>>> adding more files
      }
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  }

  public void deleteGroup(String groupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException {

    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group group = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId,
          true, new QueryOptions().secondLevelCache(false));
      Subject subject = SubjectFinder.findByIdAndSource(ownerId, SUBJECT_SOURCE, true);
      Subject admin = null;
      // there will be one admin only.
      if (group.getAdmins().size() > 0) {
        admin = group.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+groupId+". It should have never happened.");
      }
      if (!admin.getId().equals(subject.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group can update.");
      }
=======
  }
  
  public void deleteGroup(String groupId) throws GroupNotFoundException {
    
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group group = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, 
          true, new QueryOptions().secondLevelCache(false));
>>>>>>> adding more files
      group.delete();
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public Group getGroup(String groupId) throws GroupNotFoundException {

    GrouperSession grouperSession = null;
    Group group = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group grouperGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, true);
      Subject admin = null;
      // there will be one admin only.
      if (grouperGroup.getAdmins().size() > 0) {
        admin = grouperGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+groupId+". It should have never happened.");
      }
      group = new Group(grouperGroup.getExtension(), admin.getId());
=======
  
  public Group getGroup(String groupId) throws GroupNotFoundException {
    
    GrouperSession grouperSession = null;
    Group group = new Group();
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group grouperGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, true);
      group.setId(grouperGroup.getExtension());
>>>>>>> adding more files
      group.setName(grouperGroup.getDisplayExtension());
      group.setDescription(grouperGroup.getDescription());
      List<String> users = new ArrayList<String>();
      for(Member member: grouperGroup.getMembers()) {
        if (member.getSubjectType().equals(PERSON)) {
          users.add(member.getSubjectId());
        }
      }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
      group.setMembers(users);
=======
      group.setUsers(users);
>>>>>>> adding more files
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
    return group;
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public void addGroupToGroup(String parentGroupId, String childGroupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException {

=======
  
  public void addGroupToGroup(String parentGroupId, String childGroupId) throws GroupNotFoundException {
    
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group grouperParentGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+parentGroupId, true);
      edu.internet2.middleware.grouper.Group grouperChildGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+childGroupId, true);
      Subject subject = SubjectFinder.findById(grouperChildGroup.getId(), false);
      if (subject == null) {
        throw new GroupNotFoundException(childGroupId+" was not found.");
      }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
      Subject maybeAdmin = SubjectFinder.findByIdAndSource(ownerId, SUBJECT_SOURCE, true);
      Subject admin = null;
      // there will be one admin only.
      if (grouperParentGroup.getAdmins().size() > 0) {
        admin = grouperParentGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+parentGroupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group "+parentGroupId+" can update.");
      }

      if (grouperChildGroup.getAdmins().size() > 0) {
        admin = grouperChildGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+childGroupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group "+childGroupId+" can update.");
      }
=======
>>>>>>> adding more files
      grouperParentGroup.addMember(subject, false);
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public void removeGroupFromGroup(String parentGroupId, String childGroupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException {

=======
  
  public void removeGroupFromGroup(String parentGroupId, String childGroupId) throws GroupNotFoundException {
    
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group grouperParentGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+parentGroupId, true);
      edu.internet2.middleware.grouper.Group grouperChildGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+childGroupId, true);
      Subject subject = SubjectFinder.findById(grouperChildGroup.getId(), false);
      if (subject == null) {
        throw new SubjectNotFoundException(childGroupId+" was not found.");
      }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

      Subject maybeAdmin = SubjectFinder.findByIdAndSource(ownerId, SUBJECT_SOURCE, true);
      Subject admin = null;
      // there will be one admin only.
      if (grouperParentGroup.getAdmins().size() > 0) {
        admin = grouperParentGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+parentGroupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group "+parentGroupId+" can update.");
      }

      if (grouperChildGroup.getAdmins().size() > 0) {
        admin = grouperChildGroup.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+childGroupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group "+childGroupId+" can update.");
      }
=======
>>>>>>> adding more files
      grouperParentGroup.deleteMember(subject, false);
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public void addUserToGroup(String userId, String groupId, String ownerId) throws SubjectNotFoundException, GroupNotFoundException, InsufficientPrivilegeException {
=======
  
  public void addUserToGroup(String userId, String groupId) throws SubjectNotFoundException, GroupNotFoundException {
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group group = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, true);
      Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, true);
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

      Subject maybeAdmin = SubjectFinder.findByIdAndSource(ownerId, SUBJECT_SOURCE, true);
      Subject admin = null;
      // there will be one admin only.
      if (group.getAdmins().size() > 0) {
        admin = group.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+groupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group can update.");
      }
=======
>>>>>>> adding more files
      group.addMember(subject, false);
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public void removeUserFromGroup(String userId, String groupId, String ownerId) throws SubjectNotFoundException, GroupNotFoundException, InsufficientPrivilegeException {
=======
  
  public void removeUserFromGroup(String userId, String groupId) throws SubjectNotFoundException, GroupNotFoundException {
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group group = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, true);
      Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, true);
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

      Subject maybeAdmin = SubjectFinder.findByIdAndSource(ownerId, SUBJECT_SOURCE, true);
      Subject admin = null;
      // there will be one admin only.
      if (group.getAdmins().size() > 0) {
        admin = group.getAdmins().iterator().next();
      }
      if (admin == null) {
        throw new RuntimeException("There is no admin for the group "+groupId+". It should have never happened.");
      }
      if (!admin.getId().equals(maybeAdmin.getId())) {
        throw new InsufficientPrivilegeException("Only the owner of the group can update.");
      }

=======
>>>>>>> adding more files
      group.deleteMember(subject, false);
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public List<GroupMembership> getAllMembersForGroup(String groupId) throws GroupNotFoundException {
=======
  
  public List<GroupMembership> getAllMembersForTheGroup(String groupId) throws GroupNotFoundException {
>>>>>>> adding more files
    List<GroupMembership> groupMemberships = new ArrayList<GroupMembership>();
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group grouperGroup = GroupFinder.findByName(grouperSession, GROUPS_STEM_NAME+COLON+groupId, true);
      for(Member member: grouperGroup.getImmediateMembers()) {
        GroupMembership groupMembership = new GroupMembership();
        groupMembership.setGroupId(groupId);
        groupMembership.setGroupMembershipType(DIRECT);
        groupMembership.setMemberId(member.getSubjectType().equals(PERSON) ? member.getSubjectId() : GrouperUtil.substringAfterLast(member.getName(), ":"));
        groupMembership.setMemberType(member.getSubjectType().equals(PERSON) ? SubjectType.PERSON: SubjectType.GROUP);
        groupMemberships.add(groupMembership);
      }
      for(Member member: grouperGroup.getNonImmediateMembers()) {
        GroupMembership groupMembership = new GroupMembership();
        groupMembership.setGroupId(groupId);
        groupMembership.setGroupMembershipType(INDIRECT);
        groupMembership.setMemberId(member.getSubjectType().equals(PERSON) ? member.getSubjectId() : GrouperUtil.substringAfterLast(member.getName(), ":"));
        groupMembership.setMemberType(member.getSubjectType().equals(PERSON) ? SubjectType.PERSON: SubjectType.GROUP);
        groupMemberships.add(groupMembership);
      }
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
    return groupMemberships;
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public List<GroupMembership> getAllMembershipsForUser(String userId) throws SubjectNotFoundException {
    List<GroupMembership> groupMemberships = new ArrayList<GroupMembership>();
    GrouperSession grouperSession = null;
    try {
      grouperSession = GrouperSession.startRootSession();
      Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, true);
      Member member = MemberFinder.findBySubject(grouperSession, subject, false);
      if (member != null) {
        for (edu.internet2.middleware.grouper.Group group : member.getImmediateGroups()) {
          GroupMembership groupMembership = new GroupMembership();
          groupMembership.setGroupId(group.getExtension());
          groupMembership.setGroupMembershipType(DIRECT);
          groupMembership.setMemberId(userId);
          groupMembership.setMemberType(SubjectType.PERSON);
          groupMemberships.add(groupMembership);
        }
        for (edu.internet2.middleware.grouper.Group group : member.getNonImmediateGroups()) {
          GroupMembership groupMembership = new GroupMembership();
          groupMembership.setGroupId(group.getExtension());
          groupMembership.setGroupMembershipType(INDIRECT);
          groupMembership.setMemberId(userId);
          groupMembership.setMemberType(SubjectType.PERSON);
          groupMemberships.add(groupMembership);
        }
      }
    } finally {
      GrouperSession.stopQuietly(grouperSession);
    }
    return groupMemberships;
  }

  public static void main(String[] args) {

    GroupService groupService = new GroupServiceImpl();

    // create a test group
    Group parentGroup = new Group("airavata parent group id", "airavata_id_1");
    parentGroup.setName("airavata parent group name");
    parentGroup.setDescription("airavata parent group description");
    parentGroup.setMembers(Arrays.asList("airavata_id_2", "airavata_id_3"));
    groupService.createGroup(parentGroup);

    // update the same group
    Group updateGroup = new Group("airavata parent group id", "airavata_id_1");
    updateGroup.setName("airavata parent group name updated");
    updateGroup.setDescription("airavata parent group description updated");
    updateGroup.setMembers(Arrays.asList("airavata_id_4", "airavata_id_5"));
    groupService.updateGroup(updateGroup);

    // create another group
    Group childGroup = new Group("airavata child group id", "airavata_id_1");
    childGroup.setName("airavata child group name");
    childGroup.setDescription("airavata child group description");
    childGroup.setMembers(Arrays.asList("airavata_id_6", "airavata_id_7"));
    groupService.createGroup(childGroup);

    // add child group to parent group
    groupService.addGroupToGroup("airavata parent group id", "airavata child group id", "airavata_id_1");

    // add two more direct persons to the group
    groupService.addUserToGroup("airavata_id_2", "airavata parent group id", "airavata_id_1");
    groupService.addUserToGroup("airavata_id_3", "airavata parent group id", "airavata_id_1");

    // add a person to the child group which will be basically an indirect member of parent group
    groupService.addUserToGroup("airavata_id_8", "airavata child group id", "airavata_id_1");

    // get the parent group
    Group group = groupService.getGroup("airavata parent group id");
    System.out.println(group);

    //get all the members of the group
    List<GroupMembership> allMembersForGroup = groupService.getAllMembersForGroup("airavata parent group id");
    System.out.println(allMembersForGroup);

    //get all the groups for user airavata_id_2
    List<GroupMembership> membershipsForUser = groupService.getAllMembershipsForUser("airavata_id_2");
    System.out.println(membershipsForUser);

    // remove child from parent
    groupService.removeGroupFromGroup("airavata parent group id", "airavata child group id", "airavata_id_1");

    // delete the same group
    groupService.deleteGroup("airavata child group id", "airavata_id_1");
    groupService.deleteGroup("airavata parent group id", "airavata_id_1");

  }

=======
  
  public static void main(String[] args) {
    
    GroupServiceImpl groupServiceImpl = new GroupServiceImpl();
    
    // create a test group
    Group parentGroup = new Group();
    parentGroup.setId("airavata parent group id");
    parentGroup.setName("airavata parent group name");
    parentGroup.setDescription("airavata parent group description");
    groupServiceImpl.createOrUpdateGroup(parentGroup);
    
    // update the same group
    Group updateGroup = new Group();
    updateGroup.setId("airavata parent group id");
    updateGroup.setName("airavata parent group name updated");
    updateGroup.setDescription("airavata parent group description updated");
    groupServiceImpl.createOrUpdateGroup(updateGroup);
    
    // create another group
    Group childGroup = new Group();
    childGroup.setId("airavata child group id");
    childGroup.setName("airavata child group name");
    childGroup.setDescription("airavata child group description");
    groupServiceImpl.createOrUpdateGroup(childGroup);
    
    // add child group to parent group
    groupServiceImpl.addGroupToGroup("airavata parent group id", "airavata child group id");
      
    // add a direct person to the group
    groupServiceImpl.addUserToGroup("admin@seagrid", "airavata parent group id");
    
    // add a person to the child group which will be basically an indirect member of parent group
    groupServiceImpl.addUserToGroup("scnakandala@seagrid", "airavata child group id");
    
    // get the parent group
    groupServiceImpl.getGroup("airavata parent group id");
    
    //get all the members of the group
    groupServiceImpl.getAllMembersForTheGroup("airavata parent group id");
    
    // remove child from parent
    groupServiceImpl.removeGroupFromGroup("airavata parent group id", "airavata child group id");
    
    // delete the same group 
    groupServiceImpl.deleteGroup("airavata child group id");
    groupServiceImpl.deleteGroup("airavata parent group id");
    
  }
 
>>>>>>> adding more files
}
