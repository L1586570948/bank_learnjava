package com.lj.Day12.Homework;

/**
 * @Author：林杰
 * @Package：com.lj.Day12.Homework
 * @Project：IdeaProjects
 * @name：SavingAccount
 * @Date：2023/7/16 12:42
 * @Filename：SavingAccount
 */
public class SavingAccount extends Account{
    public SavingAccount(Long id, String password, String name, String personId, double balance, int type) {
        super(id, password, name, personId, balance, type);
    }

    public SavingAccount() {
    }

    @Override
    public Account withdraw(double money) {
        if(getBalance() >= money){
            double yu_er = this.getBalance() - money;
            System.out.println("取款成功");
            this.setBalance(yu_er);
            return account;
        }
        else {
            System.out.println("您当前的余额不足");
            return null;
        }
    }
}
