package aldrin;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by aldrin on 16-04-2017.
 */

@NodeEntity
public class Group extends Entity {

  private String name;

  @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
  private Set<Group> children = new HashSet<Group>();

  @Relationship(type = "BELONGS_TO", direction = Relationship.OUTGOING)
  private Group parent;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
  public Set<Group> getChildren() {
    return children;
  }

  @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
  public void setChildren(Set<Group> children) {
    this.children = children;
  }

  @Relationship(type = "BELONGS_TO", direction = Relationship.OUTGOING)
  public Group getParent() {
    return parent;
  }

  @Relationship(type = "BELONGS_TO", direction = Relationship.OUTGOING)
  public void setParent(Group parent) {
    this.parent = parent;
  }
}
