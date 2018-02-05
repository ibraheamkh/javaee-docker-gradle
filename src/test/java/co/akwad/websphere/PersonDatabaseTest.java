package co.akwad.websphere;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import javax.inject.Inject;

import org.arquillian.cube.HostIp;
import org.arquillian.cube.HostPort;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PersonDatabaseTest {
	
//	@HostIp
//	String ip;
//	
//	@HostPort(containerName = "websphere", value = 8080)
//	int port;

    @Deployment
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(Person.class, PersonDatabase.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    PersonDatabase personDatabase;

    @Test
    public void shouldGetPennyFromPersonDatabase() {
        assertThat(personDatabase, notNullValue());
        assertThat(personDatabase.getPerson(0).getName(), is("Penny"));
    }
}