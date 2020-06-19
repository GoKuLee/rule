package com.example.rule.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class OrderRuleRun {
    public static final void main(final String[] args) throws Exception{
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        execute( kc );
    }

    public static void execute( KieContainer kc ) throws Exception{
        KieSession ksession = kc.newKieSession("point-rulesKS");
        List<Order> orderList = getInitData();
        for (int i = 0; i < orderList.size(); i++) {
            Order o = orderList.get(i);
            ksession.insert(o);
            ksession.fireAllRules();
            System.out.println(o);
        }
        ksession.dispose();
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
