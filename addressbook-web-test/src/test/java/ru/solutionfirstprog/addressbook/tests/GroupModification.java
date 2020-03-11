package ru.solutionfirstprog.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.solutionfirstprog.addressbook.module.GroupInf;
import ru.solutionfirstprog.addressbook.module.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupModification extends TestBase {

    @BeforeMethod
    public void ensurePrecondotions(){
        applicationManager.getGoTo().groupPage();
        if(applicationManager.group().all().size() == 0){
            applicationManager.group().create(new GroupInf().withName("test2"));
        }
    }

    @Test
    public void testGroupModification(){
        Groups before = applicationManager.group().all();
        GroupInf modyfiyGroup = before.iterator().next();
        GroupInf group = new GroupInf().withId(modyfiyGroup.getId()).withName("test1").withFeeder("test1").withHeader("test1");
        applicationManager.group().modify(group);
        assertThat(applicationManager.group().count(), equalTo(before.without(modyfiyGroup).withAdded(group)));
        Groups after = applicationManager.group().all();
        assertEquals(after.size(), before.size());

    }

}
