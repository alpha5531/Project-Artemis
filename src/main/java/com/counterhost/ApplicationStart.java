package com.counterhost;

import com.counterhost.Application.ShopEngine.Workers.BasketWorker.BasketWorker;


public class ApplicationStart {
    public static void main(String[] args) {
        System.out.print(" Created By Zygmunt Postawa! \n");

        System.out.println("               ____");
        System.out.println("          .-'\"\"p 8o\"\"`-.");
        System.out.println("       .-'8888P'Y.`Y[ ' `-.");
        System.out.println("     ,']88888b.J8oo_      '`.");
        System.out.println("   ,' ,88888888888[\"        Y`.");
        System.out.println("  /   8888888888P            Y8\\");
        System.out.println(" /    Y8888888P'             ]88\\");
        System.out.println(":     `Y88'   P              `888:");
        System.out.println(":       Y8.oP '- >            Y88:");
        System.out.println("|          `Yb  __             `'|");
        System.out.println(":            `'d8888bo.          :");
        System.out.println(":             d88888888ooo.      ;");
        System.out.println(" \\            Y88888888888P     /");
        System.out.println("  \\            `Y88888888P     /");
        System.out.println("   `.            d88888P'    ,'");
        System.out.println("     `.          888PP'    ,'");
        System.out.println("       `-.      d8P'    ,-'   -ARTEMIS-");
        System.out.println("          `-.,,_'__,,.-'");
//        for(int i = 0; i < 1000; i++){
            BasketWorker work = new BasketWorker();
//            System.out.println(work.OpenBasket().toString());
//        }
        System.out.println(work.CloseBasket(1658).toString());


    }
}