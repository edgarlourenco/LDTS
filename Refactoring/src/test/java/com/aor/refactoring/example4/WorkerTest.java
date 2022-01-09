package com.aor.refactoring.example4;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    @Test
    public void testWorker() {
        Supervisor worker = new Supervisor("John Doe", "+1 222-22222", "john", "secret");
        assertEquals("John Doe", worker.getName());
        assertEquals("+1 222-22222", worker.getPhone());
        assertFalse(worker.login("john", "wrong"));
        assertTrue(worker.login("john", "secret"));
    }

    @Test
    public void testSupervisor() {
        Supervisor supervisor = new Supervisor("John Doe", "+1 222-22222", "john", "secret");

        Supervisor minion1 = new Supervisor("Minion 1", "+1 123-12345", "minion1", "1234");
        Supervisor minion2 = new Supervisor("Minion 2", "+1 123-12345", "minion2", "1234");
        supervisor.addSupervisee(minion1);

        assertEquals("John Doe", supervisor.getName());
        assertEquals("+1 222-22222", supervisor.getPhone());
        assertFalse(supervisor.login("john", "wrong"));
        assertTrue(supervisor.login("john", "secret"));
        assertTrue(supervisor.isSupervisee(minion1));
        assertFalse(supervisor.isSupervisee(minion2));
    }

    @Test
    public void testClient() {
        Client client = new Client("John Doe", "+1 222-22222");
        assertEquals("John Doe", client.getName());
        assertEquals("+1 222-22222", client.getPhone());
    }
}