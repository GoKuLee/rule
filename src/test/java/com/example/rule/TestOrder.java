package com.example.rule;

import com.example.rule.drools.Order;
import com.example.rule.drools.User;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestOrder {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    @Test
    public void test(){
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("point-rulesKS");
        List<Order> orderList = getInitData();
        for (int i = 0; i < orderList.size(); i++) {
            Order o = orderList.get(i);
            statefulKieSession.insert(o);
            statefulKieSession.fireAllRules();
            System.out.println(o);
        }
        statefulKieSession.dispose();
    }
    static List<Order> getInitData(){
        List<Order> list = new ArrayList<>();
        Order o1 = new Order(100);
        Order o2 = new Order(600);
        Order o3 = new Order(200);
        Order o4 = new Order(500);
        Order o5 = new Order(3300);
        Order o6 = new Order(5);
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);
        list.add(o6);
        return list;
    }
}
