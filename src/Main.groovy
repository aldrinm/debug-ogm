import aldrin.Group
import org.neo4j.ogm.model.Result
import org.neo4j.ogm.session.Session

class Main {
    private static final int DEPTH_LIST = 0
    private static final int DEPTH_ENTITY = 1

    public static void main(String[] args) {
        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession()

        createData(session);

        def groups = session.loadAll(Group.class, DEPTH_LIST)
        println "groups = ${groups.id}"

        Group a = session.load(Group.class, 33l);
        a.children.removeAll(a.children)




       // session.save(a)

        //a = session.load(Group.class, a.getId(), DEPTH_ENTITY)
        //println "a = $a"


    }

    private static void createData(Session session) {
        Group groupB = new Group();
        groupB.setName("B");
        session.save(groupB);
        groupB = session.load(Group.class, groupB.getId(), DEPTH_ENTITY)

        Group groupC = new Group();
        groupC.setName("C");
        session.save(groupC);
        groupC = session.load(Group.class, groupC.getId(), DEPTH_ENTITY)

        Group groupA = new Group();
        groupA.setName("A");

        groupA.children.add(groupB);
        groupB.setParent(groupA);
        groupA.children.add(groupC);
        groupC.setParent(groupA);

        groupA = session.save(groupA);

    }
}
