/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.octo.heclausanne.controlers;

import com.octo.heclausanne.entity.CloudProvider;
import com.octo.heclausanne.facades.CloudProviderFacade;
import com.octo.heclausanne.jsfutil.JsfUtil;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ferhat
 */
public class CloudProviderControlerTest {
    
    public CloudProviderControlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCloudProviderFacade method, of class CloudProviderControler.
     */
    @Ignore
    @Test
    public void testGetCloudProviderFacade() throws Exception {
        System.out.println("getCloudProviderFacade");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        CloudProviderFacade expResult = null;
        CloudProviderFacade result = instance.getCloudProviderFacade();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCloudProviderFacade method, of class CloudProviderControler.
     */
    @Ignore
    @Test
    public void testSetCloudProviderFacade() throws Exception {
        System.out.println("setCloudProviderFacade");
        CloudProviderFacade cloudProviderFacade = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.setCloudProviderFacade(cloudProviderFacade);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected method, of class CloudProviderControler.
     */
    @Ignore 
    @Test
    public void testGetSelected() throws Exception {
        System.out.println("getSelected");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        CloudProvider expResult = null;
        CloudProvider result = instance.getSelected();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelected method, of class CloudProviderControler.
     */
    @Ignore 
    @Test
    public void testSetSelected() throws Exception {
        System.out.println("setSelected");
        CloudProvider selected = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.setSelected(selected);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCreate method, of class CloudProviderControler.
     */
    @Test
    public void testPrepareCreate() throws Exception {
        System.out.println("prepareCreate");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        CloudProvider expResult = null;
        CloudProvider result = instance.prepareCreate();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class CloudProviderControler.
     */
    @Ignore 
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.create();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.update();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.destroy();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persist method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testPersist() throws Exception {
        System.out.println("persist");
        JsfUtil.PersistAction persistAction = null;
        String successMessage = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.persist(persistAction, successMessage);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class CloudProviderControler.
     */
     
    @Test
    public void testGetItems() throws Exception {
        System.out.println("getItems");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        List<CloudProvider> expResult = null;
        List<CloudProvider> result = instance.getItems();
        for (CloudProvider cloudProvider : result) {
             System.out.println("Cloud provider"+cloudProvider.getProviderName());
        }
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class CloudProviderControler.
     */
    @Ignore
    @Test
    public void testSetItems() throws Exception {
        System.out.println("setItems");
        List<CloudProvider> items = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        instance.setItems(items);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCloudProvider method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testGetCloudProvider() throws Exception {
        System.out.println("getCloudProvider");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        CloudProvider expResult = null;
        CloudProvider result = instance.getCloudProvider(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testGetItemsAvailableSelectMany() throws Exception {
        System.out.println("getItemsAvailableSelectMany");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        List<CloudProvider> expResult = null;
        List<CloudProvider> result = instance.getItemsAvailableSelectMany();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectOne method, of class CloudProviderControler.
     */
     @Ignore
    @Test
    public void testGetItemsAvailableSelectOne() throws Exception {
        System.out.println("getItemsAvailableSelectOne");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        CloudProviderControler instance = (CloudProviderControler)container.getContext().lookup("java:global/classes/CloudProviderControler");
        List<CloudProvider> expResult = null;
        List<CloudProvider> result = instance.getItemsAvailableSelectOne();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
