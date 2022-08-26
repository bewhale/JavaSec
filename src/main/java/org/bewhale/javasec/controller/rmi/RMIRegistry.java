package org.bewhale.javasec.controller.rmi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Controller
@RequestMapping("/home/deserialize")
public class RMIRegistry {

    @RequestMapping("/rmi")
    public String rmi(int port, Model model) {
        try {
            Registry registry = LocateRegistry.createRegistry(port);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/deserialize/rmi";
    }



    public static void main(String[] args) {
        try {
//            Service Service = new Service;
//            LocateRegistry.createRegistry(1099);
//            Naming.bind("rmi://localhost:12306/helloService", Service);
//            System.out.println("ServerMain provide RPC service now");

            Test stub = new TestImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("test", stub);
            System.out.println("绑定1099端口成功");

//            String url = "rmi://127.0.0.1:1234/setUser";
//            IUserObj user = new IUserObj();
//            LocateRegistry.createRegistry(12345);
//            Naming.list(url);
//            Naming.lookup(url);
//            Naming.bind(url,user);
//            Naming.rebind(url,user);
//            Naming.unbind(url);
//            System.out.println("Server Running At：" + url);

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
