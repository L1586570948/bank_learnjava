package com.lj.Day12.Homework;

/**
 * @Author：林杰
 *
 *
 *要求1：封装一个Account类 - 业务数据
 * 写一个账户类(Account),属性并且完全封装(注意:要辨别每个属性的set/get方法是否需要公开):
 * id:账户号码 长整数(Long)
 * password:账户密码 字符串类型(String)
 * name:真实姓名 字符串类型(String)
 * personId:身份证号码 字符串类型(String)
 * balance:账户余额 双精度(double)
 *  type:账户类型  0:储蓄账户  1:信用账户
 * 方法:
 * deposit:  存款方法,参数类型：double, 返回类型：Account
 * withdraw:取款方法,参数类型：double, 返回类型：Account
 *
 * 构造方法:
 * 有参和无参,有参构造方法用于设置必要的属性
 * 生成getXxx/setXxx方法
 *
 * 要求2：完成以下两种账户类型的编码。
 * 银行的客户分为两大类：储蓄账户(SavingAccount)和信用账户(CreditAccount),两种的账户类型的区别在于：
 * 储蓄账户不允许透支,而信用账户可以透支,并在用户在满足银行条件的情况下允许用户调整自己的透支额度.
 * 注意:
 * 1、CreditAccount需要多一个属性 ceiling 透支额度；
 * 2、CreditAccount需要覆盖（重写）Account中的取款方式withdraw()
 *
 * 要求3：完成Bank类的编码。
 * 属性:
 * 1.当前所有的账户对象的信息,存放在数组中: Account[].
 * 2.当前账户数量index.
 *
 * 方法:
 * 1.	用户开户(register)
 *      参数列表: Long 账号, String密码, String确认密码,String 姓名,String身份证号码 ,int 账户类型；
 * (Long id, String password, String repassword, String name, String personID, int type)
 *      返回类型：Account
 *      项目需求规定账户类型：0 – 储蓄账户  1 – 信用账户
 * 2.	用户登录(login)
 *      参数列表: Long 账号, String密码；
 * (Long id, String password)
 *      返回类型：Account
 * 3.	用户存款(deposit)
 *      参数列表: Long 账号, double存款金额；
 * (Long id, double money)
 *      返回类型：Account
 * 4.	用户取款(withdraw)
 *      参数列表: Long 账号,String 密码，double取款金额；
 * (Long id, String password, double money)
 *      返回类型：Account
 * 5.	设置透支额度(addCeiling)
 *      参数列表: Long 账号, String 密码，double透支额度金额；
 * (Long id, String password, double money)
 *      返回类型：Account
 * 提示：这个方法需要验证账户是否是信用账户
 * 6.	转账功能(transfer)
 *     参数：fromId转出账户，passwordFrom 转出账号的密码，toId转入账户，money转账的金额
 *           (Long fromId, String passwordFrom, Long toId, double money)
 *      返回值：boolean
 *
 * 要求4：另外,请为Bank类添加2个统计方法
 * 1.统计银行所有账户余额总数
 * 2.统计所有信用账户透支额度总数
 *
 * 要求5：编写测试类
 * 写个测试类，测试以上代码能否正常工作。界面可以参考上面的截图，也可以自己组织，最终界面的八个功能要正常运行。
 */
public abstract class Account {
    static Account account;

    private Long id;
    private String password;
    private String name;
    private String personId;
    private double balance;
    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Account() {
    }

    public Account(Long id, String password, String name, String personId, double balance, int type) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.balance = balance;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", personId='" + personId + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }
    //存款方法
    public Account deposit(double money){
        this.balance = getBalance()+money;
        System.out.println("存款成功");
        return account;
    }

    //取款方法
    public abstract Account withdraw(double money) ;
}
