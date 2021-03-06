import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

public class Neo4jSessionFactory {

    private final static SessionFactory sessionFactory = new SessionFactory("aldrin");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}