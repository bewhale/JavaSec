package org.bewhale.javasec.controller.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestImpl extends UnicastRemoteObject implements Test{
    protected TestImpl() throws RemoteException {
    }
    public Object getTest() throws  RemoteException{
        return "test";
    }
}