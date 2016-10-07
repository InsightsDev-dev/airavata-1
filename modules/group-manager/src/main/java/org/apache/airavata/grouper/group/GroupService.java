/**
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
 *
 */
package org.apache.airavata.grouper.group;

import java.util.List;

import edu.internet2.middleware.grouper.exception.GroupAddAlreadyExistsException;
import edu.internet2.middleware.grouper.exception.GroupNotFoundException;
import edu.internet2.middleware.grouper.exception.InsufficientPrivilegeException;
import edu.internet2.middleware.subject.SubjectNotFoundException;
=======
 * 
 */
package org.apache.airavata.grouper.group;

import edu.internet2.middleware.grouper.exception.GroupNotFoundException;
>>>>>>> adding more files

/**
 * @author vsachdeva
 *
 */
public interface GroupService {
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  void createGroup(Group group) throws SubjectNotFoundException, GroupAddAlreadyExistsException;

  void updateGroup(Group group) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException;

  void deleteGroup(String groupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException;

  Group getGroup(String groupId) throws GroupNotFoundException;

  void addGroupToGroup(String parentGroupId, String childGroupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException;

  void removeGroupFromGroup(String parentGroupId, String childGroupId, String ownerId) throws GroupNotFoundException, SubjectNotFoundException, InsufficientPrivilegeException;

  void addUserToGroup(String userId, String groupId, String ownerId) throws SubjectNotFoundException, GroupNotFoundException, InsufficientPrivilegeException;

  void removeUserFromGroup(String userId, String groupId, String ownerId) throws SubjectNotFoundException, GroupNotFoundException, InsufficientPrivilegeException;

  List<GroupMembership> getAllMembersForGroup(String groupId) throws GroupNotFoundException;

  List<GroupMembership> getAllMembershipsForUser(String userId) throws SubjectNotFoundException;
=======
  
  public void createOrUpdateGroup(Group group);
  
  public void deleteGroup(String groupId) throws GroupNotFoundException;
  
  public Group getGroup(String groupId) throws GroupNotFoundException;
  
  public void addGroupToGroup(String parentGroupId, String childGroupId) throws GroupNotFoundException;
  
  public void removeGroupFromGroup(String parentGroupId, String childGroupId) throws GroupNotFoundException;
>>>>>>> adding more files

}
