package models;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class SolvePuzzle implements Runnable {

    boolean flag = true;
    List<JButton> buttons;
    String path;

    public SolvePuzzle(List<JButton> buttons) {
        this.buttons = buttons;
    }

    protected static Puzzle solve(Puzzle p, IHeuristic h) {
        long start = System.currentTimeMillis();
        Puzzle last = AStar.calcShortestPath(p, h);
        long elapsedTimeMillis = System.currentTimeMillis() - start;

        if (last == null) {
            System.out.println("A* was not smart enough to deliver a valid solution. "
                    + "Might be the input puzzle broken?");
        } else {
            System.out.println(h + ": Steps=" + getSteps(last));
        }

        System.out.format("Elapsed time: %f min (%f secs)\n",
                elapsedTimeMillis / (60 * 1000F),
                elapsedTimeMillis / 1000F);
        System.out.println("----------------------------------------");

        return last;
    }

    protected static void printPath(Puzzle p) {
        if (p.getParent() != null) {
            printPath(p.getParent());
        }
        System.out.println(p);
    }

    protected static int getSteps(Puzzle p) {
        if (p.getParent() != null) {
            return getSteps(p.getParent()) + 1;
        }
        return 0;
    }

    @Override
    public void run() {
        
        if(this.buttons.size() == 4)
            this.path = "C:\\Users\\Lucas\\Documents\\NetBeansProjects\\AStar\\src\\sample-puzzles\\2x2.csv";
        else if(this.buttons.size() == 9) 
            this.path = "C:\\Users\\Lucas\\Documents\\NetBeansProjects\\AStar\\src\\sample-puzzles\\3x3.csv";
        else if(this.buttons.size() == 16)
            this.path = "C:\\Users\\Lucas\\Documents\\NetBeansProjects\\AStar\\src\\sample-puzzles\\4x4.csv";
        else if(this.buttons.size() == 25)
            this.path = "C:\\Users\\Lucas\\Documents\\NetBeansProjects\\AStar\\src\\sample-puzzles\\5x5.csv";
        Puzzle last = solve(
                Puzzle.fromFile(new File(this.path)), new DistanceToPowerHeuristic(2));

        printPath(last);
        while (flag) {
            try {

                if (last.getParent() != null) {
                    if(this.buttons.size() == 4){
                        buttons.get(0).setText(String.valueOf(last.getNumbers()[0][0]));
                        buttons.get(1).setText(String.valueOf(last.getNumbers()[0][1]));
                        buttons.get(2).setText(String.valueOf(last.getNumbers()[1][0]));
                        buttons.get(3).setText(String.valueOf(last.getNumbers()[1][1]));
                    }
                    if(this.buttons.size() == 9){
                        buttons.get(0).setText(String.valueOf(last.getNumbers()[0][0]));
                        buttons.get(1).setText(String.valueOf(last.getNumbers()[0][1]));
                        buttons.get(2).setText(String.valueOf(last.getNumbers()[0][2]));
                        buttons.get(3).setText(String.valueOf(last.getNumbers()[1][0]));
                        buttons.get(4).setText(String.valueOf(last.getNumbers()[1][1]));
                        buttons.get(5).setText(String.valueOf(last.getNumbers()[1][2]));
                        buttons.get(6).setText(String.valueOf(last.getNumbers()[2][0]));
                        buttons.get(7).setText(String.valueOf(last.getNumbers()[2][1]));
                        buttons.get(8).setText(String.valueOf(last.getNumbers()[2][2]));
                    }
                    if(this.buttons.size() == 16){
                        buttons.get(0).setText(String.valueOf(last.getNumbers()[0][0]));
                        buttons.get(1).setText(String.valueOf(last.getNumbers()[0][1]));
                        buttons.get(2).setText(String.valueOf(last.getNumbers()[0][2]));
                        buttons.get(3).setText(String.valueOf(last.getNumbers()[0][3]));
                        buttons.get(4).setText(String.valueOf(last.getNumbers()[1][0]));
                        buttons.get(5).setText(String.valueOf(last.getNumbers()[1][1]));
                        buttons.get(6).setText(String.valueOf(last.getNumbers()[1][2]));
                        buttons.get(7).setText(String.valueOf(last.getNumbers()[1][3]));
                        buttons.get(8).setText(String.valueOf(last.getNumbers()[2][0]));
                        buttons.get(9).setText(String.valueOf(last.getNumbers()[2][1]));
                        buttons.get(10).setText(String.valueOf(last.getNumbers()[2][2]));
                        buttons.get(11).setText(String.valueOf(last.getNumbers()[2][3]));
                        buttons.get(12).setText(String.valueOf(last.getNumbers()[3][0]));
                        buttons.get(13).setText(String.valueOf(last.getNumbers()[3][1]));
                        buttons.get(14).setText(String.valueOf(last.getNumbers()[3][2]));
                        buttons.get(15).setText(String.valueOf(last.getNumbers()[3][3]));
                    }
                    if(this.buttons.size() == 25){
                        buttons.get(0).setText(String.valueOf(last.getNumbers()[0][0]));
                        buttons.get(1).setText(String.valueOf(last.getNumbers()[0][1]));
                        buttons.get(2).setText(String.valueOf(last.getNumbers()[0][2]));
                        buttons.get(3).setText(String.valueOf(last.getNumbers()[0][3]));
                        buttons.get(4).setText(String.valueOf(last.getNumbers()[0][4]));
                        buttons.get(5).setText(String.valueOf(last.getNumbers()[1][0]));
                        buttons.get(6).setText(String.valueOf(last.getNumbers()[1][1]));
                        buttons.get(7).setText(String.valueOf(last.getNumbers()[1][2]));
                        buttons.get(8).setText(String.valueOf(last.getNumbers()[1][3]));
                        buttons.get(9).setText(String.valueOf(last.getNumbers()[1][4]));
                        buttons.get(10).setText(String.valueOf(last.getNumbers()[2][0]));
                        buttons.get(11).setText(String.valueOf(last.getNumbers()[2][1]));
                        buttons.get(12).setText(String.valueOf(last.getNumbers()[2][2]));
                        buttons.get(13).setText(String.valueOf(last.getNumbers()[2][3]));
                        buttons.get(14).setText(String.valueOf(last.getNumbers()[2][4]));
                        buttons.get(15).setText(String.valueOf(last.getNumbers()[3][0]));
                        buttons.get(16).setText(String.valueOf(last.getNumbers()[3][1]));
                        buttons.get(17).setText(String.valueOf(last.getNumbers()[3][2]));
                        buttons.get(18).setText(String.valueOf(last.getNumbers()[3][3]));
                        buttons.get(19).setText(String.valueOf(last.getNumbers()[3][4]));
                        buttons.get(20).setText(String.valueOf(last.getNumbers()[4][0]));
                        buttons.get(21).setText(String.valueOf(last.getNumbers()[4][1]));
                        buttons.get(22).setText(String.valueOf(last.getNumbers()[4][2]));
                        buttons.get(23).setText(String.valueOf(last.getNumbers()[4][3]));
                        buttons.get(24).setText(String.valueOf(last.getNumbers()[4][4]));
                    }
                    printPath(last.getParent());
                }

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SolvePuzzle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.flag = false;
        }
    }
}
