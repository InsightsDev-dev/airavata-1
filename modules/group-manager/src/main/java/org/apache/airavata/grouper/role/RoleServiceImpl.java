/**
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
 *
=======
 * 
>>>>>>> adding more files
 */
package org.apache.airavata.grouper.role;

import edu.internet2.middleware.grouper.*;
import edu.internet2.middleware.grouper.exception.GroupNotFoundException;
import edu.internet2.middleware.grouper.group.TypeOfGroup;
import edu.internet2.middleware.grouper.misc.SaveMode;
import edu.internet2.middleware.subject.Subject;
import edu.internet2.middleware.subject.SubjectNotFoundException;

import static org.apache.airavata.grouper.AiravataGrouperUtil.*;

/**
 * @author vsachdeva
 *
 */
public class RoleServiceImpl {
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856


  public Group createRole(String roleId, GrouperSession session) {

=======
  
  
  public Group createRole(String roleId, GrouperSession session) {
    
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    Group role = null;
    try {
      grouperSession = session != null? session : GrouperSession.startRootSession();
      GroupSave groupSave = new GroupSave(grouperSession);
      groupSave.assignTypeOfGroup(TypeOfGroup.role);
      groupSave.assignGroupNameToEdit(ROLES_STEM_NAME+COLON+roleId);
      groupSave.assignName(ROLES_STEM_NAME+COLON+roleId);
      groupSave.assignDisplayExtension(roleId);
      groupSave.assignDescription(roleId);
      groupSave.assignSaveMode(SaveMode.INSERT_OR_UPDATE);
      groupSave.assignCreateParentStemsIfNotExist(true);
      role = groupSave.save();
    } finally {
      if (session == null) {
        GrouperSession.stopQuietly(grouperSession);
      }
    }
    return role;
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

=======
  
>>>>>>> adding more files
  public void deleteRole(String roleId, GrouperSession session) {
    GrouperSession grouperSession = null;
    try {
      grouperSession = session != null? session : GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group role = GroupFinder.findByName(grouperSession, ROLES_STEM_NAME+COLON+roleId, false);
      if (role != null) {
        role.delete();
      }
    } finally {
      if (session == null) {
        GrouperSession.stopQuietly(grouperSession);
      }
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public void assignRoleToUser(String userId, String roleId, GrouperSession session) throws GroupNotFoundException, SubjectNotFoundException {

=======
  
  public void assignRoleToUser(String userId, String roleId, GrouperSession session) throws GroupNotFoundException, SubjectNotFoundException {
    
>>>>>>> adding more files
    GrouperSession grouperSession = null;
    try {
      grouperSession = session != null? session : GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group role = GroupFinder.findByName(grouperSession, ROLES_STEM_NAME+COLON+roleId, false);
      if (role == null) {
        throw new GroupNotFoundException("Role "+roleId+" was not found.");
      }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
      Subject subject = SubjectFinder.findById(userId, false);
=======
      Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, false);
>>>>>>> adding more files
      if (subject == null) {
        throw new SubjectNotFoundException("userId "+userId+" was not found.");
      }
      role.addMember(subject, false);
    } finally {
      if (session == null) {
        GrouperSession.stopQuietly(grouperSession);
      }
    }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  }

=======
    
  }
  
>>>>>>> adding more files
  public void removeRoleFromUser(String userId, String roleId, GrouperSession session) throws GroupNotFoundException, SubjectNotFoundException {
    GrouperSession grouperSession = null;
    try {
      grouperSession = session != null? session : GrouperSession.startRootSession();
      edu.internet2.middleware.grouper.Group role = GroupFinder.findByName(grouperSession, ROLES_STEM_NAME+COLON+roleId, false);
      if (role == null) {
        throw new GroupNotFoundException("Role "+roleId+" was not found.");
      }
      Subject subject = SubjectFinder.findByIdAndSource(userId, SUBJECT_SOURCE, false);
      if (subject == null) {
        throw new SubjectNotFoundException("userId "+userId+" was not found.");
      }
      role.deleteMember(subject, false);
    } finally {
      if (session == null) {
        GrouperSession.stopQuietly(grouperSession);
      }
    }
  }
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  public static void main(String[] args) {
    RoleServiceImpl roleServiceImpl = new RoleServiceImpl();

    roleServiceImpl.createRole("test_role", null);

    roleServiceImpl.assignRoleToUser("test.subject.3", "test_role", null);

=======
  
  public static void main(String[] args) {
    RoleServiceImpl roleServiceImpl = new RoleServiceImpl();
    
    roleServiceImpl.createRole("test_role", null);
    
    roleServiceImpl.assignRoleToUser("test.subject.3", "test_role", null);
    
>>>>>>> adding more files
    //roleServiceImpl.deleteRole("test_role", null);
  }

}
