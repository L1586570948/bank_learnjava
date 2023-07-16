package com.lj.Day12.Homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：林杰
 * @Package：com.lj.Day12.Homework
 * @Project：IdeaProjects
 * @name：Bank_Work
 * @Date：2023/7/16 15:22
 * @Filename：Bank_Work
 */
public class ATM_System {
    static Bank b = new Bank();
    static Scanner sc = new Scanner(System.in);
/*    static SavingAccount sa_account = new SavingAccount();
    static CreditAccount cr_account = new CreditAccount();
    static Account _account ;
    static ArrayList<Account> account_list2 = new ArrayList<>();*/
public static void main(String[] args) {
    do {
        System.out.println("===================欢迎来到ATM取款机系统===================");
        System.out.println("0.退卡");
        System.out.println("1.开户");
        System.out.println("2.登入");
        System.out.println("3.存款");
        System.out.println("4.取款");
        System.out.println("5.设置透支额度");
        System.out.println("6.转账");
        System.out.println("7.查询所有账户余额总数");
        System.out.println("8.查询信用账户透支额度总数");
        System.out.println("请输入你的选择");
        int choice = sc.nextInt();
        switch (choice){
            case 0:
                System.out.println("已退出！");
                System.exit(0);
            case 1:
                //Long id, String password, String repassword,String name, String personid ,int type
                System.out.println("请输入用户账号:");
                Long id = sc.nextLong();
                System.out.println("请输入用户密码:");
                String password = sc.next();
                System.out.println("请再输入用户密码确认一遍:");
                String repassword = sc.next();
                System.out.println("请输入你的身份证名字：");
                String name = sc.next();
                System.out.println("请输入你的身份证号码：");
                String personid = sc.next();
                System.out.println("请选择你要开户的类型（0:储蓄卡，1:信用卡）");
                int type = sc.nextInt();
                /*if (type == 1){
                    cr_account= (CreditAccount) b.Register(id,password,repassword,name,personid,type);
                    account_list2.add(cr_account);
                }
                else if(type == 0) {
                    sa_account= (SavingAccount) b.Register(id,password,repassword,name,personid,type);
                    account_list2.add(sa_account);
                }*/
                b.Register(id,password,repassword,name,personid,type);
                break;
            case 2:
                //Long id, String password
                System.out.println("请输入用户账号:");
                id = sc.nextLong();
                System.out.println("请输入用户密码:");
                password = sc.next();
                b.Login(id,password);
                break;
            case 3:
                //Long id, double money
                System.out.println("请输入用户账号:");
                id = sc.nextLong();
                System.out.println("请输入你要存款的金额:");
                double money = sc.nextDouble();
                b.Deposit(id,money);
                break;
            case 4:
                //Long id, String password,double money
                System.out.println("请输入用户账号:");
                id = sc.nextLong();
                System.out.println("请输入用户密码:");
                password = sc.next();
                System.out.println("请输入你要取款的金额:");
                money = sc.nextDouble();
                b.Withdraw(id,password,money);
                break;
            case 5:
                //Long id, String password,double money
                System.out.println("请输入用户账号:");
                id = sc.nextLong();
                System.out.println("请输入用户密码:");
                password = sc.next();
                System.out.println("请设置你的信用额度:");
                money = sc.nextDouble();
                b.Add_credit_limit(id,password,money);
                break;
            case 6:
                //Long fromId,String passwordFrom,Long toId,double money
                System.out.println("请输入转账方的账户:");
                Long fromId = sc.nextLong();
                System.out.println("请输入转账方的密码:");
                String passwordFrom = sc.next();
                System.out.println("请输入被转账方的账户:");
                Long toId = sc.nextLong();
                System.out.println("请输入你要转账的金额:");
                money = sc.nextDouble();
                b.Transfer(fromId,passwordFrom,toId,money);
                break;
            case 7:
                //All_balance
                b.All_balance();
                break;
            case 8:
                b.All_credit_limit();
                break;
            default:
                System.out.println("您输入的选择错误，请输入0-8");
        }
    }while (true);
}

}
