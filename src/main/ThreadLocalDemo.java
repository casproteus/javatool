import java.util.Random;

public class ThreadLocalDemo implements Runnable {
    //创建线程局部变量studentLocal，在后面你会发现用来保存Student对象
    private final static ThreadLocal studentLocal = new ThreadLocal();
    private Student student = new Student();
    public static void main(String[] agrs) {
    	for(int i = 0; i < 100; i++)
    	System.out.println(java.util.UUID.randomUUID());
//        ThreadLocalDemo td = new ThreadLocalDemo();
//        Thread t1 = new Thread(td, "a");
//        Thread t2 = new Thread(td, "b");
//        t1.start();
//        t2.start();
    }
 
    public void run() {
        accessStudent();
    }
 
    //测试
    public void accessStudent() {
        //获取当前线程的名字
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");
        Random random = new Random();
        int age = random.nextInt(100);
        Student student = getStudent();        //获取一个Student对象，并将随机数年龄插入到对象属性中
        student.setAge(age);
        System.out.println("thread " + currentThreadName + " set age to:" + age);
        System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
        try {
            Thread.sleep(1000);
            accessStudent();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
    }
 
    protected Student getStudent() {
//        Student student = (Student) studentLocal.get();	//获取本地线程变量并强制转换为Student类型
//        if (student == null) {  						//线程首次执行此方法的时候，studentLocal.get()肯定为null
//            student = new Student();					//创建一个Student对象，并保存到本地线程变量studentLocal中
//            studentLocal.set(student);
//        }
        return student;
    }
}
