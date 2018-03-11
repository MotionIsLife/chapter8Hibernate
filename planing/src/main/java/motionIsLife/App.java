package motionIsLife;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:task-job-app-context.xml");
        ctx.refresh();
        while(true) {

        }
    }
}
