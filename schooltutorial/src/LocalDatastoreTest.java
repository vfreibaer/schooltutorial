import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class LocalDatastoreTest {

    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    public void setUp() {
        helper.setUp();
    }

    public void tearDown() {
        helper.tearDown();
    }

    // run this test twice to prove we're not leaking any state across tests
    private void doTest() {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
//        assertEquals(0, ds.prepare(new Query("yam")).countEntities(withLimit(10)));
        ds.put(new Entity("yam"));
        ds.put(new Entity("yam"));
//        assertEquals(2, ds.prepare(new Query("yam")).countEntities(withLimit(10)));
    }

    public void testInsert1() {
        doTest();
    }

    public void testInsert2() {
        doTest();
    }
}