/**
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
 *
=======
 * 
>>>>>>> adding more files
 */
package org.apache.airavata.grouper.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsachdeva
 *
 */
public class Group {
<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  private String id;

  private String name;

  private String ownerId;

  private String description;

  private List<String> members = new ArrayList<String>();

  public Group(String id, String ownerId) {
    if (id == null || ownerId == null) {
      throw new IllegalArgumentException("id or ownerId is null");
    }
    this.id = id;
    this.ownerId = ownerId;
  }

  public Group() {

  }

  public void setId(String id) {
    this.id = id;
  }

=======
  
  private String id;
  
  private String name;
  
  private String description;
  
  private List<String> users = new ArrayList<String>();
  
>>>>>>> adding more files
  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
=======
  
  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  
>>>>>>> adding more files
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

=======
  
>>>>>>> adding more files
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

  /**
   * @return the ownerId
   */
  public String getOwnerId() {
    return ownerId;
  }


=======
  
>>>>>>> adding more files
  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856

=======
  
>>>>>>> adding more files
  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

<<<<<<< 10f30a96f6478fb045ae6e0cdb15b25614581856
  /**
   * @return the members
   */
  public List<String> getMembers() {
    return members;
  }

  /**
   * @param members the members to set
   */
  public void setMembers(List<String> members) {
    this.members = members;
  }


  @Override
  public String toString() {
    return "Group [id=" + id + ", name=" + name + ", ownerId=" + ownerId
        + ", description=" + description + "]";
  }

=======
  
  /**
   * @return the users
   */
  public List<String> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(List<String> users) {
    this.users = users;
  }


  /**
   * @see Object#toString()
   */
  @Override
  public String toString() {
    return "Group [id=" + id + ", name=" + name + ", description=" + description + "]";
  }
  
>>>>>>> adding more files
}
