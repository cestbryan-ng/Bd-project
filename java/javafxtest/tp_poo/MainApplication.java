package javafxtest.tp_poo;

import java.time.LocalDate;

public class MainApplication {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setSalaire(500);
        System.out.println(agent.getSalaire());
    }
}
