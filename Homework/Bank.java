package com.lj.Day12.Homework;

import java.util.ArrayList;


/**
 * @Author：林杰
 * @Package：com.lj.Day12.Homework
 * @Project：IdeaProjects
 * @name：Bank
 * @Date：2023/7/16 12:45
 * @Filename：Bank
 */
public class Bank {
    //创建对象
    private ArrayList<Account> accounts_list;
    private CreditAccount c_account;
    private SavingAccount s_account;
    //初始化对象
    public void init(){
        accounts_list = new ArrayList<>();
        c_account = new CreditAccount();
        s_account = new SavingAccount();
    }
    public Bank(){
        init();
    }
    //注册
    public Account Register(Long id, String password, String repassword,String name, String personid ,int type){
        if (password.equals(repassword)){
            if (type == 0){
                s_account =new SavingAccount(id,password,name,personid,0.0,type);
                accounts_list.add(s_account);
                System.out.println("开户成功");
                return  s_account;
            }
            else if(type == 1){
                c_account =new CreditAccount(id,password,name,personid,0.0,type,0.0);
                accounts_list.add(c_account);
                System.out.println("开户成功");
                return c_account;
            }
            else {
                System.out.println("账户类型异常！");
            }
        }
        else {
            System.out.println("密码错误，请重新输入");
        }
        return null;
    }

    //登入
    public Account Login(Long id, String password){
        //flag 用于标记是否存在该账户
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        for (int i = 0; i < accounts_list.size(); i++) {
            if (accounts_list.get(i).getId().equals(id) && accounts_list.get(i).getPassword().equals(password)){
                System.out.println("登入成功！");
                flag = true;
                return accounts_list.get(i);
            }
        }
        if (flag == false){
            System.out.println("您的账户或密码错误");
        }
        return null;
    }

    //用户存款
    public Account Deposit(Long id, double money){
        //flag 用于标记是否存在该账户
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        for (int i = 0; i < accounts_list.size(); i++) {
            if (id.equals(accounts_list.get(i).getId())){
                flag = true;
                this.accounts_list.get(i).deposit(money);
                return accounts_list.get(i);
            }
        }
        if (flag == false){
            System.out.println("您输入的账户不存在");
        }
        return null;
    }

    //用户取款
    public Account Withdraw(Long id, String password,double money){
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        for (int i = 0; i < accounts_list.size(); i++) {
            if (id.equals(accounts_list.get(i).getId()) && password.equals(accounts_list.get(i).getPassword())){
                this.accounts_list.get(i).withdraw(money);
                flag = true;
                return this.accounts_list.get(i);
            }
        }
        if (flag == false){
            System.out.println("您输入的用户账户不存在！");
        }
        return null;
    }

    //设置信用额度
    /**
     * 里面的this我不确定能不能指向c_account
     */
    public Account Add_credit_limit(Long id, String password,double money){
        //flag 用于标记是否存在该账户
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        for (int i = 0; i < accounts_list.size(); i++) {
            if (id.equals(accounts_list.get(i).getId()) && password.equals(accounts_list.get(i).getPassword()) &&accounts_list.get(i).getType()==1){
                this.c_account.setCredit_limit(money);
                flag = true;
                System.out.println("设置信用额度成功");
                return this.accounts_list.get(i);
            }
        }
        if (flag == false){
            System.out.println("您输入的账户不存在");
        }
        return null;
    }

    //转账功能
    public boolean Transfer(Long fromId,String passwordFrom,Long toId,double money){
        //flag 用于标记是否存在该账户
        boolean flag1 =false;
        boolean flag2 =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        for (int i = 0; i < accounts_list.size(); i++) {
            if (accounts_list.get(i).getId().equals(fromId) && accounts_list.get(i).getPassword().equals(passwordFrom)){
                accounts_list.get(i).withdraw(money);
                flag1 = true;
            }
        }
        if(flag1 == true){
            for (int i = 0; i < accounts_list.size(); i++) {
                if (accounts_list.get(i).getId().equals(toId)){
                    accounts_list.get(i).deposit(money);
                    flag2 = true;
                }
            }
        }
        if (flag1==true && flag2==true){
            System.out.println("转账成功");
            return true;
        }
        else {
            System.out.println("转账失败");
            return false;
        }
    }

    //统计银行所有账户余额总数
    public void All_balance(){
        //flag 用于标记是否存在该账户
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        double all_money = 0.0;
        for (int i = 0; i < accounts_list.size(); i++) {
            all_money = all_money + accounts_list.get(i).getBalance();
            System.out.println("银行所有账户余额总数为:"+all_money);
            flag = true;
        }
        if (flag == false){
            System.out.println("查询总用户余额异常！！");
        }
    }

    //统计所有信用账户的透支额度总数
    /**
     * 里面的this我不确定能不能指向c_account
     */
    public void All_credit_limit(){
        //flag 用于标记是否存在该账户
        boolean flag =false;
        if (accounts_list.isEmpty()){
            System.out.println("当前系统暂未账户注册，请先去注册！");
        }
        double all_money = 0.0;
        for (int i = 0; i < accounts_list.size(); i++) {
            all_money = all_money + this.c_account.getCredit_limit();
            System.out.println("银行所有账户透支额度总数为:"+all_money);
            flag = true;
        }
        if (flag == false){
            System.out.println("查询总用户透支额度异常!!!");
        }
    }
}
