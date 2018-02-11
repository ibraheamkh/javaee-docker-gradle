package co.akwad.websphere;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PersonDatabaseTest {

	@Deployment
	public static WebArchive create() {
		return ShrinkWrap.create(WebArchive.class)
				.addClasses(Person.class, PersonDatabase.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	// @Deployment
	// public static JavaArchive create() {
	// return ShrinkWrap.create(JavaArchive.class)
	// .addClasses(Person.class, PersonDatabase.class)
	// //.addPackages(false, Person.class.getPackage(),
	// PersonDatabase.class.getPackage())
	// .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	// }

	@Inject
	PersonDatabase personDatabase;

	@Test
	public void shouldGetPennyFromPersonDatabase() {
		assertThat(personDatabase, notNullValue());
		assertThat(personDatabase.getPerson(0).getName(), is("Penny"));
	}
}