package com.lj.Day12.Homework;

/**
 * @Author：林杰
 * @Package：com.lj.Day12.Homework
 * @Project：IdeaProjects
 * @name：CreditAccount
 * @Date：2023/7/16 12:08
 * @Filename：CreditAccount
 */
public class CreditAccount extends Account{
    private double credit_limit;

    public double getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(double credit_limit) {
        this.credit_limit = credit_limit;
    }
    public CreditAccount() {

    }
    public CreditAccount(Long id, String password, String name, String personId, double balance, int type, double credit_limit) {
        super(id, password, name, personId, balance, type);
        this.credit_limit = credit_limit;
    }

    @Override
    public Account withdraw(double money) {
        if (credit_limit + getBalance() >= money){
            if(getBalance() >= money){
                double yu_er = this.getBalance() - money;
                System.out.println("取款成功");
                this.setBalance(yu_er);
            }else {
                double xin_yong = this.getCredit_limit() - (money - this.getBalance());
                System.out.println("取款成功");
                this.setCredit_limit(xin_yong);
            }
            return account;
        }else {
            System.out.println("您当前的账户余额和信用额度不足");
            return null;
        }
    }
}
