/*
2 Name: Abigail Natucci
3 Assignment: Lab07
7 Sources consulted: BFS algorithm, Course textbook
10 */

public class QueueMazeSolver implements MazeSolver {

    private MazeGUI gui;

    public static class Cell{
        private int r;
        private int c;

        public Cell(int row, int col){
            r = row;
            c = col;
        }

        public String toString(){
            return "(" + r + ", " + c + ")";
        }
    }
    public QueueMazeSolver(){
        gui = new MazeGUI( this );
    }
    @Override
    public void solve(char[][] maze, int startR, int startC, int endR, int endC) {
        ArrayQueue<Cell> agenda = new ArrayQueue<>();
        Cell start = new Cell(startR, startC);
        Cell current;
        Cell end = new Cell(endR, endC);
        agenda.offer(start);
        gui.setStatusText("maze is unsolvable");
        while (!agenda.isEmpty()) {
            current = agenda.poll();
            if (current.toString().equals(end.toString())) {
                maze[end.r][end.c] = '@';
                gui.setStatusText("Maze is solvable");
                agenda.clear();
            }
            else {
                if(maze[current.r-1][current.c] == ' ') {
                    Cell left = new Cell(current.r-1, current.c);
                    maze[left.r][left.c] = '@';
                    agenda.offer(left);
                }
                if(maze[current.r+1][current.c] == ' ') {
                    Cell right = new Cell(current.r+1, current.c);
                    maze[right.r][right.c] = '@';
                    agenda.offer(right);
                }
                if(maze[current.r][current.c+1] == ' ') {
                    Cell above = new Cell(current.r, current.c + 1);
                    maze[above.r][above.c] = '@';
                    agenda.offer(above);
                }
                if(maze[current.r][current.c-1] == ' ') {
                    Cell below = new Cell(current.r, current.c -1);
                    maze[below.r][below.c] = '@';
                    agenda.offer(below);
                }
            }
            System.out.println(agenda);
            gui.drawMaze(maze);
        }
    }

    public static void main( String[] args ) {
        new QueueMazeSolver();
    }
}
