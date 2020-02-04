package Threads;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class RobotThread extends Robot {
    Robot robot;

    public RobotThread() throws AWTException {
        robot = this;
    }

    //Thread robot = new Thread(hilo())
    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void compilar() {
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        //robot.mouseMove(1920, 1080);
        Runtime runtime = Runtime.getRuntime();
        /*try {
            Process process = runtime.exec("C:\\Users\\sergi\\Desktop\\Proyectos\\IdeaProjects\\PSP\\src\\Documentos\\Ejecutar.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ProcessBuilder pb;
        pb = new ProcessBuilder("notepad.exe","C:\\Users\\Usuario DAM 2\\Desktop\\server\\HOla.txt" );
        try {
            Process runCode = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
//1280, 715
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.mousePress(1);*/


    }
}
