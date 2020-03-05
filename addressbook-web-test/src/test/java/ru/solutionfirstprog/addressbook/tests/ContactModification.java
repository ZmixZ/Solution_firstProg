package ru.solutionfirstprog.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.solutionfirstprog.addressbook.module.ContactIng;
import ru.solutionfirstprog.addressbook.module.GroupInf;

import java.util.HashSet;
import java.util.List;


public class ContactModification extends TestBase {

    @Test
    public void testContactModification(){

        applicationManager.getNavigationClass().gotoGroup();

        if(!applicationManager.getGroupHelper().isThereAGroup()){
            applicationManager.getGroupHelper().createGroup(new GroupInf("test1", "test2", "test3"));
        }

        applicationManager.getReturnHelper().returnHome();

        if(!applicationManager.getContactHelper().thereAContact()){
            applicationManager.getNavigationClass().gotoNewContact();
            applicationManager.getContactHelper().createContact();
            applicationManager.getReturnHelper().gotoHomePage();
        }
        List<ContactIng> before = applicationManager.getContactHelper().contactList();
        applicationManager.getContactHelper().tookContactModification();
        ContactIng contact = new ContactIng(before.get(before.size() - 1).getId(), "RZD", "Moscow, street Tambovskaya.", "jonjolli@yandex.fu", "Ivan", "Ivanovich", "Ivanov", null);
        applicationManager.getContactHelper().createContactInf(contact, false);
        applicationManager.getContactHelper().submitContactModification();
        applicationManager.getReturnHelper().gotoHomePage();
        List<ContactIng> after = applicationManager.getContactHelper().contactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet(after), new HashSet(before));
    }
}