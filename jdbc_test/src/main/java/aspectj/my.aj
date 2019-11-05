package aspectj;

public aspect my{
    pointcut recordLog():call(* HelloWorld.say());
    pointcut authCheck():call(* HelloWord.say());
    before():authCheck(){
        System.out.println("sayHello方法执行前验证权限");
    }
    after():recordLog(){
        System.out.println("前置");
    }
        }