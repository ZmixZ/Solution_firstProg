package ru.solutionfirstprog.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.solutionfirstprog.addressbook.module.GroupInf;
import ru.solutionfirstprog.addressbook.module.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewGroup extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resourse/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while(line != null){
        xml += line;
        line = reader.readLine();
    }
      XStream xstream = new XStream();
    xstream.processAnnotations(GroupInf.class);
      List<GroupInf> group = (List<GroupInf>)xstream.fromXML(xml);
     return group.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }
  @Test(dataProvider = "validGroups")
  public void testUntitledTestCase(GroupInf group) throws Exception {
      applicationManager.getGoTo().groupPage();
      Groups before = applicationManager.group().all();
      applicationManager.group().create(group);
      assertThat(applicationManager.group().count(), equalTo(before.size() + 1));
      Groups after = applicationManager.group().all();


      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadUntitledTestCase() throws Exception {
    applicationManager.getGoTo().groupPage();
    Groups before = applicationManager.group().all();
    GroupInf group = new GroupInf().withName("test2'").withFeeder("test2").withHeader("test2");
    applicationManager.group().create(group);
    assertThat(applicationManager.group().count(), equalTo(before.size()));
    Groups after = applicationManager.group().all();


    assertThat(after, equalTo(before));
  }

}
